package com.changhao.demo03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatReceiver {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9090);
        while(true) {
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);

            socket.receive(packet);
            String info = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Sender sends " + info);

            if(info.equals("bye")) {
                break;
            }
        }

        // when we receive the "bye" string, we can close the connection
        socket.close();

    }
}
