package cn.com.time.jdk.jmx.mbean;


import javax.management.*;
import java.lang.management.ManagementFactory;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by TimaNetworks on 2017/7/20.
 */
public class Main {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanException, InstanceNotFoundException, ReflectionException, InterruptedException, RemoteException {
        MBeanServer server=ManagementFactory.getPlatformMBeanServer();
        ObjectName name=new ObjectName("jmxBean:name=hello");
        server.registerMBean(new Hello(),name);
        Thread.sleep(Integer.MAX_VALUE);
        LocateRegistry.createRegistry(9999);
    }

}
