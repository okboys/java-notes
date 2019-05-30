package cn.com.time.jdk.swing.frame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GmTextField extends JPasswordField{

    public GmTextField(int width,int height){
        setPreferredSize(new Dimension(width,height));
//        setBackground(Color.BLUE);
        setFont(new Font("宋体",Font.PLAIN,20));
        Border b1= BorderFactory.createLineBorder(Color.CYAN,1);
        Border b2= BorderFactory.createLineBorder(Color.white,3);
        CompoundBorder compoundBorder=new CompoundBorder(b1,b2);
        setBorder(compoundBorder);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
