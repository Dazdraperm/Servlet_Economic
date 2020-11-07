document.querySelector('#sendMessage').addEventListener('click', function(e) {
    var userInput = document.getElementById('chat_input').value;
    if(userInput.length > 0) {
        var messageDiv = document.getElementById('messageDiv').textContent;

        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/chat');
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send('login=' + messageDiv.split(":")[0]+'&message=' + userInput);
    }
});