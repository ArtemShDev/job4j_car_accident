<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<html>
<html>
<body>
<div class="container">

</div>
<div class="card-body">
    <h5>Редактирование инцидента</h5>
    <form action="<c:url value='/save?id=${accident.id}'/>" method='POST'>
        <table>
            <tr>
                <td>Название:</td>
                <td><input type='text' class="form-control" name='name' value="${accident.name}"></td>
            </tr>
            <tr>
                <td>Описание:</td>
                <td><input type='text' class="form-control" name='text' value="${accident.text}"></td>
            </tr>
            <tr>
                <td>Адрес:</td>
                <td><input type='text' class="form-control" name='address' value="${accident.address}"></td>
            </tr>
        </table>
        <br/>
        <div>
            <td colspan='2'><input name="submit" type="submit" class="btn btn-primary" value="Сохранить"/></td>
        </div>
    </form>
</div>
</body>
</html>