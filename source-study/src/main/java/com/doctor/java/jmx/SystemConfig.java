package com.doctor.java.jmx;

/**
 * @author sdcuike
 *
 * @time 2016年2月9日 下午9:51:53
 */
public class SystemConfig implements SystemConfigMBean {

    private int threadCount;
    private String schemaName;

    public SystemConfig(int threadCount, String schemaName) {
        this.threadCount = threadCount;
        this.schemaName = schemaName;
    }

    @Override
    public void setThreadCount(int noOfThreads) {
        this.threadCount = noOfThreads;

    }

    @Override
    public int getThreadCount() {
        return threadCount;
    }

    @Override
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;

    }

    @Override
    public String getSchemaName() {
        return schemaName;
    }

    @Override
    public String doConfig() {
        return "No of Threads=" + this.threadCount + " and DB Schema Name=" + this.schemaName;

    }

}
