
let Edit_URL = '/application/ClimbingTracker/updateClimber/';
function edit_row(no)
{
    document.getElementById("Edit" + no).style.display="none";
    document.getElementById("Del" + no).style.display="none";
    document.getElementById("Save"+no).style.display="block";

    let username=document.getElementById("Username"+no);
    let firstname=document.getElementById("Firstname"+no);
    let surname=document.getElementById("Surname"+no);

    let username_data=username.innerHTML;
    let firstname_data=firstname.innerHTML;
    let surname_data=surname.innerHTML;

    username.innerHTML="<input type='text' id='Username_input"+no+"' value='"+username_data+"'>";
    firstname.innerHTML="<input type='text' id='Firstname_input"+no+"' value='"+firstname_data+"'>";
    surname.innerHTML="<input type='text' id='Surname_input"+no+"' value='"+surname_data+"'>";
}
function save_row(no)
{

    let username=document.getElementById("Username_input"+no).value;
    let firstname=document.getElementById("Firstname_input"+no).value;
    let surname=document.getElementById("Surname_input"+no).value;

    document.getElementById("Username_input"+no).innerHTML=username;
    document.getElementById("Firstname_input"+no).innerHTML=firstname;
    document.getElementById("Surname_input"+no).innerHTML=surname;

    document.getElementById("Edit"+no).style.display="block";
    document.getElementById("Del"+no).style.display="block";
    document.getElementById("Save"+no).style.display="none";

    axios.put(Edit_URL + no,{
        username: username,
        firstname: firstname,
        surname: surname
       }).then(function (response) {
        console.log(response);
        location.reload();
    })
        .catch(function (error) {
            console.log(error);
        });
}
