package com.hotel.util;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerContext implements
        ServletContextListener, ServletContextAttributeListener,
        ServletRequestListener,ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        //System.out.println("增加了ServletContext属性");
        //System.out.println(scae.getName());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        //System.out.println("替换了ServletContext属性");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        //System.out.println("移除了ServletContext属性");

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //System.out.println("项目启动...");
       /* Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").
                        format(LocalDateTime.now()));
            }
        },0,2000);*/
    }
}
