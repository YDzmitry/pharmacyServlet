<%--
  Created by IntelliJ IDEA.
  User: shadow5551
  Date: 14.4.18
  Time: 12.16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8" />
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
    <title>Login and Registration Form with HTML5 and CSS3</title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/loginAndRegistrationPage/registration.css">
</head>
<body>
<div class="container">

    <header>
        <h1><!--Login and Registration Form--></h1>

    </header>
    <section>
        <div id="container_demo" >
            <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
            <a class="hiddenanchor" id="tologin"></a>
            <a class="hiddenanchor" id="toregister"></a>

            <div id="wrapper">
                <div id="login" class="animate form">
                    <form action="LoginServlet" method="post">
                        <h1>Log in</h1>
                        <p>
                            <label for="username" class="uname" > Your email or username </label>
                            <input id="username" name="login" required="required" type="text" placeholder="myusername"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd"> Your password </label>
                            <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" />
                        </p>
                        <p class="signin button">
                            <input type="submit" value="Sign in"/>
                        </p>
                        <p class="change_link">
                            Not a member yet ?
                            <a href="#toregister"  class="to_register">Join us</a>
                        </p>
                    </form>
                </div>

                <div id="register" class="animate form">
                    <form action="RegistrationServlet" method="post">
                        <h1> Sign up </h1>
                        <p>
                            <label for="usernamesignup" class="uname" >Your username</label>
                            <input id="usernamesignup" name="login" required="required" type="text" placeholder="mysuperusername690" />
                            <span style="font-size: large; color: red; "><c:out value="${requestScope.errMessageMap['login']}"> </c:out></span>
                        </p>
                        <p>
                            <label for="passwordsignup" class="youpasswd" > Your password </label>
                            <input id="passwordsignup" name="password" required="required" type="text" placeholder="eg. X8df!90EO"/>
                            <span style="font-size: large; color: red; "><c:out value="${requestScope.errMessageMap['password']}"> </c:out></span>
                        </p>
                        <p>
                            <label for="passportsignup" class="youpassport" > Your passport </label>
                            <input id="passportsignup" name="passport" required="required" type="text" placeholder="eg. MN1234567"/>
                            <span style="font-size: large; color: red; "><c:out value="${requestScope.errMessageMap['passport']}"> </c:out></span>
                        </p>
                        <p class="signin button">
                            <input type="submit" value="Sign up"/>
                        </p>
                        <p class="change_link">
                            Already a member ?
                            <a href="#tologin" class="to_register"> Go and log in </a>
                        </p>
                    </form>
                </div>

            </div>
        </div>
    </section>
</div>
</body>
</html>
