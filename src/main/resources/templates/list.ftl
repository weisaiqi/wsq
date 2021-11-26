<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <center>
        <h2>欢迎访问-美食系统</h2>
        当前登录人:${user.userName}
        <#if user.isAdmin=='0'>
            普通用户
            <#elseif user.isAdmin=='1'>
            会员用户
        </#if>

        <button onclick="addMenu()">添加菜品信息</button>
        <table border="1">
            <tr>
                <td>编号</td>
                <td>菜名</td>
                <td>菜系名称</td>
                <td>流派名称</td>
                <td>发布人姓名</td>
                <td>发布时间</td>
                <td>人气</td>
                <td>食材</td>
                <td>操作</td>
            </tr>
            <#list pageInfo.list as menu>
                <tr>
                    <td>${menu.menuId}</td>
                    <td>${menu.menuName}</td>
                    <td>${menu.typeName}</td>
                    <td>${menu.t2Name}</td>
                    <td>${menu.userName}</td>
                    <td>${(menu.publishTime?string("yyyy-MM-dd HH:mm:ss"))}</td>
                    <td>${menu.popularity}</td>
                    <td>${menu.foodName}</td>
                    <td><button onclick="delMenu(${menu.menuId})">删除</button></td>
                </tr>
            </#list>
            <tr>
                <td colspan="100">
                    当前${pageInfo.pageNum}/${pageInfo.pages}页，共${pageInfo.total}条记录;
                    <button onclick="paging(1)">首页</button>
                    <button onclick="paging(${pageInfo.prePage})">上一页</button>
                    <button onclick="paging(${pageInfo.nextPage})">下一页</button>
                    <button onclick="paging(${pageInfo.pages})">尾页</button>
                </td>
            </tr>
        </table>
    </center>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
    function delMenu(id) {
        $.post("/user/delMenu?menuId="+id,function (res) {
            if(res){
                alert("删除成功!");
                location.reload();
            }else{
                alert("删除失败!");
                location.reload();
            }
        })
    }
    function addMenu() {
        location.href="/user/toAdd";
    }
</script>
</html>