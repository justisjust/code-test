package com.hzb.nettystudy.im.protocol;

import lombok.Data;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName MessageRecord.java
 * @Description TODO
 * @createTime 2022年05月22日 13:28:00
 */
@Data
public class MessageRecord {

    private Header header;
    private Object body;
}
