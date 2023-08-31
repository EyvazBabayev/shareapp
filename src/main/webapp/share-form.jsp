<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Share APP</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6">
            <div class="card mt-4">
                <div class="card-body">
                    <c:if test="${share != null}">
                    <form action="${pageContext.request.contextPath}/user/share/actions?action=update&username=<c:out value='${share.username}'/>" method="post">
                        </c:if>
                        <c:if test="${share == null}">
                        <form action="${pageContext.request.contextPath}/user/share/actions?action=insert" method="post">
                            </c:if>
                            <caption>
                                <h2>
                                    <c:if test="${share != null}">
                                        Edit Article
                                    </c:if>
                                    <c:if test="${share == null}">
                                        Add New Article
                                    </c:if>
                                </h2>
                            </caption>

                            <fieldset class="form-group">
                                <label>Article Name</label>
                                <input type="text" value="<c:out value='${share.shareName}'/>" class="form-control"
                                       name="shareName" required="required" minlength="5">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Share Article</label>
                                <input type="textarea" value="<c:out value='${share.shareArticle}' />" class="form-control"
                                       name="shareArticle" minlength="10">
                            </fieldset>

                            <button type="submit" class="btn btn-success">Save</button>
                        </form>
                </div>
            </div>
        </div>
        <div class="col-3"></div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>