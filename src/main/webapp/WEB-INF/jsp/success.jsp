<%--
  Created by IntelliJ IDEA.
  User: Yanyu
  Date: 2021/5/31
  Time: 23:33
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
<div style="width:800px; margin:0 auto">
    <div class="alert alert-success" role="alert">
        <h4 class="alert-heading">Well</h4>
        <p>${message}</p>
        <hr>
        <p class="mb-0">You can do other options.</p>
    </div>

    <div class="form-group">
        <form action="add" method="post">
            <label>
                <input type="text" class="form-control" name="word" placeholder="add a word">
            </label>
            <br><small class="form-text text-muted">input which words you wanna add</small>
            <br><input type="submit" class="btn btn-primary"> <input type="reset" class="btn btn-secondary">
        </form>
    </div>

    <div class="form-group">
        <form action="contains" method="post">
            <label>
                <input type="text" class="form-control" name="word" placeholder="word contains?">
            </label>
            <br><small class="form-text text-muted">input which words you wanna check</small>
            <br><input type="submit" class="btn btn-primary"> <input type="reset" class="btn btn-secondary">
        </form>
    </div>


    <div class="form-group">
        <form action="randomAddWords" method="post">
            <label>
                <input type="text" class="form-control" name="random" placeholder="random add some words">
            </label>
            <br><small class="form-text text-muted">input how many words you wanna add</small>
            <br><input type="submit" class="btn btn-primary"> <input type="reset" class="btn btn-secondary">
        </form>
    </div>

    <div class="form-group">
        <form action="SamplingCheck" method="post">
            <label>
                <input type="text" class="form-control" name="length" placeholder="Sampling survey">
            </label>
            <br><small class="form-text text-muted">input the length of words. small length word is easier to
            crash</small>
            <br><input type="submit" class="btn btn-primary"> <input type="reset" class="btn btn-secondary">
        </form>
    </div>
</div>


</body>
</html>
