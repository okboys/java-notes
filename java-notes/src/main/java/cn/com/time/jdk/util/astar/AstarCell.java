package cn.com.time.jdk.util.astar;

import java.awt.*;

/**
 * Created on 2018/1/2 16:25
 *
 * @author: tong.luo
 * Copyright @2018 Tima Networks Inc. All Rights Reserved. 
 */
public class AstarCell {

    private AstarCell parent;

    private Point point;

    private int vg;

    private int vf;

    private int vh;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setParent(AstarCell parent) {
        this.parent = parent;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public AstarCell getParent() {
        return parent;
    }

    public Point getPoint() {
        return point;
    }

    public int getVg() {
        return vg;
    }

    public void setVg(int vg) {
        this.vg = vg;
    }

    public int getVf() {
        return vf;
    }

    public void setVf(int vf) {
        this.vf = vf;
    }

    public int getVh() {
        return vh;
    }

    public void setVh(int vh) {
        this.vh = vh;
    }
}
