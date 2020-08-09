package cn.pbb.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 13053
 */
@WebServlet("/cookieDemo8")
public class CookieDemo8 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
