$(document).ready(() => {
    let movieToEdit;

    $('#add-button-modal').click(() => {
        //extragem valorile introduse in modal
        const name = $('#modal-name').val();
        const rezervation = $('#modal-rezervation').val();
        const type = $('#modal-type').val();

        //construim noul obiect transaction din modal
        const newMovie = {
            name: name,
            rezervation: rezervation,
            type: type
        };

        if (movieToEdit == null) {
            addMovie(newMovie);
        } else {
            editMovie(movieToEdit, newMovie)
        }
    });

    function editMovie(id, newMovie) {
        fetch('api/movies/' + id, {
            method: 'PUT',
            body: JSON.stringify(newMovie),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("There are errors " + response.status);
            }
        });
    }

    function addMovie(newMovie) {
        fetch('api/movies', {
            method: 'POST',
            body: JSON.stringify(newMovie),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("There are errors " + response.status);
            }
        });
    }

    $('.edit-icon').click(function () {
        //extragem id-ul din html, de pe parintele iconitei de edit
        movieToEdit = this.parentElement.id;
        //extragem elementul din html care reprezinta randul unui tabel
        const row = this.parentElement.parentElement;
        //extragem textul din prima casuta din row
        const name = row.children[0].innerText;
        const type = row.children[1].innerText;
        const rezervation = row.children[2].innerText;

        //setam valoarea in html pt modal
        $('#modal-name').val(name);
        $('#modal-rezervation').val(rezervation);
        $('#modal-type').val(type);
    });

    $('.delete-icon').click(function () {
        const movieId = this.parentElement.id;

        fetch('api/movies/' + movieId, {
            method: 'DELETE'
        }).then(response => location.reload());
    });

    $('#add-movie-button').click(function () {
        movieToEdit = null;
        clearModal();
    });

    function clearModal() {
        $('#modal-name').val('');
        $('#modal-rezervation').val('');
        $('#modal-type').val('');
    }
});