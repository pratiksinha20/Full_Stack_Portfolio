function addTask() {

    let taskInput = document.getElementById("taskInput")
    let priority = document.getElementById("priority").value
    let taskList = document.getElementById("taskList")

    let li = document.createElement("li")

    li.textContent = taskInput.value + " (" + priority + ")"

    let completeBtn = document.createElement("button")
    completeBtn.textContent = "Complete"

    completeBtn.onclick = function () {
        li.classList.toggle("completed")
    }

    let deleteBtn = document.createElement("button")
    deleteBtn.textContent = "Delete"

    deleteBtn.onclick = function () {
        li.remove()
    }

    li.appendChild(completeBtn)
    li.appendChild(deleteBtn)

    taskList.appendChild(li)

    taskInput.value = ""

}

function filterTasks(type) {

    let tasks = document.querySelectorAll("#taskList li")

    tasks.forEach(function (task) {

        if (type === "all") {
            task.style.display = "block"
        }

        else if (type === "completed") {

            if (task.classList.contains("completed")) {
                task.style.display = "block"
            } else {
                task.style.display = "none"
            }

        }

        else if (type === "pending") {

            if (!task.classList.contains("completed")) {
                task.style.display = "block"
            } else {
                task.style.display = "none"
            }

        }

    })

}