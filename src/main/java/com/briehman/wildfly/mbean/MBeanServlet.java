package com.briehman.wildfly.mbean;

import java.io.*;
import java.lang.management.ManagementFactory;
import javax.management.ObjectName;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet(value="/mbean", name="mbean-servlet")
public class MBeanServlet extends GenericServlet {
    public static Boolean isRegisteredAtStartup;

    public void service(ServletRequest req, ServletResponse res)
            throws IOException, ServletException
    {
        PrintWriter w = res.getWriter();
        w.println("Registered at startup: " + isRegisteredAtStartup);
        w.println("Registered currently: " + isRegistered());
    }

    public static boolean isRegistered() {
        try {
            ObjectName objectName = new ObjectName("jboss.as:subsystem=datasources,data-source=ExampleDS");
            return ManagementFactory.getPlatformMBeanServer().isRegistered(objectName);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            return false;
        }

    }
}
