<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit todo</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>

    <div class = "container">

        <p>${requestScope.message}</p>
        <form action="${pageContext.request.contextPath}/TodoController" method="POST">
            Input todo: <input type = "text" name = "todoname" > <br>
            Input is complete/not:
            <input type = "radio" name = "completed" value = "false" checked> NO
            <input type = "radio" name = "completed" value = "true" checked> YES <br>
            Input due date: <input type = "date" name = "active"> <br>
            <button class = "btn btn-primary" type ="submit"> Save todo </button>
        </form>
    </div>

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>