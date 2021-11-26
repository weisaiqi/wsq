<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
     <center>
         <h2>添加菜品</h2>
         <form id="form">
             菜品名称:<input type="text" name="menuName"><br>
             菜系:<select name="typeId" id="select1" onclick="selectone()">
                 <#list types as type>
                     <option value="${type.typeId}">${type.typeName}</option>
                 </#list>
             </select>
             派系:<select  id="select2">

             </select>
             <br>
             食材:<#list foods as food>
                 <input type="checkbox" name="foodId" value="${food.foodId}">${food.foodName}
             </#list>
             <br>
<#--             人气:<input type="text" name="popularity"><br>-->
             菜品效果:<input type="file" name="file">
         </form>
         <button onclick="addMenu()">提交</button>
     </center>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
    function addMenu() {
      var data = $("#form").serialize();
      $.post("/user/addMenu",data,function (res)  {
         if(res){
             alert("添加成功!");
             location.href="/user/toList";
         }else{
             alert("添加失败!");
             location.reload();
         }
      })
    }
    //渲染派系
    function selectone() {
        $("#select2").empty();
        var pid = $("#select1").val();
        var option="";
        $.post("/user/selectTypes?pid="+pid,function (res) {
            for (var i = 0; i <res.length ; i++) {
                option+="<option value='"+res[i].typeId+"'>"+res[i].typeName+"</option>";
            }
            $("#select2").append(option);
        })
    }
</script>
</html>