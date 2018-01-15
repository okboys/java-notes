package cn.com.time.jdk.swing.frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created on 2018/1/8 13:38
 *
 * @author: tong.luo
 * Copyright @2018 Tima Networks Inc. All Rights Reserved. 
 */
public class GmButton extends JButton{

    private BufferedImage btnTmg;

    private BufferedImage pressImg;

    public GmButton() throws IOException {
        this.btnTmg= ImageIO.read(new File("E:\\图标\\circle_orange.png"));
        this.pressImg=ImageIO.read(new File("E:\\图标\\circle_red.png"));
        this.setSize(this.btnTmg.getWidth(),this.btnTmg.getHeight());
        setUI(new GmButtonUI());
        this.setIcon(new ImageIcon(this.btnTmg));
        this.setLocation(100,100);
        this.setOpaque(false);
        this.setPressedIcon(new ImageIcon(this.pressImg));
        this.setBorder(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    private class GmButtonUI extends BasicButtonUI{

    }

}
