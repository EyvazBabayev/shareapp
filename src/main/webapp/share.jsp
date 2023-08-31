<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Share APP</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <h2 style="text-align: center">List of Articles</h2>
    <div class="container text-left">
        <a href="<%=request.getContextPath()%>/user/share/actions?action=new" class="btn btn-success">Add Articles</a>
    </div>
    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Article Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="share" items="${shares}">
            <tr>
                <td><c:out value="${share.shareName}" /></td>

                <td><c:out value="${share.Created_at}" /></td>

                <td>
                    <a href="<%=request.getContextPath()%>/user/share/actions?action=edit&username=<c:out value='${share.username}'/>">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="<%=request.getContextPath()%>/user/share/actions?action=delete&username=<c:out value='${share.username}'/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

