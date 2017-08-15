package cn.com.time.jdk.jmx.notification;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.rmi.RemoteException;

/**
 * Created by TimaNetworks on 2017/7/21.
 */
public class Jack extends NotificationBroadcasterSupport implements JackMBean{

    private int seq=0;

    public void hi() throws RemoteException {
        Notification notify=new Notification("jack.hi",this,++seq,System.currentTimeMillis(),"jack");
        sendNotification(notify);
    }

}
