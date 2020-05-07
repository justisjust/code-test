package com.hzb.nettystudy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-04-05 0:09
 * @Version 1.0
 */
public class Server {

    public static void main(String[] args) {
        start();
    }

    private static int default_port = 8088;
    private static ServerSocket serverSocket;

    private static void start() {

        start(default_port);

    }

    private static void start(int port) {
        if(serverSocket != null) return;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println(" start server " + port);
            while (true) {
                Socket accept = serverSocket.accept();
                process(accept);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void process(Socket accept) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            PrintWriter writer = new PrintWriter(accept.getOutputStream());
            String data;
            while (true) {
                if((data = reader.readLine()) == null) break;
                writer.write(data);
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
