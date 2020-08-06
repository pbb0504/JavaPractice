package cn.pbb.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/cookieDemo8")
public class CookieDemo8 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("loginTime".equals(cookie.getName())) {
                    response.getWriter().write("来过了：" + cookie.getValue());
                    cookie.setValue(new Date().toString());
                    response.addCookie(cookie);
                }
            }
        } else {
            Cookie cc = new Cookie("loginTime", new Date().toString());
            response.addCookie(cc);
            response.getWriter().write("欢迎");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
