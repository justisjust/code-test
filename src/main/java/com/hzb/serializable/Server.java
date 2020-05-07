package com.hzb.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description 序列化服务端
 * @Author haozhenbo
 * @Date 2020-01-29 15:12
 * @Version 1.0
 */
public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        User user = (User) inputStream.readObject();

        System.out.println(user.toString());
    }
}
