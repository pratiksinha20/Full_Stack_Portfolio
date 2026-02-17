// Toggle background color
const toggleBtn = document.getElementById('toggleBg');
toggleBtn.addEventListener('click', () => {
    document.body.classList.toggle('dark-bg');
    toggleBtn.classList.toggle('active');
});
