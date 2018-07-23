<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head><title>Web log Entry</title></head>

<body bgcolor="white">

<form action="/blog/Write">
    Log Entry:<br>
    <textarea name="data" rows="10" cols="60"></textarea>
    <br>
    Password: <input type="text" name="password" value="" size="30">
    <br>
    <input type="submit" value="Submit">
</form>

</body></html>