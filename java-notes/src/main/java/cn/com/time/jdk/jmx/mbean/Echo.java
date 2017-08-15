package cn.com.time.jdk.jmx.mbean;

/**
 * Created by TimaNetworks on 2017/7/20.
 */
public class Echo implements EchoMBean{
    @Override
    public void print(String yourName) {
        System.out.println("Hello "+yourName+" !");
    }

    public static void main(String[] args) {
        System.out.println("");
    }

}
