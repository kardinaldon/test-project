<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список товаров</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Код</td>
        <td>Наименование</td>
        <td>Цена</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${priceDataList}" var = "pricedata">
        <tr>
            <td>${pricedata.getId()}</td>
            <td>${pricedata.getCode()}</td>
            <td>${pricedata.getName()}</td>
            <td>${pricedata.getPrice()}</td>
            <td>
                <form action = "updateproduct.jsp" method="post">
                    <input type="hidden" name="id" value="${pricedata.getId()}">
                    <input type="hidden" name="code" value="${pricedata.getCode()}">
                    <input type="hidden" name="name" value="${pricedata.getName()}">
                    <input type="hidden" name="price" value="${pricedata.getPrice()}">
                    <input type="submit" value="Изменить" style="float:left">
                </form>
                <form action="deleteproduct.jsp" method="post">
                    <input type="hidden" name="id" value="${pricedata.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form></td>
        </tr>
    </c:forEach>
</table>

<form action = "addproduct.jsp">
    <input type="submit" value="Добавить нового пользователя">
</form>
</body>
</html>
