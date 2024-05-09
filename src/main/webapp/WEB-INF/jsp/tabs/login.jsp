<!DOCTYPE html>
<html>
    <head id="login">
        <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
        <jsp:include page="/WEB-INF/jsp/common/header.jsp"/>
        <jsp:include page="/WEB-INF/jsp/common/footer.jsp"/>
    </head>

    <body>
        <h3><center>Log-In</center></h3>

        <br><br><br>

        <form method="POST" action="/login" modelAttribute="login" name="loginform" autocomplete="off">
            <table class="center">
                <tr>
                    <td><label path="username">User ID</label></td>
                    <td><input name="username" maxlength="30"/></td>
                </tr>
                <tr>
                    <td><label text-align="center" path="password">Password</label></td>
                    <td><input maxlength="30" type="password" name="password"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right"><input type="submit" value="Sign In"/>
                </tr>
                <tr>
                    <td>
                </tr>
            </table>
        </form>
    </body>
</html>