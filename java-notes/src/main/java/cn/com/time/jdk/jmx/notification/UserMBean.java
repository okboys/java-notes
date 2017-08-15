package cn.com.time.jdk.jmx.notification;

/**
 * Created by TimaNetworks on 2017/7/21.
 */
public interface UserMBean {

    String getName();

    void setName(String name);

    String getId();

    void setId(String id);

    void printHello(String name);

}
