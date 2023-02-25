const loginForm = document.querySelector('form');
const emailInput = document.querySelector('input[type="email"]');
const passwordInput = document.querySelector('input[type="password"]');
const loginButton = document.querySelector('#login-button');

loginForm.addEventListener('submit', (event) => {
    event.preventDefault();
    
    const email = emailInput.value;
    const password = passwordInput.value;
    
    const loginData = { email, password };
    
    fetch('http://127.0.0.1:8080/teacher/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(loginData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(response.status);
        }
        return response.json();
    })
    .then(data => {
        sessionStorage.setItem('user', JSON.stringify(data));
        window.location.href = '/dashboard';
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Incorrect email or password.');
    });
});