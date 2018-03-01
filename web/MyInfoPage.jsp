<%@ page import="java.util.List" %>
<%@ page import="Info.TextFile" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <link href="http://cdn.bootcss.com/twitter-bootstrap/2.2.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="dist/css/flat-ui.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>我的信息</title>
    <style>
        body {
            width: 100%;
            margin: 40px auto;
            font-family: 'trebuchet MS', 'Lucida sans', Arial;
            font-size:medium;
            color: #444;
        }

        table {
            *border-collapse: collapse; /* IE7 and lower */
            border-spacing: 0;
            width: 100%;
        }
        .zebra td, .zebra th {
            padding: 10px;
            border-bottom: 1px solid #f2f2f2;
        }

        .zebra tbody tr:nth-child(even) {
            background: #f5f5f5;
            -webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;
            -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;
            box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;
        }

        .zebra th {
            text-align: left;
            text-shadow: 0 1px 0 rgba(255,255,255,.5);
            border-bottom: 1px solid #ccc;
            background-color: #eee;
            background-image: -webkit-gradient(linear, left top, left bottom, from(#f5f5f5), to(#eee));
            background-image: -webkit-linear-gradient(top, #f5f5f5, #eee);
            background-image:    -moz-linear-gradient(top, #f5f5f5, #eee);
            background-image:     -ms-linear-gradient(top, #f5f5f5, #eee);
            background-image:      -o-linear-gradient(top, #f5f5f5, #eee);
            background-image:         linear-gradient(top, #f5f5f5, #eee);
        }

        .zebra th:first-child {
            -moz-border-radius: 6px 0 0 0;
            -webkit-border-radius: 6px 0 0 0;
            border-radius: 6px 0 0 0;
        }

        .zebra th:last-child {
            -moz-border-radius: 0 6px 0 0;
            -webkit-border-radius: 0 6px 0 0;
            border-radius: 0 6px 0 0;
        }

        .zebra th:only-child{
            -moz-border-radius: 6px 6px 0 0;
            -webkit-border-radius: 6px 6px 0 0;
            border-radius: 6px 6px 0 0;
        }

        .zebra tfoot td {
            border-bottom: 0;
            border-top: 1px solid #fff;
            background-color: #f1f1f1;
        }

        .zebra tfoot td:first-child {
            -moz-border-radius: 0 0 0 6px;
            -webkit-border-radius: 0 0 0 6px;
            border-radius: 0 0 0 6px;
        }

        .zebra tfoot td:last-child {
            -moz-border-radius: 0 0 6px 0;
            -webkit-border-radius: 0 0 6px 0;
            border-radius: 0 0 6px 0;
        }

        .zebra tfoot td:only-child{
            -moz-border-radius: 0 0 6px 6px;
            -webkit-border-radius: 0 0 6px 6px
            border-radius: 0 0 6px 6px
        }
    </style>
    <%
        List<TextFile> files=(List<TextFile>) request.getAttribute("files");
        String openId=(String)request.getAttribute("openId");
        String nickname=(String)request.getAttribute("nickname");
        String province=(String)request.getAttribute("province");
        String city=(String)request.getAttribute("city");
        String headimgurl=(String)request.getAttribute("headimgurl");
    %>
</head>
<body>
<h3 style="font-size:large;" align="center"><img src="<%=headimgurl%>" >&nbsp;<%=nickname%></h3>
<h3 style="font-size: large;" align="center">省份:&nbsp;&nbsp;<%=province%>&nbsp;&nbsp;城市:&nbsp;&nbsp;<%=city%></h3>
<table class="zebra">
    <thead>
    <tr>
        <th>序号</th>
        <th>文件名</th>
        <th>状态</th>
        <th>下载链接</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
    <td></td>
    <td></td>
        <td></td>
        <td></td>
    </tr>
    <tfoot>
    <%
        int a=1;
        for(TextFile file:files){
    %>
    <tr>
        <td><%=a%></td>
        <td><%=file.getFilename()%></td>
        <td><%=file.getStatus()%></td>
        <%if(file.getStatus().equals("处理中")){%>
        <td><a disabled="true" class="btn btn-block">下载</a> </td>
        <%
        }else {
        %>
        <td><a href="DownloadFile?newurl=<%=file.getNewurl()%>&filename=<%=file.getFilename()%>" class="btn btn-block">下载</a> </td>
        <%}%>
    </tr>
    <%
            a++;
        }
    %>
</table>
</body>
</html>