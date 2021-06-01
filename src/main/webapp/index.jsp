<%--
  Created by IntelliJ IDEA.
  User: Yanyu
  Date: 2021/5/31
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="form-group" style="width:800px; margin:0 auto">
    <div class="alert alert-success" role="alert">
        <h4 class="alert-heading">Welcome</h4>
        <p>Set your bloomFilter</p>
    </div>
    <form action="bloomFilter" method="post">
        <label>
            <input type="text" class="form-control" name="size" placeholder="size of bitmap">
        </label>
        <br><small class="form-text text-muted">input length of your bitmap</small>
        <br><input type="submit" class="btn btn-primary"> <input type="reset" class="btn btn-secondary">
    </form>
</div>
</body>
</html>
