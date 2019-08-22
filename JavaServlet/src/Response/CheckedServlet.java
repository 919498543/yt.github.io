package Response;

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

/*
* 验证码的实现
*
* */
@WebServlet("/checkedServlet")
public class CheckedServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int width=140;
        int height=70;
        //创建一对象，在内存中的图片
        BufferedImage bimg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //美化图片
        Graphics graphics=bimg.getGraphics();//画笔对象
        graphics.setColor(Color.pink);//设置画笔颜色
        graphics.fillRect(0,0,width,height);
        //画边框
        graphics.setColor(Color.blue);
        graphics.drawRect(0,0,width-1,height-1);
        //写字
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        //生成随机角标
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <=4 ; i++)
        {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            Font font =new Font("宋体",Font.PLAIN,36);
            graphics.setFont(font);
            graphics.drawString(ch+"",width/5*i,height/2);
        }
        String check = sb.toString();
        request.getSession().setAttribute("checkCodeSession",check);
        //画干扰线
        graphics.setColor(Color.gray);
        //随机生成坐标点
        for (int i = 0; i <12 ; i++)
        {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }
        graphics.setColor(Color.red);
        //随机生成坐标点
        for (int i = 0; i <5 ; i++)
        {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }
        graphics.setColor(Color.GREEN);
        //随机生成坐标点
        for (int i = 0; i <6 ; i++)
        {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }
        graphics.setColor(Color.yellow);
        //随机生成坐标点
        for (int i = 0; i <6 ; i++)
        {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }
        graphics.setColor(Color.cyan);
        //随机生成坐标点
        for (int i = 0; i <6 ; i++)
        {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }

        //图片输出
        ImageIO.write(bimg,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }
}
