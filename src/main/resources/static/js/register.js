$(document).ready(function(){

});

async function register(){
    let data = {};
    data.username = document.getElementById('username').value;
    data.email = document.getElementById('email').value;
    data.phoneNumber = document.getElementById('phoneNumber').value;
    data.password = document.getElementById('password').value;

    let repeatPassword = document.getElementById('confirm-password').value
    if (repeatPassword!= data.password){
        alert('Passwords do not match');
        return;
    }

    const request = await fetch ('api/register', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    alert('Successfully registered!!');
    window.location.href = 'login.html';
}