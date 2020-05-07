package com.hzb.serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-01-29 15:21
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 8080);
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    client.getOutputStream());

            User user = new User();
            user.setAge(12);
            user.setName("t");
            outputStream.writeObject(user);

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
