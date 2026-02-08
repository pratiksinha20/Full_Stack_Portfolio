let count = 0;
const button = document.querySelector('#apply');
const display = document.querySelector('#count');

const applyButton = document.querySelector('#apply1');
const applyDisplay = document.querySelector('#apply');  

const applyBtn = document.querySelector('#applyBtn');
const applySection = document.querySelector('#applySection');

// const sunbtn=document.querySelector('#sun');
// const moonbtn=document.querySelector('#moon');

const toggle = document.querySelector('#sun');
    toggle.addEventListener('change', function() {
      if (toggle.checked) {
        document.body.style.backgroundColor = "#222"; // dark mode
        document.body.style.color = "white";
      } else {
        document.body.style.backgroundColor = "white"; // light mode
        document.body.style.color = "black";
      }
});

applyBtn.addEventListener('click', function() {
  applySection.style.display = 'block'; // show the section only after click
  window.scrollTo({ top: 0, behavior: 'smooth' }); // scroll to top so it appears above
});




button.addEventListener('click', function() {
   count++;
   display.textContent = count; // update the span with new count
});

applyButton.addEventListener('click', function() {
   if(applyDisplay.style.display==='none')
   {
    applyDisplay.style.display='block';
   }
   else{
    applyButton.style.display='none';
   }
});
