package com.doctor.java.jmx;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

/**
 * @author sdcuike
 *
 * @time 2016年2月9日 下午9:56:27
 */
public class SystemConfigManagement {

    private static final int DEFAULT_NO_THREADS = 10;
    private static final String DEFAULT_SCHEMA = "default";

    public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, InterruptedException {
        // Get the MBean server
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        // register the MBean
        SystemConfig systemConfig = new SystemConfig(DEFAULT_NO_THREADS, DEFAULT_SCHEMA);
        ObjectName objectName = new ObjectName("com.doctor.java.jmx:type=SystemConfig");
        mBeanServer.registerMBean(systemConfig, objectName);

        do {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Thread Count=" + systemConfig.getThreadCount() + ":::Schema Name=" + systemConfig.getSchemaName());
        } while (systemConfig.getThreadCount() != 0);
    }

}
