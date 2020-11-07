document.querySelector('#tap').addEventListener('click', function(e) {



    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/chatMain');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send('login=' + e.target.id);
    xhr.onreadystatechange = function() {
        let a = document.getElementsByClassName("chat_ul");
        for (let j = 0; j < a.length; j++) {
            let description = a[j];
            description.remove();
        }

        if (xhr.readyState === 4 && xhr.status === 200) {
            let responseText = xhr.responseText;

            let splitText = responseText.split("33211");

            for (let i = splitText.length - 1; i >= 0; i--) {

                let splitMessage = splitText[i].split('3321');
                if (splitMessage[0].length > 0) {

                    if(splitMessage[0] === e.target.id){
                        document.querySelector("#chat").insertAdjacentHTML("afterbegin", '<ul class="chat_ul"><li class=\"you\"><div class=\"triangle\"></div><div class=\"message\" id="messageDiv">' +splitMessage[0] + ":<br>" + splitMessage[1] + '</div></li></ul>');
                        document.querySelector(".chat_ul").block.scrollHeight;
                    }
                    else document.querySelector("#chat").insertAdjacentHTML("afterbegin", '<ul class="chat_ul"><li class=\"me\"><div class=\"triangle\"></div><div id="messageDiv">' + e.target.id +'</div><div class=\"message\">'+splitMessage[0] + ":<br>" + splitMessage[1] + '</div></li></ul>')
                }
            }

        }

    };
});

