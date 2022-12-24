package com.action;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSON;
import com.sun.scenario.effect.ImageData;

/**
 * @author yourname <yourname@baijiahulian.com>
 * Created on 2022-09-09
 */
public class ImageTest{

    public void testSimpleSaveImage() throws IOException {
        String imgPath = "/Users/mac/Desktop/tutu.png";
        BufferedImage image = ImageIO.read(new FileInputStream(imgPath));

        saveImage(image, "/Users/mac/Desktop/save.png", "png");

    }

    public void saveImage(BufferedImage image, String targetPath, String formatName) throws IOException {
        File outputfile = new File(targetPath);
        //formatName 要与源文件类型一致
        ImageIO.write(image, formatName, outputfile);
    }

    public void addLine() throws IOException{
        String imgPath = "/Users/mac/Desktop/tutu.png";
        BufferedImage image = ImageIO.read(new FileInputStream(imgPath));
        Graphics2D graphics2D = image.createGraphics();
        //在坐标（1，1）到坐标（3，3）画一条直线
        //先定义颜色再画图
        graphics2D.setColor(Color.MAGENTA);
        graphics2D.drawLine(1,1, 20,20);

        graphics2D.setColor(Color.CYAN);
        graphics2D.drawLine(3,5, 90, 90);

        saveImage(image, "/Users/mac/Desktop/save.png", "png");
    }

    public void drawText()throws IOException{
        String imgPath = "/Users/mac/Desktop/1878234063_w0y44l1y.png";
        BufferedImage image = ImageIO.read(new FileInputStream(imgPath));

        Graphics2D graphics2D = image.createGraphics();

        graphics2D.setColor(Color.black);
        graphics2D.setFont(new Font("", Font.PLAIN, 35));

        FontMetrics fm = graphics2D.getFontMetrics();
        int textWith = fm.stringWidth("小明完成了 ");
        int textHeight = fm.getHeight();

        //姓名
        int y = 500;
        int x = 160;
        graphics2D.drawString("小明完成了 ", x, y);

        x += textWith;
        graphics2D.setColor(Color.RED);
        graphics2D.drawString("数学", x, y);
        int with = fm.stringWidth("数学");

        x+=with;
        graphics2D.setColor(Color.black);
        graphics2D.drawString(" 的练习", x, y);

        x = 201;
        graphics2D.drawString("1", 201, 640);
        with = fm.stringWidth("1");
        x+= with;
        graphics2D.setFont(new Font("", Font.PLAIN, 20));
        graphics2D.drawString("次", x, 640);

        URL url = new URL("https://gaotu.oss-cn-beijing.aliyuncs.com/image%2F1527651957987VfPicstudent_default.png");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedImage toAddImage = ImageIO.read(connection.getInputStream());
        System.out.println("toAddImage with:"+toAddImage.getWidth()+", height:"+toAddImage.getHeight());
        Image scaleImage = scaleImage(toAddImage);
        graphics2D.drawImage(scaleImage, 80, 460, null);

        URL urlQR = new URL("https://jy.gsxcdn.com/fe/project/daily-practice/tutu_xcx.jpg");
        HttpURLConnection connection1 = (HttpURLConnection) urlQR.openConnection();
        BufferedImage qrImage = ImageIO.read(connection1.getInputStream());
        Image scaleQRImage = scaleImage2(qrImage, 150, 150, 70, 81);
        graphics2D.drawImage(scaleQRImage, 80, 800, null);
        saveImage(image,"/Users/mac/Desktop/text.png", "png");
    }

    public void addImage(BufferedImage image)throws IOException{
        System.out.println("image with:"+image.getWidth()+", height:"+image.getHeight());

        String imgPath = "/Users/mac/Desktop/a8yfi-5vfpi-001.png";
        BufferedImage toAddImage = ImageIO.read(new FileInputStream("https://gaotu.oss-cn-beijing.aliyuncs.com/image%2F1527651957987VfPicstudent_default.png"));
        System.out.println("toAddImage with:"+toAddImage.getWidth()+", height:"+toAddImage.getHeight());
        Image scaleImage = scaleImage(toAddImage);

        Graphics2D graphics2D = image.createGraphics();
        graphics2D.drawImage(scaleImage, 115, 500, null);

        graphics2D.setColor(Color.RED);
        graphics2D.setFont(new Font("Xingkai SC",Font.PLAIN,50));

        //添加字符串
        FontMetrics fm = graphics2D.getFontMetrics();
        int textWidth = fm.stringWidth("张三同学");
        int textHeight = fm.getHeight();
        System.out.println("输入文本长度：" + textWidth+" 高度：" + textHeight);

        //x y 坐标中图片做上角为起点 x轴向延伸 y轴向下延伸
        int h = fm.stringWidth("扫描二维码");
        graphics2D.drawString("扫描二维码", 300, 850);
        graphics2D.setFont(new Font("",Font.PLAIN,50));
        graphics2D.drawString("上好课并领取专属证书", 300, 850 + fm.getHeight());


        //addMark(graphics2D, image);
        //saveImage(image, "/Users/mac/Desktop/save.png", "png");
    }

    public BufferedImage scaleImage(BufferedImage oldImage) throws IOException{
        Image img = oldImage.getScaledInstance(60, 60, Image.SCALE_SMOOTH);

        BufferedImage newImage = new BufferedImage(60, 60, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = newImage.createGraphics();
        graphics2D.setBackground(Color.WHITE);
        graphics2D.drawImage(img,0,0, null);
        graphics2D.dispose();
        //saveImage(newImage, "/Users/mac/Desktop/scaleImage.png", "png");
        return newImage;
    }

    public BufferedImage scaleImage2(BufferedImage oldImage, int with, int height, int x, int y) throws IOException{
        Image img = oldImage.getScaledInstance(with, height, Image.SCALE_SMOOTH);

        BufferedImage newImage = new BufferedImage(with, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = newImage.createGraphics();
        graphics2D.setBackground(Color.WHITE);
        graphics2D.drawImage(img,0,0, null);
        graphics2D.dispose();
        //saveImage(newImage, "/Users/mac/Desktop/scaleImage.png", "png");
        return newImage;
    }

    //添加水印
    public void addMark(Graphics2D graphics2D, BufferedImage image) throws IOException {

        //设置透明度
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.1f));
        //设置旋转角度
        graphics2D.rotate(50);

        String markString = "张三的证书";

        int canvasHeight = image.getHeight();
        int canvasWidth = image.getWidth();

        graphics2D.setColor(Color.GRAY);
        graphics2D.setFont(new Font("STKaiti",Font.PLAIN,70));
        FontMetrics fm = graphics2D.getFontMetrics();

        int markWidth = fm.stringWidth(markString);
        int markHeight = fm.getHeight();
        int interval = markWidth + markHeight;

        for(int i = -canvasHeight; i< canvasHeight + canvasWidth; i=i + interval + 1){ //10 水印之间的水平间距
            for(int j= -canvasWidth; j<canvasHeight + canvasWidth; j = j  + interval + 1){ // 10 水印时间的垂直间距
                graphics2D.drawString(markString, i, j);
            }
        }
        graphics2D.dispose();

    }

    public void generateImage() throws IOException{
        BufferedImage image = new BufferedImage(981, 966, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0, 0, 981, 966);
        addImage(image);
        saveImage(image, "/Users/mac/Desktop/save.png", "png");
    }

    public void testFontName(){
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] names = environment.getAvailableFontFamilyNames();
        System.out.println(JSON.toJSON(names));

    }

    public static void main(String[] args) throws IOException{
        ImageTest imageTest = new ImageTest();
//        imageTest.testSimpleSaveImage();
//        imageTest.addLine();
//        imageTest.addMark();
       //imageTest.addImage();
        //imageTest.testFontName();
       // imageTest.generateImage();
        //imageTest.scaleImage();
        imageTest.drawText();
    }
}
