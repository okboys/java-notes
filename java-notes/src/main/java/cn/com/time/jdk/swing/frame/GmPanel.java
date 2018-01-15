package cn.com.time.jdk.swing.frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created on 2018/1/8 13:26
 *
 * @author: tong.luo
 * Copyright @2018 Tima Networks Inc. All Rights Reserved. 
 */
public class GmPanel extends JPanel{

    private GmButton gmButton;

    private BufferedImage image;

    private GmTextField textField;

    public GmPanel() throws IOException {
        this.setSize(640,480);
        textField=new GmTextField(200,40);
        textField.setLocation(0,0);
        add(textField);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
