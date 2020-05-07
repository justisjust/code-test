package com.hzb.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-01-28 14:33
 * @Version 1.0
 */
public class ClientSocketDemo {

    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 8080);
            //输出流
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            //控制台输入数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //获取服务端输入流
            BufferedReader serverOut = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            while (true) {
                String line = reader.readLine();
                if("bye".equals(line)) {
                    return;
                }
                out.println(line);
                out.flush();

                System.out.println("服务端数据：" + serverOut.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
