package com.hotel.util;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class CountOnLine implements HttpSessionListener {
    private int count;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
        se.getSession().getServletContext().setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
        se.getSession().getServletContext().setAttribute("count",count);
    }
}
