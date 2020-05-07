package com.hzb.tomcat;

import com.hzb.tomcat.http.HRequest;
import com.hzb.tomcat.http.HResponse;
import com.hzb.tomcat.http.HServlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Properties;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-03-04 9:17
 * @Version 1.0
 */
public class HTomcat {

    HashMap<String, HServlet> mapping;

    private void init() throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        mapping = new HashMap<>();
        Properties properties = new Properties();
        String web_info = this.getClass().getResource("/").getPath();
        FileInputStream inputStream = new FileInputStream(web_info + "web.properties");
        properties.load(inputStream);

        for (Object o : properties.keySet()) {
            String key = o.toString();
            if(key.endsWith(".url")) {
                String servletName = key.replace("url", "class");
                String url = (String) properties.get(key);
                String className = properties.get(servletName).toString();
                HServlet servlet = (HServlet) Class.forName(className).newInstance();

                mapping.put(url, servlet);
            }
        }
    }

    public void start() {
        try {
            init();
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务器启动，端口 8080");
            while (true) {
                Socket accept = serverSocket.accept();
                process(accept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(Socket accept) throws IOException {
        InputStream inputStream = accept.getInputStream();
        HRequest request = new HRequest(inputStream);


        OutputStream outputStream = accept.getOutputStream();
        HResponse response = new HResponse(outputStream);

        String url = request.getUrl();
        if(mapping.containsKey(url)) {
            mapping.get(url).service(request, response);
        } else {
            response.write("404,Not found");
        }

        outputStream.flush();
        outputStream.close();

        inputStream.close();
        accept.close();

    }

    public static void main(String[] args) {
        new HTomcat().start();
    }
}
