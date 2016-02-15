package com.doctor.jsonrpc;

/**
 * @author sdcuike
 *
 * @time 2016年2月15日 上午11:44:31
 */
public class UserServiceImpl implements UserService {

    @Override
    public String getName(String name) {
        return "hello " + name;
    }

}
