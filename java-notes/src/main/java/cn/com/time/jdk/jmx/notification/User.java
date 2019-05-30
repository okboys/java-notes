package cn.com.time.jdk.jmx.notification;

public class User implements UserMBean{

    private String name;

    private String id;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }

    @Override
    public void printHello(String name) {
        System.out.println("Hello I am "+name);
    }
}
