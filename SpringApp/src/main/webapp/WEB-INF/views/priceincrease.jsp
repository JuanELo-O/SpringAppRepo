<%--
  Created by IntelliJ IDEA.
  User: Lalo
  Date: 6/01/14
  Time: 06:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title><fmt:message key="title"/></title>
    <style>
        .error {color: red;}
    </style>
</head>
<body>
<h1><fmt:message key="priceincrease.heading"/></h1>
<form:form method="post" commandName="priceIncrease">
    <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
        <tr>
            <td width="20%">
                <form:input path="percentage"/>
            </td>
            <td width="60%">
                <form:errors path="percentage" cssClass="error"/>
            </td>
        </tr>
    </table>
    <br>
    <input type="submit" align="center" value="Ejecutar">
</form:form>
<a href="<c:url value="hello.htm"/>">Home</a>
</body>
</html>