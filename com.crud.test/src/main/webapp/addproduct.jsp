<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить новоый товар</title>
</head>
<body>
<form action = "ttp://localhost:8080/com_crud_test_1_0_SNAPSHOT_war/pricedata" method="post">
    <input required type="text" name="code" placeholder="code">
    <input required type="text" name="name" placeholder="name">
    <input required type="text" name="price" placeholder="price">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
