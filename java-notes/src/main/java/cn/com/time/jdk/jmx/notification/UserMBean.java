package cn.com.time.jdk.jmx.notification;

public interface UserMBean {

    String getName();

    void setName(String name);

    String getId();

    void setId(String id);

    void printHello(String name);

}
