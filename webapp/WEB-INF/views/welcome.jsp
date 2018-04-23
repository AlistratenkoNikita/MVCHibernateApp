<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  welcome, user!
  <br>

  <table>
    <caption><h3>List of all users</h3></caption>
    <thead>
      <tr>
          <td>Login</td>
          <td>Role</td>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
      <tr>
          <td>${user.login}</td>
          <td>${user.userRole.name}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>


  <a href="${pageContext.request.contextPath}/registration">Registration page</a>
  </body>
</html>
