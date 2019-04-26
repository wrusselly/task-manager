"use strict";


function getAllTasks(){
    let data;
    let url = 'http://localhost:9090/task-tracker/task';
    let request = new XMLHttpRequest();
    request.open('GET', url);
    request.responseType = "json";
    request.onload = function(){
        console.log(request.response);
        data = request.response;
        displayAllTasks(data);
    }
    request.send();
    
}

function displayAllTasks(taskList){
    document.getElementById("task-display").innerHTML="";
    for(let task of taskList){
        for(let key in task){
            if (key=="text"){
                let taskText = document.createElement("h6");
                taskText.innerHTML=task.text;
                document.getElementById("task-display").append(taskText);
            }
            if (key=="dateDueStr"){
                let taskDueDate = document.createElement("p");
                taskDueDate.innerHTML = "Due: " + task.dateDueStr;
                document.getElementById("task-display").append(taskDueDate);
            }
        }
        let updateButton = document.createElement("button");
        updateButton.innerHTML = "update";
        let deleteButton = document.createElement("button");
        deleteButton.innerHTML = "delete";
        document.getElementById("task-display").append(updateButton);
        document.getElementById("task-display").append(deleteButton);
    }
}

function addTask(){
    let url = 'http://localhost:9090/task-tracker/task';
    let request = new XMLHttpRequest();
    request.open('POST', url);
    request.setRequestHeader("Content-Type", "application/json");
    request.setRequestHeader("Accept", "application/json");
    request.responseType = "json";
    let taskText = document.getElementById("text-input").value;
    let dueDate = document.getElementById("date-input").value;
    let task = {
        "text": taskText,
        "dateSetStr": "",
        "dateDueStr": dueDate,
        "dateCompletedStr": null,
        "userId": 1,
        "folderId": null
    };
    task = JSON.stringify(task);
    request.onload = function (){
        console.log(taskText);
        getAllTasks();
    }
    request.send(task);
}

