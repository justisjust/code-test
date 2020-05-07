package com.hzb.tomcat.http;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-03-04 0:33
 * @Version 1.0
 */
public class HResponse {

    OutputStream os;

    public HResponse(OutputStream os) {
        this.os = os;
    }

    public void write(String s) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append("HTTP/1.1 200 ok \n")
                .append("Content-Type: text/html;\n")
                .append("\r\n")
                .append(s);
        os.write(sb.toString().getBytes());
    }
}
