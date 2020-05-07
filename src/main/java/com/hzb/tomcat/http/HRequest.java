package com.hzb.tomcat.http;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-03-04 0:30
 * @Version 1.0
 */
public class HRequest {

    private String url;
    private String method;

    public HRequest(InputStream is) {
        byte[] buffer = new byte[1024];
        int length = 0;
        String content = "";
        try {
            if ((length = is.read(buffer)) > 0) {
                content = new String(buffer, 0, length);
            }
            if (StringUtils.isBlank(content)) {
                return;
            }
            String line = content.split("\\n")[0];
            String[] arr = line.split("\\s");
            //            System.out.println(JSON.toJSONString(arr));
            this.method = arr[0];
            this.url = arr[1].split("\\?")[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }
}
