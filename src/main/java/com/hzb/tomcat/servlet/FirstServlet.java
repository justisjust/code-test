package com.hzb.tomcat.servlet;

import com.hzb.tomcat.http.HRequest;
import com.hzb.tomcat.http.HResponse;
import com.hzb.tomcat.http.HServlet;

import java.io.IOException;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-03-04 0:31
 * @Version 1.0
 */
public class FirstServlet extends HServlet {
    @Override
    public void doGet(HRequest request, HResponse response) throws IOException {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HRequest request, HResponse response) throws IOException {

        String s = "㛑";
        
        response.write("this first servlet 㛑");
    }
}
