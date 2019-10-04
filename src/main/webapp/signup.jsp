<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form</title>
<link href="https://fonts.googleapis.com/css?family=Dosis&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="CSS/style.css">

</head>

<body>

    <div class="main">

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <p id="msg">${requestScope.error_username}</p>
                        <p id="msg">${requestScope.error_email}</p>
                        <p id="msg">${requestScope.error_password}</p>
                        <br>
                        <form name="contact_form" action="<%= request.getContextPath() %>/signup" method="POST"
                        class="register-form" id="register-form"  onSubmit="return validate_form();">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="username" id="name" placeholder="Your Name">
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" placeholder="Your Email">
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="pass" placeholder="Password">
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password">
                            </div>

                            <div class="form-group form-button">
                                <input type="submit" name="submit" id="signup" class="form-submit" value="Submit">
                                <br>
                                <br>
                                <a href="signin">Already registered? Login...</a>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                    </div>
                </div>
            </div>
        </section>
</body>
<script src="scripts.js"></script>
</html>