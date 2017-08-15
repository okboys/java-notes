package cn.com.time.jdk.jmx.mbean;

/**
 * Created by TimaNetworks on 2017/7/21.
 */
public class Hello implements HelloMBean {

    private String name;

    private String age;

    @Override
    public String getName() {
        System.out.println("getName");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println("setName");
        this.name=name;
    }

    @Override
    public String getAge() {
        System.out.println("getAge");
        return age;
    }

    @Override
    public void setAge(String age) {
        System.out.println("setAge");
        this.age=age;
    }
}
