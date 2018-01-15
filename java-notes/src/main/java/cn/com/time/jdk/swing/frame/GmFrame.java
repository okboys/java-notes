package cn.com.time.jdk.swing.frame;

import javax.swing.*;
import java.io.IOException;

/**
 * Created on 2018/1/8 13:18
 *
 * @author: tong.luo
 * Copyright @2018 Tima Networks Inc. All Rights Reserved. 
 */
public class GmFrame extends JFrame{

    private GmPanel gmPanel;

    public GmFrame() throws IOException {
        this.gmPanel=new GmPanel();
        this.setSize(640,480);
        this.setVisible(true);
        this.setContentPane(this.gmPanel);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

}
