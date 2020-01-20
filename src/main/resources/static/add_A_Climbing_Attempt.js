const Add_Attempt_form = document.getElementById("Input_Attempt");
let BASE_URL = 'http://3.10.92.183:8080/ClimbingTracker/ClimbingTracker/';


Add_Attempt_form.onsubmit = function(event) {
    event.preventDefault();
    let formData = new FormData(document.getElementById("Input_Attempt"));
    axios.defaults.headers.post["Content-Type"] = "application/json";
    axios.post(BASE_URL + 'createClimbingAttempt', {
        day: this.day.value,
        month: this.month.value,
        year: this.year.value,
        difficulty: this.difficulty.value,
        timeSpent: this.timeSpent.value
    })
        .then(function (response) {
            console.log(response);
            location.reload();
        })
        .catch(function (error) {
            console.log(error);
        });
}
