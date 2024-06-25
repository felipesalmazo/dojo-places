<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Local</title>
</head>
<body>
    <form action="/local/create" method="post">
        <label> Name: <input name="name"></label><br/><br/>
        <label> Code: <input name="code"></label><br/><br/>
        <label> District: <input name="district"></label><br/><br/>
        <label> City: <input name="city"></label><br/><br/>
        <input type="submit">
    </form>
</body>
</html>