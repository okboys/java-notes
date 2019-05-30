package cn.com.time.jdk.util.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
