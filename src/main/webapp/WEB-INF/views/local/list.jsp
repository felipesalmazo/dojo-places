<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Código</th>
                <th>Data de Criação</th>
                <th>Última atualização</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="place" items="${places}">
                <tr>
                    <td>${place.id()}</td>
                    <td>${place.name()}</td>
                    <td>${place.code()}</td>
                    <td>${place.creationDate()}</td>
                    <td>${place.updatedDateMessage()}</td>
                    <td><a href="/local/update/${place.id()}">Editar</a></td>
                    <td><a href="/local/delete/${place.id()}">Deletar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
