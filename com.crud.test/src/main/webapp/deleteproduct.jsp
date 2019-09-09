<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Удалить товар</title>
</head>
<body>

Вы действительно хотите удалить товар ${param.id}?

<form action="http://localhost:8080/com_crud_test_1_0_SNAPSHOT_war/pricedata/${param.id}" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Удалить">
</form>

</body>
</html>
