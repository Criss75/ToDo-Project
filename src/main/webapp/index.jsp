<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>To Do List</title>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,300|Roboto:400,300' rel='stylesheet'>
    <link rel="stylesheet" href="CSS/main.css">
    <link rel="stylesheet" media="screen and (max-width: 500px)" href="CSS/mq_500-less_images.css">
    <link rel="stylesheet" media="screen and (min-width: 501px)" href="CSS/mq_501-plus.css">
    <link rel="stylesheet" media="screen and (min-width: 900px)" href="CSS/mq_900-plus.css">
</head>
<body>

<!-- above the fold (atf) -->
<div id="atf">

    <header>
        <a id="logo">TO DO LIST</a>
        <!-- nav desktop (nd) -->
        <ul class="nd">
            <li><a href="signup.jsp">Sign up</a></li>
            <li><a href="signin.jsp">Login</a></li>
        </ul>
    </header>

    <div id="laptop-img"></div>

    <main>
        <!-- edit todos (todo) -->
        <section id="todo">
            <h1 id="todo-txt">Simple TO DO LIST project</h1>
        </section>
    </main>
</div>

<!-- below the fold (btf) -->

<!-- articles -->
<section class="btf-articles">
    <article>
        <h3>Few comments</h3>
        <p>This is a responsive site, created using basic knowledge of HTML, CSS, Javascript and Java</p>
    </article>

    <article>
        <h3>Features</h3>
        <p>You can create a list of todos, add, edit, delete and set-up due dates for your objectives</p>
    </article>
</section>

<!-- footer -->
    <!-- nav mobile (nm) -->
<ul class="nm">
    <li><a href="signup.jsp">Sign up</a></li>
    <li><a href="signin.jsp">Login</a></li>
</ul>

<footer>
<p>Copyright &copy; Cristian Jurescu 2019</p>
</footer>
</body>
</html>