package cn.com.time.jdk.util.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created on 2018/1/2 10:37
 *
 * @author: tong.luo
 * Copyright @2018 Tima Networks Inc. All Rights Reserved. 
 */
public class ImageTest {

    public static void t1() throws IOException {
        BufferedImage image= ImageIO.read(new File("D:\\find.jpg"));
        int width=image.getWidth();
        int height=image.getHeight();
        int[] argb=new int[4];
        int pixel=image.getRGB(100,100);
        System.out.println(pixel);
    }

}
