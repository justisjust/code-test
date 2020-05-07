package com.hzb.netty.rpc.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-03-04 22:02
 * @Version 1.0
 */
@Data
public class InvokerProtocol implements Serializable {

//    服务名
    private String className;
// 方法名，具体的逻辑
    private String method;
//    形参列表
    private Class<?>[] params;
//    实参
    private Object[] values;
}
