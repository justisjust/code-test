package com.hzb.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-01-28 14:27
 * @Version 1.0
 */
public class ServerSocketDemo {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            //输入流
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            //输出流
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            //通过控制台输入数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //控制台输入内容
            while (true) {
                String line = reader.readLine();

                if("bye".equals(line)) {
                    return;
                }
                //写回到客户端
                writer.println(line);
                writer.flush();

                System.out.println("客户端数据：" + bufferedReader.readLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
