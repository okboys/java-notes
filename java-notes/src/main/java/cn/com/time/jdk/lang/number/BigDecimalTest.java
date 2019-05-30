package cn.com.time.jdk.lang.number;

import cn.com.time.jdk.base.BaseTest;

import java.math.BigDecimal;

public class BigDecimalTest extends BaseTest{

    public static void t1(){
        BigDecimal b1=new BigDecimal("1.0");
        BigDecimal b2=BigDecimal.valueOf(1.2);
        Double d=b1.subtract(b2).doubleValue();
        //结果-0.20000005
        print(1.0f-1.2f);
        //-0.2
        print(d);
    }

}
