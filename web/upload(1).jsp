<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><meta charset="utf-8">
    <meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <link href="http://cdn.bootcss.com/twitter-bootstrap/2.2.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="dist/css/flat-ui.css" rel="stylesheet">
    <style>blockquote,h1,h2,h3,h4,h5,h6,p{margin:0;padding:0}
    body{font-family:"Microsoft YaHei",Helvetica,"Hiragino Sans GB",Arial,sans-serif;font-size:13px;line-height:18px;color:#737373;background-color:#fff;margin:10px 13px 10px 13px}
    table{margin:10px 0 15px 0;border-collapse:collapse}
    td,th{border:1px solid #ddd;padding:3px 10px}
    th{padding:5px 10px}
    a{color:#0069d6}
    a:hover{color:#0050a3;text-decoration:none}
    a img{border:none}p{margin-bottom:13px;font-family:"Microsoft YaHei"}
    h1,h2,h3,h4,h5,h6{color:#404040;line-height:36px}
    h1{margin-bottom:18px;font-size:30px}
    h2{font-size:24px}
    h3{font-size:18px}
    h4{font-size:16px}
    h5{font-size:14px}
    h6{font-size:13px}
    hr{margin:0 0 19px;border:0;border-bottom:1px solid #ccc}
    blockquote{padding:13px 13px 21px 15px;margin-bottom:18px;font-family:georgia,serif;font-style:italic}
    blockquote:before{content:"\201C";font-size:40px;margin-left:-10px;font-family:georgia,serif;color:#eee}
    blockquote p{font-size:16px;font-weight:300;line-height:18px;margin-bottom:0;font-style:italic}
    code,pre{font-family:Monaco,Andale Mono,Courier New,monospace}
    code{background-color:#fee9cc;color:rgba(0,0,0,.75);padding:1px 3px;font-size:12px;-webkit-border-radius:3px;-moz-border-radius:3px;border-radius:3px}pre{display:block;padding:14px;margin:0 0 18px;line-height:16px;font-size:11px;border:1px solid #d9d9d9;white-space:pre-wrap;word-wrap:break-word}
    pre code{background-color:#fff;color:#737373;font-size:11px;padding:0}
    sup{font-size:.83em;vertical-align:super;line-height:0}
    *{-webkit-print-color-adjust:exact}
    @media screen and (min-width:914px){body{width:854px;margin:10px auto}}
    @media print{body,code,h1,h2,h3,h4,h5,h6,pre code{color:#000}pre,table{page-break-inside:avoid}}</style>
    <%
    String openId=(String) request.getAttribute("openId");
    if(openId==null){
        openId=request.getParameter("openId");
    }
    %>
    <title>上传论文</title>
</head>
<body>
<div align="center">
    <h2>上传论文</h2><hr><br/><br/>
</div>
    <form  action="ReceiveFile" method="post" enctype="multipart/form-data">
        <input name="openId" value="<%=openId%>" type="hidden">
       File:<br/>
        <div style="height: 30px">
            <input id="f_file" type='text' style="display: inline-block;float: left;height: 30px;font-size: medium;width: 73%">
            <input id="t_file"  type="file" name="t_file" style="filter:alpha(opacity=0);position:absolute;opacity:0;width:25%;height:30px;display: inline-block;float: right"onchange="f_file.value=this.value" hidefocus>
            <input class="btn-block" id="btn_value2" value="浏览论文" type="button"  style="height: 30px ;width:25%;display: inline-block;float: right">
        </div>
            <br/><br/><br/><br/><br/>
            <div class="col-xs-3">
                <input type="submit" name="submit"  class="btn btn-lg btn-block btn-success" style="text-decoration-color: #2d2d2d">
            </div>
    </form>
</body>
</html>