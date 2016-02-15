package com.doctor.jsonrpc;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import com.googlecode.jsonrpc4j.JsonRpcServer;

/**
 * @author sdcuike
 *
 * @time 2016年2月15日 上午11:20:50
 */
public class Practice01Server {

    public static void main(String[] args) throws LifecycleException {
        UserService userService = new UserServiceImpl();
        JsonRpcServer jsonRpcServer = new JsonRpcServer(userService, UserService.class);

        Tomcat tomcat = new Tomcat();
        String baseDir = new File(System.getProperty("java.io.tmpdir")).getAbsolutePath();
        tomcat.setBaseDir(baseDir);
        tomcat.setHostname("localhost");
        tomcat.setPort(8099);
        tomcat.getConnector().setProperty("maxThreads", "10");
        tomcat.getConnector().setProperty("maxConnections", "10");
        tomcat.getConnector().setProperty("URIEncoding", "UTF-8");
        tomcat.getConnector().setProperty("connectionTimeout", "60000");
        tomcat.getConnector().setProperty("maxKeepAliveRequests", "-1");
        tomcat.getConnector().setProtocol("org.apache.coyote.http11.Http11NioProtocol");

        Context context = tomcat.addContext("/", baseDir);

        Tomcat.addServlet(context, "dispatcher", new HttpServlet() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                jsonRpcServer.handle(req, resp);
            }
        });

        context.addServletMapping("/*", "dispatcher");

        tomcat.start();
        tomcat.getServer().await();
    }
}
