package cn.com.time.jdk.lang.bits;

public class BitDecoder {

    private byte[] byteArray;

    private int offset=0;

    private int cellOffset=0;

    private static final int CELL_SIZE=8;

    public BitDecoder(byte[] byteArray){
        this.byteArray=byteArray;
    }

    public int readInt(int size){
        int n=0;

        while (size>0){
            //(CELL_SIZE-cellOffset)单个字节剩余bit数目
            //size 要读取的int的剩余长度
            int count=Math.min((CELL_SIZE-cellOffset),size);
            int b=(int)byteArray[offset];
            //左边空余位数cellOffset
            //右边空余位数CELL_SIZE-cellOffset-count
            int a=((b<<cellOffset)>>(CELL_SIZE-cellOffset-count))&((1<<count)-1);
            n=(n<<count)+a;
            size-=count;
            cellOffset+=count;
            //读完一个bit
            if(cellOffset==CELL_SIZE){
                offset++;
                //回到下一个bit的起始位置
                cellOffset=0;
            }
        }
        return n;
    }

}
