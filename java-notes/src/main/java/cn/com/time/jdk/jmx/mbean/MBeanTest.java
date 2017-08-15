package cn.com.time.jdk.jmx.mbean;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

/**
 * Created by TimaNetworks on 2017/7/21.
 */
public class MBeanTest {

    public static void main(String[] args) throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException, InvalidAttributeValueException {
        JMXServiceURL url=new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
        JMXConnector jmxc= JMXConnectorFactory.connect(url,null);
        MBeanServerConnection mbsc=jmxc.getMBeanServerConnection();
        ObjectName objectName=new ObjectName("jmxBean:name=hello");
        String[] domains=mbsc.getDomains();
        for (String s:domains){
            System.out.println("Domain:"+s);
        }
        mbsc.setAttribute(objectName,new Attribute("Name","杭州"));
        mbsc.setAttribute(objectName,new Attribute("Age","1990"));
        String age= (String) mbsc.getAttribute(objectName,"Age");
        String name= (String) mbsc.getAttribute(objectName,"Name");
        System.out.println("age="+age+";name="+name);
        HelloMBean proxy=MBeanServerInvocationHandler.newProxyInstance(mbsc,objectName,HelloMBean.class,false);
        proxy.getAge();

        //
        mbsc.invoke(objectName,"getName",null,null);
    }

}
