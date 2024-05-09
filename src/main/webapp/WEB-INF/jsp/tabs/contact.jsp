<html>
    <head id="contact">
        <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
        <jsp:include page="/WEB-INF/jsp/common/header.jsp"/>
        <jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>
    </head>

    <body>
        <h3><center>Contact</center></h3>
        
         <form method="POST" action="/contact" modelAttribute="message" name="contactForm" autocomplete="off">
             <table>
                <tr>
                    <td><label text-align="center" path="userName">Name</label></td>
                    <td><input maxlength="30" name="userName"/></td>
                </tr>
                <tr>
                    <td><label path="email">E-mail</label></td>
                    <td><input name="userEmail" maxlength="30"/></td>
                </tr>
                <tr>
                    <td><label path="userMessage">Message</label></td>
                    <td><textarea name="userMessage" rows="5" cols="30" maxlength="300"></textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right"><input onclick="return validateInput();" type="submit" value="Submit"/>
                </tr>
            </table>
        </form>

        <script type="text/javascript">
            function validateInput(){
                'use strict';
                var nameInput = document.forms['contactForm'].userName.value.trim();
                var emailInput = document.forms['contactForm'].userEmail.value.trim();
                var msgInput = document.forms['contactForm'].userMessage.value.trim();

                if(nameInput=="" || emailInput=="" || msgInput==""){
                    alert("ERROR: Inputs may not be empty.");
                    return false;
                }

                var re = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
                if(!re.test(emailInput)){
                    alert("ERROR: Email is not in correct format.");
                    return false;
                }
            }
        </script>
    </body>
</html>