package com.hzb.nettystudy.im.coder;

import com.hzb.nettystudy.im.protocol.Header;
import com.hzb.nettystudy.im.protocol.MessageRecord;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName RecordMessageIncode.java
 * @Description TODO
 * @createTime 2022年05月22日 13:28:00
 */
public class RecordMessageEncode extends MessageToByteEncoder<MessageRecord> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageRecord mess, ByteBuf out) throws Exception {
        Header header = mess.getHeader();
        out.writeLong(header.getSessionId());
        out.writeByte(header.getReqType());

        Object body = mess.getBody();
        if(body != null) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(body);
            byte[] bytes = outputStream.toByteArray();
            out.writeInt(bytes.length);
            out.writeBytes(bytes);
        }else {
            out.writeInt(0);
        }
    }
}
