package cn.com.time.jdk.swing.frame;

import javax.swing.*;
import java.io.IOException;

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
