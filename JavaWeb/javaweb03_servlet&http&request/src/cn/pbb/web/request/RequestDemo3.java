package cn.pbb.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author: pbb
 * @date: 2020/7/26 22:07
 */
@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String header = req.getHeader("user-agent");
        if(header.contains("Chrome")){
            System.out.println("chrome");
        }else if(header.contains("Firefox")){
            System.out.println("firefox");
        }
        System.out.println(header);
    }
}
