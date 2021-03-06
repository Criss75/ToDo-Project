<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit todo</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="CSS/main.css">
    <link href="https://fonts.googleapis.com/css?family=Dosis&display=swap" rel="stylesheet">
    <link rel="icon" type="image/png" href="favicon-32x32.png">
</head>
<body id = "laptop-img1">

    <div class = "container">
    <h1>To Do List</h1>
    <hr/>
        <div class="row">
           <div class="col-md-4">
             <form action="${pageContext.request.contextPath}/todo" method="POST">
              <div class="form-group">
               Input new todo: <input type = "text" name = "todoname" value = "${todo.title}"
               class="form-control" required> <br>
              </div>
                <div class="form-group">
               Input due date: <input type = "date" id="userdate" onchange="return TDate()" name = "active"
               value = "${todo.active}" class="form-control" required> <br>
                </div>
                <div class="form-group">
                 Completed?
                 <input type = "radio" name = "completed" value = "false" checked > NO
                 <input type = "radio" name = "completed" value = "true" checked > YES <br>
                </div>
               <input type = "hidden" value =${todo.todoId} name = "todo_id">
               <button class = "btn btn-primary" type ="submit"> Save todo </button>
             </form>
           </div>
        </div>

    </div>


    <script src="scripts.js"></script>
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>