package com.briehman.wildfly.mbean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebappListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        MBeanServlet.isRegisteredAtStartup = MBeanServlet.isRegistered();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
