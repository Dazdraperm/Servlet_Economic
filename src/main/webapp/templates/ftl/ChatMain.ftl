<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Moneysave</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="templates/ftl/css/chatstyle.css" >
  <script src="//js/jquery-3.3.1.slim.min.js" crossorigin="anonymous"></script>
  <script src="//js/popper.min.js" crossorigin="anonymous"></script>
  <script src="//js/bootstrap.min.js" crossorigin="anonymous"></script>

</head>
<body>
<div id="container">
  <aside>
    <header>
      <input type="text" placeholder="search">
    </header>
    <ol class="rectangle">
      <#if chatDtoList??>
<ul id="tap">
        <#list chatDtoList as chat >
          <li id=${chat.getLogin_user()}><a id=${chat.getLogin_user()} class="first" style="font-weight: bold; font-family: 'Open Sans', sans-serif"  href="#">${chat.getLogin_user()}</a><a id=${chat.getLogin_user()} href="#">${chat.getText()}</a></li>
        </#list >

</ul>

      </#if>
    </ol>
  </aside>
  <main>
    <header>
      <div id="showLogin" ></div>

    </header>

    <div id="scroll">
    <ul class="chat_class" id="chat" style="margin-top: -45px;">


    </ul>
    </div>
    <footer>
      <form class="chat_form">
        <input id="chat_input" placeholder="Type your message">
        <button id="sendMessage">Send</button>
      </form>
      <script src="templates/ftl/js/sendMessage.js"></script>
      <script src="templates/ftl/js/showMessage.js"></script>


    </footer>
  </main>
</div>
</body>
</html>