package com.changhao.demo03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatSender {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        // the input is system in
        while(true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String input = bufferedReader.readLine();
            int port = 9090;
            InetAddress inetAddress = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(input.getBytes(), 0, input.getBytes().length, inetAddress, port);

            socket.send(packet);
            if (input.equals("bye")) {
                break;
            }
        }
        socket.close();
    }
}
