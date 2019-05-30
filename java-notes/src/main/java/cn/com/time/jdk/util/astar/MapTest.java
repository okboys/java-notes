package cn.com.time.jdk.util.astar;

import java.awt.*;

public class MapTest {

    public static void main(String[] args) {
        AstarCell[][] cells=new AstarCell[10][10];
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                cells[i][j]=new AstarCell();
                cells[i][j].setType(0);
                cells[i][j].setPoint(new Point(i,j));
            }
        }

        AstarManager manager=new AstarManager(cells);
        manager.calculateDistance(cells[0][0],cells[5][5]);
    }

}
