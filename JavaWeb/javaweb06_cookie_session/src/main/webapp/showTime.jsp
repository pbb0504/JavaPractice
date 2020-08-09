<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 13053
  Date: 2020/8/9
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.setContentType("text/html;charset=utf-8");
    Cookie[] cookies = request.getCookies();
    boolean flag = false;
    for (Cookie cookie : cookies) {
        System.out.println("3333333333333");
        String key = cookie.getName();
        String value = cookie.getValue();
        if ("loginTime".equals(key)) {
            System.out.println("4444444444");
            response.getWriter().write("来过了：" + value);
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日-HH:mm:ss");
            String newDate = simpleDateFormat.format(date);
            cookie.setValue(newDate);
            response.addCookie(cookie);
            flag = true;
        }
    }
    if (!flag) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日-HH:mm:ss");
        String newDate = simpleDateFormat.format(date);
        Cookie cc = new Cookie("loginTime", newDate);
        response.addCookie(cc);
        response.getWriter().write("欢迎");
        System.out.println("1111122222222222");
    }
%>
</body>
</html>
