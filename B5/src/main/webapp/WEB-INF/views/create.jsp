<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="Utf-8" />
    <title>Create Student</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2><c:choose><c:when test="${isUpdate}">Update Student</c:when><c:otherwise>Create New Student</c:otherwise></c:choose></h2>
    <form:form action="create" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="txtID">ID</label>
            <input type="text" class="form-control" id="txtID" name="txtID" value="${student.id}" <c:if test="${isUpdate}">readonly</c:if> />
        </div>
        <div class="form-group">
            <label for="txtEmail">Email</label>
            <input type="email" class="form-control" id="txtEmail" name="txtEmail" value="${student.email}" />
        </div>
        <div class="form-group">
            <label for="txtPassword">Password</label>
            <input type="password" class="form-control" id="txtPassword" name="txtPassword" value="${student.password}" />
        </div>
        <div class="form-group">
            <label for="txtFirstName">First Name</label>
            <input type="text" class="form-control" id="txtFirstName" name="txtFirstName" value="${student.firstName}" />
        </div>
        <div class="form-group">
            <label for="txtLastName">Last Name</label>
            <input type="text" class="form-control" id="txtLastName" name="txtLastName" value="${student.lastName}" />
        </div>
        <div class="form-group">
            <label for="txtMark">Mark</label>
            <input type="number" class="form-control" id="txtMark" name="txtMark" value="${student.marks}" />
        </div>
        <div class="form-group">
            <c:choose>
                <c:when test="${isUpdate}">
                    <button type="submit" name="btnManageStudent" value="update" class="btn btn-warning">Update</button>
                </c:when>
                <c:otherwise>
                    <button type="submit" name="btnManageStudent" value="add" class="btn btn-success">Add</button>
                </c:otherwise>
            </c:choose>
            <button type="submit" name="btnManageStudent" value="cancel" class="btn btn-default">Cancel</button>
        </div>
    </form:form>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>

