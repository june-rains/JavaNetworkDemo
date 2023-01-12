package com.changhao.demo02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TestTCPClientDemo01 {
    public static void main(String[] args) {
        InetAddress inetAddress;
        Socket socket = null;
        OutputStream os = null;
        try {
            inetAddress = InetAddress.getByName("127.0.0.1");
            int port = 9999;

            socket = new Socket(inetAddress, port);
            os = socket.getOutputStream();
            os.write("hello, server".getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
