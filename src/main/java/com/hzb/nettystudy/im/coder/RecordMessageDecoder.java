package com.hzb.nettystudy.im.coder;

import com.hzb.nettystudy.im.protocol.Header;
import com.hzb.nettystudy.im.protocol.MessageRecord;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName RecordMessageIncode.java
 * @Description TODO
 * @createTime 2022年05月22日 13:28:00
 */
public class RecordMessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        MessageRecord messageRecord = new MessageRecord();
        Header header = new Header();
        header.setSessionId(byteBuf.readLong());
        header.setReqType(byteBuf.readByte());
        header.setLength(byteBuf.readInt());
        messageRecord.setHeader(header);
        if(header.getLength() > 0 ){
            byte[] content = new byte[header.getLength()];
            byteBuf.readBytes(content);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Object o = ois.readObject();
            messageRecord.setBody(o);
        }else {
            System.out.println("消息为空");
        }
    }
}
