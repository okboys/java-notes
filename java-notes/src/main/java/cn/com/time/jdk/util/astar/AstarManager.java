package cn.com.time.jdk.util.astar;

import java.awt.*;
import java.util.*;
import java.util.List;

public class AstarManager {

    private AstarCell[][] map=new AstarCell[10][10];

    private List<AstarCell> close=new ArrayList<>();

    private List<AstarCell> open=new ArrayList<>();

    public AstarManager(AstarCell[][] map) {
        this.map = map;
    }


    public void calculateDistance(AstarCell cell,AstarCell target){
        open.add(cell);
        List<AstarCell> cells=discardAndgetAvaliableCells(cell,target);
        cells.forEach(m->{
            m.setParent(cell);
            calculateDistance(m,target);
        });
    }

    private List<AstarCell> discardAndgetAvaliableCells(AstarCell cell,AstarCell target){
        if(cell==target){
            System.out.println("AAAAA");
            while (cell.getParent()!=null){
                System.out.println(cell.getPoint());
                cell=cell.getParent();
            }
        }
        Point point=cell.getPoint();
        List<AstarCell> cells=new ArrayList<>();
        int maxIndexX=(point.x+1)>=10?point.x:(point.x+1);
        int minIndexX=(point.x-1)<0?point.x:(point.x-1);
        int maxIndexY=(point.y+1)>=10?point.y:(point.y+1);
        int minIndexY=(point.y-1)<0?point.y:(point.y-1);
        for (int i=minIndexX;i<=maxIndexX;i++){
            for (int j=minIndexY;j<=maxIndexY;j++){
                AstarCell a=map[i][j];
                if(a!=null){
                    if(!close.contains(a)&&!open.contains(a)){
                        if(a.getType()==0){
                            cells.add(a);
                        }else {
                            close.add(a);
                        }
                    }
                }
            }
        }

        discard(cells,target);
        return cells;
    }

    private List<AstarCell> getAvaliableCells(AstarCell cell){
        Point point=cell.getPoint();
        List<AstarCell> cells=new ArrayList<>();
        int maxIndexX=(point.x+1)>=10?point.x:(point.x+1);
        int minIndexX=(point.x-1)<0?point.x:(point.x-1);
        int maxIndexY=(point.y+1)>=10?point.y:(point.y+1);
        int minIndexY=(point.y-1)<0?point.y:(point.y-1);
        for (int i=minIndexX;i<=maxIndexX;i++){
            for (int j=minIndexY;j<=maxIndexY;j++){
                AstarCell a=map[i][j];
                if(a!=null){
                    if(!close.contains(a)&&!open.contains(a)&&a!=cell){
                        if(a.getType()==0){
                            cells.add(a);
                        }
                    }
                }
            }
        }
        return cells;
    }

    private void discard(List<AstarCell> cells,AstarCell target){
        Double distance=Double.MAX_VALUE;
        Iterator<AstarCell> iterator=cells.iterator();
        while (iterator.hasNext()){
            AstarCell cell=iterator.next();
            List<AstarCell> cs=getAvaliableCells(cell);
            if(cs.size()==0){
                iterator.remove();
            }

            double ds=distanceBetween(cell,target);
            if(ds<distance){
                distance=ds;
            }else {
                close.add(cell);
                iterator.remove();
            }
        }
    }

    public double distanceBetween(AstarCell a,AstarCell b){
        Point pa=a.getPoint();
        Point pb=b.getPoint();
        return Math.sqrt((pa.x-pb.x)*(pa.x-pb.x)+(pa.y-pb.y)*(pa.y-pb.y));
    }

}
