package com.hzb.nettystudy.im.protocol;

import lombok.Data;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName protocol.java
 * @Description TODO
 * @createTime 2022年05月22日 13:20:00
 */
@Data
public class Header {

    //8字节
    private long sessionId;
    //1字节，消息类型
    private byte reqType;
    //4字节，消息长度
    private int length;
}
