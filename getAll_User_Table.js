axios.get('/ClimbingTracker/ClimbingTracker/getAll').then (({data: myClimbers}) =>{
    //
    let numOfclimbers = myClimbers.length;
    //create a table if there exists more than one climber
    if(numOfclimbers>0){
        //create the table
        let table = document.createElement("table");
        table.id = "UsersTable";
        table.className = "UsersTable";
        //get the column headers
        let columns = []
        for (let i=0; i < numOfclimbers; i++) {
            for( let key in myClimbers[i]){
                if (columns.indexOf(key) ===-1) {
                    columns.push(key);
                }
            }
        }

        let tableHead = document.createElement("thead");
        let headRow = document.createElement("tr");
        //add header to row of table head
        for (let i = 0; i < columns.length+1; i++) {
            let th = document.createElement("th");
            switch(columns[i]) {
                case "username":
                  var Coulumn_header = "Username";
                  Coulumn_header.id = Coulumn_header;
                  break;
                case "firstname":
                  var Coulumn_header = "Firstname";
                    Coulumn_header.id = Coulumn_header;
                  break;
                case "surname":
                  var Coulumn_header = "Surname";
                    Coulumn_header.id = Coulumn_header;
                  break;
                case "id":
                  var Coulumn_header = "Climber_ID";
                    Coulumn_header.id = Coulumn_header;
                  break;
                case "climbingAttempts":
                    var Coulumn_header = "Climbing_Attempts";
                        Coulumn_header.id = Coulumn_header;
                    break;
                default:
                  var Coulumn_header = "Manage User";
                  break;

              }
              th.innerHTML = Coulumn_header;
              th.id = Coulumn_header
              headRow.appendChild(th);
        }
        tableHead.appendChild(headRow);
        table.appendChild(tableHead);

        // CREATE TABLE BODY .
		let tBody = document.createElement("tbody");

			
		// ADD COLUMN HEADER TO ROW OF TABLE HEAD.
		for (let i = 0; i < myClimbers.length; i++) {
			let bRow = document.createElement("tr"); // CREATE ROW FOR EACH RECORD .
            bRow.className = "TableRow";
            let User_id = myClimbers[i][columns[0]];

			for (let j = 0; j < columns.length; j++) {
                let td = document.createElement("td");
                td.innerHTML = myClimbers[i][columns[j]];
                td.className = "TableElement";
                switch (j){
                    case j = 0:
                        y = "Climber_ID";
                    break;
                    case j = 1:
                        y = "Username";
                    break;
                    case j = 2:
                        y = "Firstname";
                    break;
                    case j = 3:
                        y = "Surname";
                    break;
                    default:
                        y = "Change";
                    break;
                    td.id = y + User_id;
                }
                td.id = y + User_id;
                bRow.appendChild(td);

            }
            //Create a number which gives the same id as the user
            console.log(User_id)

            for (let j = columns.length; j < columns.length+1; j++)    {
                let Del = document.createElement("BUTTON");   // Create a <button> element

                //Create delete button and add functionality
                Del.innerHTML = "Delete This User";
                Del.id = "Del" + (User_id);
                Del.name = Del;
                Del.className = "delete";
                Del.onclick = Remove_User;

                //Add both the edit and delete button to the table within the same element
                bRow.appendChild(Del);//Create a button


            }
			for (let j = columns.length+1; j < columns.length+2; j++) {
                //Create Edit button and add functionality
                let Edit = document.createElement("BUTTON");
                Edit.innerHTML= "Edit This User";
                Edit.id = "Edit"+User_id;
                Edit.name = Edit;
                Edit.className = "edit";
                Edit.addEventListener('click', () => edit_row(User_id))
                bRow.appendChild(Edit);
            }
            for (let j = columns.length+2; j < columns.length+3; j++) {
                //Create Edit button and add functionality
                let Save = document.createElement("BUTTON");
                Save.innerHTML= "Save This User";
                Save.id = "Save"+User_id;
                Save.name = Save;
                Save.className = "save";
                Save.addEventListener('click', () => save_row(User_id))
                bRow.appendChild(Save);
            }
                tBody.appendChild(bRow)
			}
			table.appendChild(tBody);

            divContainer = document.getElementById("myClimbers");
			divContainer.innerHTML = " ";
            divContainer.appendChild(table);
    }
});
