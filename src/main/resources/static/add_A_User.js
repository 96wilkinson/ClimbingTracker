const Add_User_form = document.getElementById("Input_User");
let BASE_URL = 'http://localhost:8080/demo/climberapp/';

Add_User_form.onsubmit = function(event) {
    event.preventDefault();
    let formData = new FormData(document.getElementById("Input_User"));
    axios.defaults.headers.post["Content-Type"] = "application/json";
    axios.post(BASE_URL + 'createClimber', {
        username: this.Username.value,
        firstname: this.Firstname.value,
        surname: this.Surname.value
    })
        .then(function (response) {
            console.log(response);
            location.reload();
        })
        .catch(function (error) {
            console.log(error);
        });
}


