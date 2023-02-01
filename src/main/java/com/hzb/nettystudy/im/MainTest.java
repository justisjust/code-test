package com.hzb.nettystudy.im;

import com.hzb.nettystudy.im.coder.RecordMessageDecoder;
import com.hzb.nettystudy.im.coder.RecordMessageEncode;
import com.hzb.nettystudy.im.protocol.Header;
import com.hzb.nettystudy.im.protocol.MessageRecord;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName MainTest.java
 * @Description TODO
 * @createTime 2022年05月22日 13:45:00
 */
public class MainTest {

    public static void main(String[] args) {
        EmbeddedChannel channel = new EmbeddedChannel(
                new LoggingHandler(),
                new RecordMessageDecoder(),
                new RecordMessageEncode());
        Header header = new Header();
        header.setSessionId(12444);
        header.setReqType((byte) 1);
        MessageRecord record = new MessageRecord();
        record.setHeader(header);
        record.setBody("hello world");

        channel.writeOutbound(record);
    }
}
