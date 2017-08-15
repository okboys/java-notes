package cn.com.time.jdk.jmx.mbean;
import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

public class MBeanClient {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
        MBeanServer server= ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName=new ObjectName("jmxBean:name=hello");
        server.registerMBean(new Hello(),objectName);
        LocateRegistry.createRegistry(9999);
        JMXServiceURL url=new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
        JMXConnectorServer jcs= JMXConnectorServerFactory.newJMXConnectorServer(url,null,server);
        System.out.println("begin rmi start");
        jcs.start();
        System.out.println("rmi start");

    }
}
