let BASE_URL = 'http://localhost:8080/demo/climberapp/DeleteClimber/';
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
