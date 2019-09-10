<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css">
</head>

<body>

    <div class="main">

        <!-- Sign in form -->
         <section class="sign-in">
                   <div class="container">
                       <div class="signin-content">
                           <div class="signin-image">
                               <figure><img src="images/signin-image.jpg" alt="sing up image"></figure>
                           </div>
                           <div class="signin-form">
                               <h2 class="form-title">Sign in</h2>

                               <form action="${pageContext.request.contextPath}/signin" method="POST" class="register-form" id="login-form">
                                   <div class="form-group">
                                   <p>${requestScope.success}</p>
                                       <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                       <input type="text" name="username" id="your_name" placeholder="Your Name"/>
                                   </div>
                                   <div class="form-group">
                                       <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                       <input type="password" name="password" id="your_pass" placeholder="Password"/>
                                   </div>
                                   <div class="form-group form-button">
                                       <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                                       <br> <br>
                                       <a href="signup">Don't have an account yet?</a>
                                   </div>
                               </form>
                           </div>
                       </div>
                   </div>
               </section>

</body>
</html>