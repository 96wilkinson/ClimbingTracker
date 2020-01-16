let BASE_URL = 'http://3.10.92.183:8181/climberapp/DeleteClimbingAttempt/';
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
