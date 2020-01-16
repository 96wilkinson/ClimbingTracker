axios.get('http://3.10.92.183:8181/climberapp/getAllClimbingAttempts').then (({data: myClimbingAttempts}) =>{
    //
    var numOfclimbingAttempts = myClimbingAttempts.length;
    //create a table if there exists more than one climber
    if(numOfclimbingAttempts>0){
        //create the table
        var table = document.createElement("table");
        table.className = "Attempt_Table";
        //get the column headers
        var columns = []
        for (var i=0; i < numOfclimbingAttempts; i++) {
            for( var key in myClimbingAttempts[i]){
                if (columns.indexOf(key) ===-1) {
                    columns.push(key);
                }
            }
        }

        var tableHead = document.createElement("thead");
        var headRow = document.createElement("tr");
        //add header to row of table head
        for (var i = 0; i < columns.length+1; i++) {
            var th = document.createElement("th");
            switch(columns[i]) {
                case "day":
                  var Coulumn_Header = "Day";
                    Coulumn_Header.id=Coulumn_Header;
                  break;
                case "month":
                  var Coulumn_Header = "Month";
                    Coulumn_Header.id=Coulumn_Header;
                  break;
                case "year":
                  var Coulumn_Header = "Year";
                    Coulumn_Header.id=Coulumn_Header;
                  break;
                case "difficulty":
                  var Coulumn_Header = "Difficulty";
                    Coulumn_Header.id=Coulumn_Header;
                  break;
                case "timeSpent":
                    var Coulumn_Header = "Time Spent"
                    Coulumn_Header.id=Coulumn_Header;
                    break;
                case "climbAttemptId":
                    var Coulumn_Header = "Climbing Attempt ID"
                    Coulumn_Header.id=Coulumn_Header;
                    break; 
                default:
                  var Coulumn_Header = " ";
                    Coulumn_Header.id=Coulumn_Header;
                  break;

              }
              th.innerHTML = Coulumn_Header;
            th.id = Coulumn_Header;
              headRow.appendChild(th);
        }
        tableHead.appendChild(headRow);
        table.appendChild(tableHead);

        // CREATE TABLE BODY .
		var tBody = document.createElement("tbody");	
			
		// ADD COLUMN HEADER TO ROW OF TABLE HEAD.
		for (var i = 0; i < myClimbingAttempts.length; i++) {
			var bRow = document.createElement("tr"); // CREATE ROW FOR EACH RECORD .
					
					
			for (var j = 0; j < columns.length; j++) {
				var td = document.createElement("td");
                var Attempt_ID = myClimbingAttempts[i][columns[0]];
				td.innerHTML = myClimbingAttempts[i][columns[j]];
				switch (j){
                    case j =0:
                        table_element_id = "Attempt_ID";
				    break;
                    case j = 1:
                        table_element_id = "Day";
                    break;
                    case j = 2:
                        table_element_id = "Month";
                    break;
                    case j = 3:
                        table_element_id = "Year";
                    break;
                    case j = 4:
                        table_element_id = "Difficulty";
                    break;
                    case j=5:
                        table_element_id = "TimeSpent";
                    break;
                    default:
                        table_element_id = "Edit";
                        break;
                }
                td.id = table_element_id+Attempt_ID;
				bRow.appendChild(td);

			}
            for (var j = columns.length; j < columns.length+1; j++)    {
                var Del = document.createElement("BUTTON");   // Create a <button> element
                let Attempt_ID = myClimbingAttempts[i][columns[0]];
                Del.innerHTML = "Delete This Attempt";
                Del.id = "Del"+Attempt_ID;
                Del.className = "delete";
                Del.onclick = Remove_Attempt;
                var Edit = document.createElement("BUTTON");
                Edit.innerHTML= "Edit This Attempt";
                Edit.id = "Edit"+Attempt_ID;
                Edit.className = "edit";
                Edit.addEventListener('click', () => edit_row(Attempt_ID))
                var Save = document.createElement("BUTTON");
                Save.innerHTML= "Save This User";
                Save.id = "Save"+Attempt_ID;
                Save.className = "save";
                Save.addEventListener('click', () => save_row(Attempt_ID))

                bRow.appendChild(Del);//Create a button
                bRow.appendChild(Edit);
                bRow.appendChild(Save);
            }
			tBody.appendChild(bRow)
 
            }
			table.appendChild(tBody);

            divContainer = document.getElementById("myClimbingAttempts");
			divContainer.innerHTML = " ";
            divContainer.appendChild(table);
    }
});