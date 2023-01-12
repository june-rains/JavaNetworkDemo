package com.changhao.demo03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TestUDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);

        socket.receive(packet);

        // print the received data
        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        // close the socket
        socket.close();
    }
}
