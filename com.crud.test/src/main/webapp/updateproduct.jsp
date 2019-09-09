<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Изменить данных о товаре</title>
</head>
<body>

Редактировать товар

<form action="http://localhost:8080/com_crud_test_1_0_SNAPSHOT_war/pricedata/${param.id}" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="code" value="${param.code}" placeholder=${param.code}>
    <input type="text" name="name" value="${param.name}" placeholder=${param.name}>
    <input type="text" name="price" value="${param.price}" placeholder=${param.price}>
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>

</body>
</html>
