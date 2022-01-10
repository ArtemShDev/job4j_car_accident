<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<html>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous">
</script>
<head>
    <title>Accident</title>
</head>
<body>
<%--Hello : Accident--%>
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
            <tr>
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