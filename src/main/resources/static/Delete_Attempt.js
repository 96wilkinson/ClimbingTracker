let BASE_URL = '/ClimbingTracker/ClimbingTracker/DeleteClimbingAttempt/';
Remove_Attempt = function(event){
    event.preventDefault();
    id = this.id;
    console.log(id)
    id = this.id.slice(-1);
    console.log(id)

    axios.delete(BASE_URL+id/*, {data:{id:id}}*/)
        .then(function (response) {
            console.log("Deleted Attempt with ID of" + id)
            console.log(response);
            location.reload();
        })
        .catch(function (error) {
            console.log(error);
        });

}
