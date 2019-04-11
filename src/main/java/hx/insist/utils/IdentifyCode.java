package hx.insist.utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/IdentifyCode")
public class IdentifyCode extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 120;
    public static final int HEIGHT = 25;
    public IdentifyCode() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics g =  image.getGraphics();
        setBackGround(g);
        setBorder(g);
        drawRandomLine(g);
        //4.写随机数  并保存
        String checkcode2 = drawRandomNum((Graphics2D)g);
        request.getSession().setAttribute("checkcode2",checkcode2);
        //5.图形写给浏览器
        response.setContentType("image/jpeg");//默认文本方式打开,设置浏览器以图片形式打开
        //发头控制浏览器不要缓存
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
    private void setBackGround(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }
    private void setBorder(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(1, 1, WIDTH-2, HEIGHT-2);
    }
    private void drawRandomLine(Graphics g) {
        g.setColor(Color.GREEN);
        for(int i=0;i<5;i++) {
            int x1 = new Random().nextInt(WIDTH-2) + 1;
            int y1 = new Random().nextInt(HEIGHT-2) + 1;
            int x2 = new Random().nextInt(WIDTH-2) + 1;
            int y2 = new Random().nextInt(HEIGHT-2) + 1;
            g.drawLine(x1, y1, x2, y2);
        }
    }
    private String drawRandomNum(Graphics2D g) {
        StringBuilder me = new StringBuilder();
        g.setColor(Color.RED);
        g.setFont(new Font("宋体",Font.BOLD,20));
        String base = "79884654896465387489964896645618964456132122303789040464";
        int x = 15;
        for(int i=0;i<4;i++) {
            int degree = new Random().nextInt(60)-30;
            String ch = base.charAt(new Random().nextInt(base.length()))+"";
            g.rotate(degree*Math.PI/180,x,20);
            g.drawString(ch, x, 20);
            g.rotate(-degree*Math.PI/180,x,20);
            x = x + 25;
            me.append(ch);
        }
        return me.toString();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}