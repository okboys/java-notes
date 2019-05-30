package cn.com.time.jdk.jmx.notification;


import javax.management.Notification;
import javax.management.NotificationListener;

public class HelloListener implements NotificationListener{
    @Override
    public void handleNotification(Notification notification, Object handback) {
        if(handback instanceof User){
            User hello= (User) handback;
            hello.printHello(notification.getMessage());
        }
    }
}
