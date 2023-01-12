package com.changhao.demo03;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatReceiveThread implements Runnable {
    private DatagramSocket socket;
    private int fromPort;
    private String userName;

    public ChatReceiveThread(int fromPort, String userName) {
        this.fromPort = fromPort;
        this.userName = userName;
        try {
            this.socket = new DatagramSocket(fromPort);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try{
            while(true) {
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);

                socket.receive(packet);
                String info = new String(packet.getData(), 0, packet.getLength());
                System.out.println(userName + " says: " + info);

                if(info.equals("bye")) {
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        // when we receive the "bye" string, we can close the connection
        socket.close();
    }
}
