let BASE_URL = 'http://3.10.92.183:8080/ClimbingTracker/ClimbingTracker/DeleteClimber/';
Remove_User = function(event){
    event.preventDefault();
    id = this.id;
    console.log(id)
    id = this.id.slice(-1);
    console.log(id)

    axios.delete(BASE_URL+id/*, {data:{id:id}}*/)
        .then(function (response) {
            console.log("Deleted User with ID of" + id)
            console.log(response);
            location.reload();
        })
        .catch(function (error) {
            console.log(error);
        });
    
}
