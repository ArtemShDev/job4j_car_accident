<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<html>
<head>
    <title>Accident</title>
</head>
<body>
<div class="container">
    <a href="<c:url value='/create'/>">Добавить инцидент</a>
</div>
<div class="card-body">
    <table class="table table-bordered" id="table_string">
        <tbody>
        <tr>
            <th>
                #id
            </th>
            <td>
                Name
            </td>
            <td>
                Description
            </td>
            <td>
                Address
            </td>
        </tr>
        <c:forEach items="${list}" var="str">
            <tr onclick="window.location.href = '/accident/update?id=' + ${str.id}">
                <th>
                    <c:out value="${str.id}"/>
                </th>
                <td>
                    <c:out value="${str.name}"/>
                </td>
                <td>
                    <c:out value="${str.text}"/>
                </td>
                <td>
                    <c:out value="${str.address}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>