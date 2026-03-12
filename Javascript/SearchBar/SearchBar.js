function searchItem(){

 let input = document.getElementById("search").value.toLowerCase()

 let items = document.querySelectorAll("#list li")

 items.forEach(function(item){

   let text = item.textContent.toLowerCase()

   if(text.includes(input)){
     item.style.display = ""
   }else{
     item.style.display = "none"
   }

 })

}