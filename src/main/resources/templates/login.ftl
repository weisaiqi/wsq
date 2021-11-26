<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <center>
        <h2>登录页面</h2>
        <form id="form">
            用户名:<input type="text" name="userName" id="userName" onblur="testName()"><br>
            密码:<input type="password" name="userPassword" id="userPassword" onblur="testPassword()"><br>
        </form>
        <button onclick="getLogin()">登录</button>
    </center>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
    function testName() {
        var val = $("#userName").val();
        // alert(val);
        if (val == ""|| val=='') {
            alert("用户名不能为空!");
        }
    }
    function testPassword() {
        var val = $("#userPassword").val();
        if(val.length<6 || val.length>12){
            alert("密码格式不正确!");
        }
    }
    function getLogin() {
      var data = $("#form").serialize();
      $.post("/user/getLogin",data,function (res) {
         if(res){
             alert("登陆成功!");
             location.href="/user/toList";
         }else{
             alert("登录失败!");
             location.reload();
         }
      })
    }
</script>
</html>