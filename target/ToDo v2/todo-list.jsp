<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>

</head>
<body>
<table>

    <tr>
        <th>Title</th>
        <th>Is Complete</th>
        <th>Active</th>

    <c: forEach items="${list}" var = "todo">
        <tr>
            <td>${todo.title}</td>
            <td>${todo.isComplete}</td>
            <td>${todo.active}</td>
        </tr>

    </c: forEach>

    </tr>

</table>
</body>