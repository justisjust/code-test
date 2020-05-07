package com.hzb.nettystudy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-04-05 0:23
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket server = new Socket("127.0.0.1", 8088);
        Client client = new Client("xiao");

        client.sendMessage(server);

    }

    private String name;

    public Client(String name) {
        this.name = name;
    }

    public void sendMessage(Socket server) {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
                reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
                writer = new PrintWriter(server.getOutputStream(), true);
                writer.println(name + " say : " + 100);
                writer.println(name + " say : " + 301);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
