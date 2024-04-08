package com.reservations.reservations.controllers;

import com.reservations.reservations.models.RepresentationUser;
import com.reservations.reservations.repositories.RepresentationUserRepository;
import com.reservations.reservations.repositories.ShowRepository;
import com.reservations.reservations.services.RepresentationService;
import com.reservations.reservations.services.RepresentationUserService;
import com.reservations.reservations.services.UserService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.model.checkout.Session;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RepresentationController {

    @Autowired
    RepresentationService representationService;

    @Autowired
    RepresentationUserService representationUserService;

    @Autowired
    RepresentationUserService representationUserRepository;

    @Autowired
    RepresentationUserRepository ruRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserService userService;

    @GetMapping("/representations/{id}")
    public String show(@PathVariable Long id, ModelMap model) {
        model.addAttribute("representation", representationService.findById(id));
        return "representations/show"; // Returns the template name "index"
    }

    @GetMapping("/representations/{id}/places")
    public String places(@PathVariable Long id, ModelMap model) {
        model.addAttribute("representation", representationService.findById(id));
        return "representations/places"; // Returns the template name "index"
    }

    @GetMapping("/representations/{id}/pay")
    public String pay(@PathVariable Long id,  @AuthenticationPrincipal User user, @RequestParam Integer numberOfPlace, ModelMap model) {
        var representation = representationService.findById(id);
        var u = userService.findByLogin(user.getUsername());
        var ru = new RepresentationUser();
        ru.setUser(u);
        ru.setPaid(false);
        ru.setRepresentation(representation);
        ru.setNumberOfPlace(numberOfPlace);
        ruRepository.save(ru);
        model.addAttribute("representation_user", ru);
        return "representations/pay"; // Returns the template name "index"
    }

    @PostMapping("/representations/payment-create")
    @ResponseBody
    public Map<String, String> processPayment(@RequestParam Long id, ModelMap model) throws StripeException {
        Stripe.apiKey = "sk_test_51OzQlP00c6h81w5Cd5Y60MsanmgetDtRReD3rv1g4QGguPMP4y66oPB4gukdU1oLD6sHsWL8GM9kOfPLyZKDCrWZ002aPMUDQ4";
        var ru = representationUserService.findById(id);
        var representation = ru.getRepresentation();
        var numberOfPlace = ru.getNumberOfPlace();
        var show = representation.getShow();

        var productId = show.getStripeProductId();

        if (productId == null || productId.equals("")) {
            ProductCreateParams params = ProductCreateParams.builder().setName(show.getTitle() + show.getId()).build();
            Product product = Product.create(params);
            productId = product.getId();
            show.setStripeProductId(productId);
            showRepository.save(show);
        }

        PriceCreateParams params2 =
                PriceCreateParams.builder()
                        .setCurrency("eur")
                        .setUnitAmount((long) (show.getPrice() * 100))
                        .setProduct(productId)
                        .build();
        Price price = Price.create(params2);

        SessionCreateParams params3 =
                SessionCreateParams.builder()
                        .setUiMode(SessionCreateParams.UiMode.EMBEDDED)
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setReturnUrl("http://localhost:8080" + "/payment-after?session_id={CHECKOUT_SESSION_ID}&id=" + ru.getId())
                        .addLineItem(
                                SessionCreateParams.LineItem.builder()
                                        .setQuantity(Long.valueOf(numberOfPlace))
                                        // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
                                        .setPrice(price.getId())
                                        .build())
                        .build();

        Session session = Session.create(params3);

        HashMap<String, String> map = new HashMap<>();
        map.put("clientSecret", session.getRawJsonObject().getAsJsonPrimitive("client_secret").getAsString());
        return map;

    }

    @GetMapping("/payment-after")
    public RedirectView getSessionStatus(RedirectAttributes redirectAttributes, @AuthenticationPrincipal User user, @RequestParam String session_id, @RequestParam Long id) throws StripeException {
        Stripe.apiKey = "sk_test_51OzQlP00c6h81w5Cd5Y60MsanmgetDtRReD3rv1g4QGguPMP4y66oPB4gukdU1oLD6sHsWL8GM9kOfPLyZKDCrWZ002aPMUDQ4";

        Session session = Session.retrieve(session_id);
        var ru = representationUserService.findById(id);

        if (session.getStatus().equals("complete")) {

            ru.setPaid(true);
            ruRepository.save(ru);
            redirectAttributes.addFlashAttribute("message_success", "Votre paiement à été exécuté avec succès!");
            return new RedirectView("/");
        }
        redirectAttributes.addFlashAttribute("message_danger", "Votre paiement à échoué!");
        return new RedirectView("/");
    }

}
