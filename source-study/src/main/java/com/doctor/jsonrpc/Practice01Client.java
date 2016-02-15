package com.doctor.jsonrpc;

import java.net.URL;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;

/**
 * @author sdcuike
 *
 * @time 2016年2月15日 下午3:17:35
 */
public class Practice01Client {

    public static void main(String[] args) throws Throwable {
        JsonRpcHttpClient jsonRpcHttpClient = new JsonRpcHttpClient(new URL("http://localhost:8099/com.doctor.jsonrpc.UserService"));
        String result = jsonRpcHttpClient.invoke("getName", new Object[] { "docotr who" }, String.class);
        System.out.println(result);

        // or user ProxyUtil
        UserService userService = ProxyUtil.createClientProxy(UserService.class.getClassLoader(), UserService.class, jsonRpcHttpClient);
        String name = userService.getName("doctor who !");
        System.out.println(name);
    }

}
