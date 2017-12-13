package cn.com.time.jdk.lang.bits;

/**
 * Created on 202017/10/30 9:49 By tong.luo
 * <p>
 * Copyright @ 2017 Tima Networks Inc. All Rights Reserved. 
 */
public class BitEncoder {

    private byte[] bytes;

    private static final int DEFAULT_SIZE=4;

    private int offset=0;

    private int cellOffset=0;

    private static final int CELL_SIZE=8;

    public BitEncoder(){
        bytes=new byte[DEFAULT_SIZE];
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    private void resizeByteArray(){
        if(offset>=bytes.length){
            byte[] b=new byte[bytes.length*2];
            System.arraycopy(bytes,0,b,0,bytes.length);
            this.bytes=b;
        }
    }

    public void writeBoolean(boolean bool){

    }

    public void writeInt(int i,int size){
        checkValue(size,i);
        while (size>0){
            int count=Math.min((CELL_SIZE-cellOffset),size);
            //当前cell中的左边元素个数cellOffset
            //右边元素个数CELL_SIZE-cellOffset
            //count为要放入的元素个数
            int bits=(i>>(size-count))&((1<<count)-1);
            bytes[offset]|=bits<<(CELL_SIZE-cellOffset-count);
            size-=count;
            cellOffset+=count;
            if(cellOffset==CELL_SIZE){
                offset++;
                //回到下一个bit的起始位置
                cellOffset=0;
            }
        }
    }

    private void checkValue(int size,int value){
        int max=(1<<size)-1;
        if((value & (~max))!=0){
            throw new IllegalArgumentException("参数有误");
        }
    }

}
