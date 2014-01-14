<%--
  Created by IntelliJ IDEA.
  User: Lalo
  Date: 3/01/14
  Time: 05:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<head>
    <title><fmt:message key="title"/></title>
</head>
<body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3><fmt:message key="productsTitle"/></h3>
    <c:forEach items="${model.products}" var="prod">
        <c:out value="${prod.description}"/> <i>$<c:out value="${prod.price}"/></i><br><br>
    </c:forEach>
    <br>
    <a href="<c:url value="priceincrease.htm"/> ">Incrementar precios</a>
    <br>
</body>
</html>