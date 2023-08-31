<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Share APP</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <%--<link rel="stylesheet" href="css/app.css"/>--%>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <h2 style="text-align: center">Welcome to Share App</h2>
    <div class="container text-center">
        <a class="btn btn-success" href="login.jsp">Login</a>
        <a class="btn btn-secondary" href="register.jsp">Signup</a>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>