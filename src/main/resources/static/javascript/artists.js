function configureListeners() {
    // Ajout d'un écouteur d'événement pour chaque lien de suppression d'artiste
    let links = document.getElementsByClassName("delete-artist");
    for (const link of links) {
        link.addEventListener("click", (e) => {
            e.preventDefault();
            deleteArtist(link);
        });
    }

    const buttonSubmit = document.getElementById("btn-save-created-artist");
    // Ajout d'un écouteur d'événement pour le bouton de soumission du formulaire lors de la création d'un artiste
    buttonSubmit.addEventListener("click", (event) => {
        event.preventDefault();
        createUser()
    })

    links = document.getElementsByClassName("edit-artist");
    for (const link of links) {
        link.addEventListener("click", (event) => {
            event.preventDefault();
            loadArtistEditForm(event);
        });
    }

    const editButtonSubmit = document.getElementById("btn-save-edited-artist")
    editButtonSubmit.addEventListener("click", (event) => {
        event.preventDefault()
        editArtist()
    })
}

function deleteArtist(link) {
    fetch(`${link.href}`, {
        method: 'DELETE',
    })
    .then(() => {
        link.closest("tr").remove();
    })
    .catch(() => {
        console.log("Une erreur s'est produite");
    });
}

function createUser() {
    const firstnameElement = document.getElementById('firstname');
    const lastnameElement = document.getElementById('lastname');

    const firstname = firstnameElement.value
    const lastname = lastnameElement.value

    const data = { firstname, lastname };

    // Envoi de la requête POST pour créer un nouvel artiste
    fetch('/api/artists', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(response => {
        firstnameElement.value = ""
        lastnameElement.value = ""
        // Ajout de la nouvelle entrée au tableau
        $("table tbody").append(`
            <tr>
                <td>${response.firstname}</td>
                <td>${response.lastname}</td>
                <td>
                    <a href='/admin/artists/${response.id}'>Voir</a>
                    <a href='/api/artists/${response.id}' data-id="${response.id}">Supprimer</a>
                </td>
            </tr>`
        );
    });
}

// c'est cette fonction qui met à jour les données dans le formulaire d'édition d'un artiste
function loadArtistEditForm(event) {
    const tr = event.target.closest("tr");
    const tds = tr.querySelectorAll("td:not(:last-child)");

    document.getElementById('id').value = event.target.dataset.id;
    document.getElementById('firstname-edit').value = tds[0].textContent;
    document.getElementById('lastname-edit').value = tds[1].textContent;
}

// Edition d'un artiste
function editArtist() {
    const id = document.getElementById('id').value;
    const firstname = document.getElementById('firstname-edit').value;
    const lastname = document.getElementById('lastname-edit').value;

    const data = { id, firstname, lastname };

    // Envoi de la requête POST pour créer un nouvel artiste
    fetch('/api/artists', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(response => {
        // Ajout de la nouvelle entrée au tableau
        const table = document.querySelector("table")
        const tr = table.querySelector(`.edit-artist[data-id='${id}']`).closest("tr")
        const tds = tr.querySelectorAll("td:not(:last-child)");
        tds[0].innerText = response.firstname
        tds[1].innerText = response.lastname
    })
}

configureListeners()
