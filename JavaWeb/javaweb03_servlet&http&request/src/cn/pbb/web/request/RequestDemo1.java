package cn.pbb.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: pbb
 * @date: 2020/7/26 17:00
 */
@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* 1. 获取请求方式 `String getMethod()`  GET
        2. 获取虚拟目录 `String getContextPath()`  /xxxx
        3. 获取Servlet路径 `String getServletPath()` /demo1
        4. 获取get方式的请求参数 `String getQueryString()` name=zhangsan
        5. 获取请求uri  `String getRequestURI()`   /xxxx/demo1
        6. `String getRequestURL()`  :http://localhost/xxxx/demo1
        7. 获取协议及版本  `String getProtocol()`
        8. 获取客户机的IP地址 `String getRemoteAddr()`*/
        String method = req.getMethod();
        System.out.println(method);

        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        String servletPath = req.getServletPath();
        System.out.println(servletPath);

        String queryString = req.getQueryString();
        System.out.println(queryString);

        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);

        String protocol = req.getProtocol();
        System.out.println(protocol);

        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
