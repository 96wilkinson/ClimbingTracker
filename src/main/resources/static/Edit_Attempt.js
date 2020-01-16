
let Edit_URL = 'http://3.10.92.183:8181/climberapp/updateClimbingAttempt/';
function edit_row(no)
{

    document.getElementById("Edit" + no).style.display="none";
    document.getElementById("Del" + no).style.display="none";
    document.getElementById("Save"+no).style.display="block";

    let day=document.getElementById("Day"+no);
    let month=document.getElementById("Month"+no);
    let year=document.getElementById("Year"+no);
    let difficulty=document.getElementById("Difficulty"+no);
    let timeSpent=document.getElementById("TimeSpent"+no);

    let dayData=day.innerHTML;
    let monthData=month.innerHTML;
    let yearData=year.innerHTML;
    let difficultyData=difficulty.innerHTML;
    let timeSpentData=timeSpent.innerHTML;

    day.innerHTML="<input type='text' id='DayInput"+no+"' value='"+dayData+"'>";
    month.innerHTML="<input type='text' id='MonthInput"+no+"' value='"+monthData+"'>";
    year.innerHTML="<input type='text' id='YearInput"+no+"' value='"+yearData+"'>";
    difficulty.innerHTML="<input type='text' id='DifficultyInput"+no+"' value='"+difficultyData+"'>";
    timeSpent.innerHTML="<input type='text' id='TimeSpentInput"+no+"' value='"+timeSpentData+"'>";
}
function save_row(no)
{
    let day=document.getElementById("DayInput"+no).value;
    let month=document.getElementById("MonthInput"+no).value;
    let year=document.getElementById("YearInput"+no).value;
    let difficulty=document.getElementById("DifficultyInput"+no).value;
    let timeSpent=document.getElementById("TimeSpentInput"+no).value;

    document.getElementById("DayInput"+no).innerHTML=day;
    document.getElementById("MonthInput"+no).innerHTML=month;
    document.getElementById("YearInput"+no).innerHTML=year;
    document.getElementById("DifficultyInput"+no).innerHTML=difficulty;
    document.getElementById("TimeSpentInput"+no).innerHTML=timeSpent;

    document.getElementById("Edit"+no).style.display="block";
    document.getElementById("Del"+no).style.display="block";
    document.getElementById("Save"+no).style.display="none";

    axios.put(Edit_URL + no,{
        day: day,
        month: month,
        year: year,
        difficulty: difficulty,
        timeSpent: timeSpent
       }).then(function (response) {
        console.log(response);
        location.reload();
    })
        .catch(function (error) {
            console.log(error);
        });
}
