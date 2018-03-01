<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/20
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="application/force-download" pageEncoding="gb2312"%>
<html>
<head>
    <%
    String newurl=request.getParameter("newurl");
    String filename=request.getParameter("filename");
    %>
</head>
<body>
<%
    response.reset();//可以加也可以不加
    response.setContentType("application/x-download");

//application.getRealPath("/main/mvplayer/CapSetup.msi");获取的物理路径

    String filedownload = newurl;
    String filedisplay = filename;
    String filedisplay = URLEncoder.encode(filedisplay,"UTF-8");
    response.addHeader("Content-Disposition","attachment;filename=" + filedisplay);

    java.io.OutputStream outp = null;
    java.io.FileInputStream in = null;
    try
    {
        outp = response.getOutputStream();
        in = new FileInputStream(filenamedownload);

        byte[] b = new byte[1024];
        int i = 0;

        while((i = in.read(b)) > 0)
        {
            outp.write(b, 0, i);
        }
//
        outp.flush();
//要加以下两句话，否则会报错
//java.lang.IllegalStateException: getOutputStream() has already been called for //this response
        out.clear();
        out = pageContext.pushBody();
    }
    catch(Exception e)
    {
        System.out.println("Error!");
        e.printStackTrace();
    }
    finally
    {
        if(in != null)
        {
            in.close();
            in = null;
        }
    }
%>
</body>
</html>
