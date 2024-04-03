package com.reservations.reservations.services.unit_tests;

import com.reservations.reservations.exceptions.GeneralException;
import com.reservations.reservations.models.Location;
import com.reservations.reservations.repositories.LocationRepository;
import com.reservations.reservations.services.LocationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LocationServiceTests {

    @InjectMocks
    private LocationService locationService;

    @Mock
    private LocationRepository locationRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave_LocationValid() throws GeneralException {
        Location validLocation = new Location();
        validLocation.setAddress("123 Rue de Test");

        when(locationRepository.existsByAddress(validLocation.getAddress())).thenReturn(false);
        when(locationRepository.save(Mockito.any(Location.class))).thenReturn(validLocation);
        Location savedLocation = locationService.save(validLocation);
        verify(locationRepository, times(1)).save(validLocation);
        Assertions.assertEquals(validLocation, savedLocation);
    }

    @Test
    public void testSave_LocationWithBlankAddress() {
        Location locationWithBlankAddress = new Location();
        Assertions.assertThrows(GeneralException.class, () -> {
            locationService.save(locationWithBlankAddress);
        });
        verify(locationRepository, never()).save(locationWithBlankAddress);
    }

    @Test
    public void testSave_LocationWithExistingAddress() {
        Location locationWithExistingAddress = new Location();
        locationWithExistingAddress.setAddress("123 Rue de Test");
        when(locationRepository.existsByAddress(locationWithExistingAddress.getAddress())).thenReturn(true);
        Assertions.assertThrows(GeneralException.class, () -> {
            locationService.save(locationWithExistingAddress);
        });
        verify(locationRepository, never()).save(locationWithExistingAddress);
    }

    @Test
    public void testUpdate_LocationFound() throws GeneralException {
        Location locationToUpdate = new Location();
        locationToUpdate.setId(1L);
        locationToUpdate.setAddress("123 Rue de Test");
        Location existingLocation = new Location();
        existingLocation.setId(1L);

        when(locationRepository.findById(locationToUpdate.getId())).thenReturn(Optional.of(existingLocation));

        when(locationRepository.findByAddress(locationToUpdate.getAddress())).thenReturn(null);
        when(locationRepository.save(Mockito.any(Location.class))).thenReturn(existingLocation);

        Location updatedLocation = locationService.update(locationToUpdate);
        verify(locationRepository, times(1)).save(existingLocation);
        Assertions.assertEquals(existingLocation, updatedLocation);
    }

    @Test
    public void testUpdate_LocationNotFound() {
        // Créer une location à mettre à jour sans ID
        Location locationToUpdate = new Location();
        locationToUpdate.setAddress("123 Rue de Test");

        // Appeler la fonction update avec la location à mettre à jour sans ID
        Assertions.assertThrows(GeneralException.class, () -> {
            locationService.update(locationToUpdate);
        });

        // Vérifier que la méthode save du mock repository n'a pas été appelée
        verify(locationRepository, never()).save(any(Location.class));
    }

    @Test
    public void testUpdate_NewLocationAlreadyExists() {
        // Créer une location à mettre à jour avec un ID valide
        Location locationToUpdate = new Location();
        locationToUpdate.setId(1L);
        locationToUpdate.setAddress("123 Rue de Test");

        // Créer une location existante avec une adresse différente
        Location existingLocation = new Location();
        existingLocation.setId(2L);
        existingLocation.setAddress("456 Rue de Test");

        // Configurer le comportement du mock repository pour retourner la location existante lors de la recherche par ID
        when(locationRepository.findById(locationToUpdate.getId())).thenReturn(Optional.of(existingLocation));

        // Configurer le comportement du mock repository pour retourner une autre location lors de la recherche par adresse
        when(locationRepository.findByAddress(locationToUpdate.getAddress())).thenReturn(new Location());

        // Appeler la fonction update avec la location à mettre à jour
        Assertions.assertThrows(GeneralException.class, () -> {
            locationService.update(locationToUpdate);
        });

        // Vérifier que la méthode save du mock repository n'a pas été appelée
        verify(locationRepository, never()).save(any(Location.class));
    }

    @Test
    public void testDelete_LocationFound() throws GeneralException {
        // Définir l'ID de la location à supprimer
        Long locationId = 1L;

        // Configurer le comportement du mock repository pour retourner true lors de la vérification de l'existence par ID
        when(locationRepository.existsById(locationId)).thenReturn(true);

        // Appeler la méthode delete avec l'ID de la location à supprimer
        locationService.delete(locationId);

        // Vérifier si la méthode deleteById du mock repository a été appelée avec l'ID de la location à supprimer
        verify(locationRepository, times(1)).deleteById(locationId);
    }

    @Test
    public void testDelete_LocationNotFound() {
        // Définir un ID de location inexistant
        Long locationId = 1L;

        // Configurer le comportement du mock repository pour retourner false lors de la vérification de l'existence par ID
        when(locationRepository.existsById(locationId)).thenReturn(false);

        // Appeler la méthode delete avec l'ID de la location inexistante
        Assertions.assertThrows(GeneralException.class, () -> {
            locationService.delete(locationId);
        });

        // Vérifier que la méthode deleteById du mock repository n'a pas été appelée
        verify(locationRepository, never()).deleteById(anyLong());
    }

    @Test
    public void testFindById_LocationFound() {
        // Définir l'ID de la location à trouver
        Long locationId = 1L;

        // Créer une location existante avec l'ID donné
        Location existingLocation = new Location();
        existingLocation.setId(locationId);

        // Configurer le comportement du mock repository pour retourner la location existante lors de la recherche par ID
        when(locationRepository.findById(locationId)).thenReturn(Optional.of(existingLocation));

        // Appeler la méthode findById avec l'ID de la location à trouver
        Location foundLocation = locationService.findById(locationId);

        // Vérifier que la méthode findById du mock repository a été appelée une seule fois avec l'ID de la location à trouver
        verify(locationRepository, times(1)).findById(locationId);

        // Vérifier si la location retournée est la même que la location existante
        Assertions.assertEquals(existingLocation, foundLocation);
    }

    @Test
    public void testFindById_LocationNotFound() {
        Long locationId = 1L;
        when(locationRepository.findById(locationId)).thenReturn(Optional.empty());
        Location foundLocation = locationService.findById(locationId);
        verify(locationRepository, times(1)).findById(locationId);
        Assertions.assertNull(foundLocation);
    }


}
