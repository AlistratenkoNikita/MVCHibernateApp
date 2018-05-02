<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h3>Welcome to registration page!</h3>

<form:form method="POST" action="${pageContext.request.contextPath}/createUser" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="login">Login</form:label></td>
            <td><form:input path="login" required="required"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:password path="password" required="required"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email" required="required"/></td>
        </tr>
        <tr>
            <td><form:label path="firstName">firstName</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">LastName</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path = "userRole">User role</form:label></td>
            <td>
                <form:select path = "userRole">
                    <c:forEach items="${userRolesList}" var="rolesList">
                        <c:choose>
                            <c:when test="${rolesList.name=='admin'}">
                                <form:option selected="selected" value = "${rolesList.id}" label = "${rolesList.name}" />
                            </c:when>
                            <c:otherwise>
                                <form:option value = "${rolesList.id}" label = "${rolesList.name}" />
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
