package cn.com.time.jdk.jmx.notification;

import cn.com.time.jdk.jmx.mbean.Hello;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Main {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer server= ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName=new ObjectName("yunge:name=hello");
        Hello hello=new Hello();
        server.registerMBean(hello,objectName);
        Jack jack=new Jack();
        server.registerMBean(jack,new ObjectName("jack:name=Jack"));
        jack.addNotificationListener(new HelloListener(),null,hello);
        Thread.sleep(500000);
    }

}
