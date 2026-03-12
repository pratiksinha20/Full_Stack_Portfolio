function addBookmark(){

 let input = document.getElementById("bookmarkInput")
 let list = document.getElementById("bookmarkList")

 let li = document.createElement("li")

 li.textContent = input.value

 let deleteBtn = document.createElement("button")
 deleteBtn.textContent = "Delete"

 deleteBtn.onclick = function(){
   li.remove()
 }

 li.appendChild(deleteBtn)

 list.appendChild(li)

 input.value = ""

}