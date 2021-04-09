<%--
  Created by IntelliJ IDEA.
  User: nbh
  Date: 07/04/2021
  Time: 11.53
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    Her kan du se alle de emner folk har tilføjet


    <c:forEach items="${applicationScope.emneListeContext}" var="element">

        <br>
        ${element}





    </c:forEach>


</head>
<body>

</body>
</html>
