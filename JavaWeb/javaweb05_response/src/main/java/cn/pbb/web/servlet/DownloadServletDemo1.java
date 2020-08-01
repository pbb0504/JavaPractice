package cn.pbb.web.servlet;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author: pbb
 * @date: 2020/8/1 16:31
 */
@WebServlet("/downloadServletDemo1")
public class DownloadServletDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        ServletContext servletContext = req.getServletContext();
        String realPath = servletContext.getRealPath(filename);
        System.out.println(realPath);
        String mimeType = servletContext.getMimeType(filename);
        FileInputStream fis = new FileInputStream(realPath);
        resp.setHeader("content-type", mimeType);
        String agent = req.getHeader("user-agent");
        filename = getFileName(agent,filename);
        resp.setHeader("content-disposition", "attachment;filename=" + filename);
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buff = new byte[1024];
        int length;
        while ((length = fis.read(buff)) != -1) {
            outputStream.write(buff);
        }
        fis.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    /**
     * 文件名编码
     * @param agent
     * @param filename
     * @return
     * @throws UnsupportedEncodingException
     */
    static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
