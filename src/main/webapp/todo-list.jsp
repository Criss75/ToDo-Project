<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="CSS/main.css">
    <link href="https://fonts.googleapis.com/css?family=Dosis&display=swap" rel="stylesheet">
    <link rel="icon" type="image/png" href="favicon-32x32.png">
</head>
<body id = "laptop-img1">

        <header id = "sp-header">
           <a href="http://localhost:8080/ToDov2/logout" id="logout">Logout</a>
        </header>
        </br>
        </br>
        </br>
        </br>
        </br>
    <div class = "container">
        <a href = "${pageContext.request.contextPath}/todo?action=ADD">
            <button class = "btn btn-primary">Add todo</button>
        </a>
        </br>
        </br>
        <table border ="2" class="table table-striped table-dark">

            <tr class = "thead-dark">
                <th>Title</th>
                <th>Is complete</th>
                <th>Active</th>
                <th>Actions</th>

            <c:forEach items="${list}" var = "todo">
                <tr>
                    <td>${todo.title}</td>
                    <td>${todo.complete}</td>
                    <td>${todo.active}</td>
                    <td>
                    <a href="${pageContext.request.contextPath}/todo?action=EDIT&todo_id=${todo.todoId}">Edit</a>
                    //
                    <a href="${pageContext.request.contextPath}/todo?action=DELETE&todo_id=${todo.todoId}"
                    onclick="return confirm('Are you sure you want to delete this item?')">Delete</a>
                    </td>
                </tr>

            </c:forEach>

            </tr>

        </table>

        <p>${requestScope.message}</p>

    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>