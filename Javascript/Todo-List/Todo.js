function addTodo(){

 let input = document.getElementById("todoInput")
 let list = document.getElementById("todoList")

 let li = document.createElement("li")
 li.textContent = input.value

 let btn = document.createElement("button")
 btn.textContent = "Delete"

 btn.onclick = function(){
   li.remove()
 }

 li.appendChild(btn)

 list.appendChild(li)

 input.value = ""

}