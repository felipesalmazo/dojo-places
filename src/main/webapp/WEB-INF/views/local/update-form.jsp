<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Local</title>
</head>
<body>

<form:form modelAttribute="place" action="/local/update/${place.id}" method="post">

    <label>Name:</label>
    <form:input path="name"/><br/><br/>

    <label>Code:</label>
    <form:input path="code"/><br/><br/>

    <label> District: </label>
    <form:input path="district"/><br/><br/>

    <label> City: </label>
    <form:input path="city"/><br/><br/>

    <input type="submit"/>
</form:form>
</body>
</html>