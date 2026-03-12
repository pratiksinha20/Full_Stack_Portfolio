let images = ["https://upload.wikimedia.org/wikipedia/commons/d/df/Forester_kangaroo_%28Macropus_giganteus_tasmaniensis%29_juvenile_hopping_Esk_Valley.jpg","https://upload.wikimedia.org/wikipedia/commons/7/71/2010-kodiak-bear-1.jpg","https://upload.wikimedia.org/wikipedia/commons/3/36/Axis_axis_%28Nagarhole%2C_2010%29.jpg"]
let index = 0

function show(){
 document.getElementById("slider").src = images[index]
}

function next(){
 index++
 if(index >= images.length) index = 0
 show()
}

function prev(){
 index--
 if(index < 0) index = images.length-1
 show()
}

show()