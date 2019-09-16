<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
    <div class = "container">
        <button class = "btn btn-primary" onclick = "window.location.href = 'todo-add.jsp'">Add todo</button>
        <table border ="1" class="table table-striped table-dark">

            <tr class = "thead-dark">
                <th>Title</th>
                <th>Is complete</th>
                <th>Active</th>

            <c:forEach items="${list}" var = "todo">
                <tr>
                    <td>${todo.title}</td>
                    <td>${todo.is_complete}</td>
                    <td>${todo.active}</td>
                </tr>

            </c:forEach>

            </tr>

        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>