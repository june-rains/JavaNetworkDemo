package com.changhao.demo03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class TestUDPClient {
    public static void main(String[] args) throws Exception {
        // 1. set up connection
        DatagramSocket socket = new DatagramSocket();

        // 2. set up packet
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 8888;
        String info = "hello udp server!";
        DatagramPacket packet = new DatagramPacket(info.getBytes(), 0, info.length(), inetAddress, port);

        // 3. send packet
        socket.send(packet);

        // 4. close the connection
        socket.close();
    }

}
