<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h3>文件上传</h3>
<form action="/reading/dealupload" method="post" enctype="multipart/form-data">
    账号：<input type="text" name="username"/><br>
    邮箱：<input type="email" name="email"><br>
    头像：<input type="file" name="headimg"><br>
 
    <input type="submit" value="注册">
</form>
</body>
</html>