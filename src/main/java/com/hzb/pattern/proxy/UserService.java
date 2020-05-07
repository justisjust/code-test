package com.hzb.pattern.proxy;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-05-06 18:49
 * @Version 1.0
 */
public class UserService implements IUserService {
    @Override
    public String select(String name) {
        System.out.println(name + " 开始查询……");
        return "one user;";
    }
}
