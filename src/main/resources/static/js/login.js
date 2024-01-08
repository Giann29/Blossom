$(document).ready(function(){
    
});

async function login(){
    let data = {};
    data.username = document.getElementById('username').value;
    data.password = document.getElementById('password').value;

    const request = await fetch ('api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    const response = await request.text();
    if (response != 'FAIL'){
        localStorage.token = response;
        localStorage.username = data.username;
        window.location.href = 'index.html';
    }
    else{
        alert('Invalid username or password');
    }
}