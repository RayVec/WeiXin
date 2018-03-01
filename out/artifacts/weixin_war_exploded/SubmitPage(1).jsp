<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<meta charset="UTF-8">
	<title>文件上传</title>
	<script>
	</script>
</head>
<body>
<br/><br/><br/><br/>
<div align="center">
<form action="ReceiveFile" enctype="multipart/form-data" method="post" >
	    <input type="file" id="file"   >
	    <div style="width: 350px;height: 40px;" align="center" >
        <!input type="button" onclick="file.click()"  style="width:150px; height:40px ;display: inline-block;float: left;background-color: lightgray" value="选择文件" >
		<!input type="text"  style="height: 40px; width: 200px;display: inline-block;border:0px dotted #ccc;float: left;font-size: medium" name="upfile " id="filename"  readonly >
		</div><br/><br/><br/><br/><br/>
	    <input type="submit" style="width: 350px ;height: 50px;background-color:lightgray" value="上传文件">
</form>
</div>
</body>
</html>