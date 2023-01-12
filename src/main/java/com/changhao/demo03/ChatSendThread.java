package com.changhao.demo03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ChatSendThread implements Runnable {
    private DatagramSocket socket;
    private BufferedReader bufferedReader;
    private  int fromPort;
    private int toPort;
    private String toIP;

    public ChatSendThread(int fromPort, int toPort, String toIP) {
        this.fromPort = fromPort;
        this.toPort = toPort;
        this.toIP = toIP;
        try {
            this.socket = new DatagramSocket(fromPort);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        // the input is system in
        while(true) {
            try {
                String input = bufferedReader.readLine();
                InetAddress inetAddress = InetAddress.getByName(toIP);
                DatagramPacket packet = new DatagramPacket(input.getBytes(), 0, input.getBytes().length, inetAddress, toPort);

                socket.send(packet);
                if (input.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
