package com.doctor.java.jmx;

/**
 * @author sdcuike
 *
 * @time 2016年2月9日 下午9:47:04
 * 
 * @see http://www.journaldev.com/1352/what-is-jmx-mbean-jconsole-tutorial
 *      The interface name must end with MBean
 */
public interface SystemConfigMBean {
    public void setThreadCount(int noOfThreads);

    public int getThreadCount();

    public void setSchemaName(String schemaName);

    public String getSchemaName();

    // any method starting with get and set are considered
    // as attributes getter and setter methods, so I am
    // using do* for operation.
    public String doConfig();

}
