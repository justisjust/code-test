package com.hzb.tomcat.http;

import java.io.IOException;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-03-04 0:32
 * @Version 1.0
 */
public abstract class HServlet {

    public void service(HRequest request, HResponse response) throws IOException {
        if("get".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }

    }

    public abstract void doGet(HRequest request, HResponse response) throws IOException;

    public abstract void doPost(HRequest request, HResponse response) throws IOException;
}
