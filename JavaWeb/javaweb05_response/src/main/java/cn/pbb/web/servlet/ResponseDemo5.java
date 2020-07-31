package cn.pbb.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @author: pbb
 * @date: 2020/7/31 11:18
 */
@WebServlet("/responseDemo5")
public class ResponseDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        Graphics g = image.getGraphics();

        // 画背景
        g.setColor(Color.pink);
        g.fillRect(0, 0, width, height);

        // 画边框
        g.setColor(Color.blue);
        g.drawRect(0, 0, width - 1, height - 1);

        // 画字符
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int width2 = 20;
        for (int j = 0; j < 4; j++) {
            Random random = new Random();
            int i = random.nextInt(s.length());
            g.drawString(String.valueOf(s.charAt(i)), width2, 25);
            width2 += 20;
        }

        // 画干扰线
        for(int i = 0; i < 6; i++){
            int l = new Random().nextInt(100);
            int l2 = new Random().nextInt(100);
            int k = new Random().nextInt(50);
            int k2 = new Random().nextInt(50);
            g.drawLine(l,k,l2,k2);
        }

        ImageIO.write(image, "png", resp.getOutputStream());
    }
}
