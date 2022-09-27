package com.action;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSON;

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

    public void addImage()throws IOException{
        String sourceImagePath = "/Users/mac/Desktop/a8yfi-5vfpi-001.png";
        BufferedImage image = ImageIO.read(new FileInputStream(sourceImagePath));
        System.out.println("image with:"+image.getWidth()+", height:"+image.getHeight());

        String imgPath = "/Users/mac/Desktop/tutu.png";
        BufferedImage toAddImage = ImageIO.read(new FileInputStream(imgPath));

        Graphics2D graphics2D = image.createGraphics();
        graphics2D.drawImage(toAddImage, image.getWidth()-900, image.getHeight()-670, toAddImage.getWidth()*2, toAddImage.getHeight()*2, null);

        graphics2D.setColor(Color.RED);
        graphics2D.setFont(new Font("Xingkai SC",Font.PLAIN,87));

        //添加字符串
        FontMetrics fm = graphics2D.getFontMetrics();
        int textWidth = fm.stringWidth("张三同学");
        int textHeight = fm.getHeight();
        System.out.println("输入文本长度：" + textWidth+" 高度：" + textHeight);

        //x y 坐标中图片做上角为起点 x轴向延伸 y轴向下延伸
        graphics2D.drawString("安徒生", 800, 1250);

        addMark(graphics2D, image);
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
        imageTest.addImage();
        //imageTest.testFontName();

    }
}
