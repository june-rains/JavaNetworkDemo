package com.changhao.demo03;

public class ChatStudent {
    public static void main(String[] args) {
        new Thread(new ChatSendThread(1234, 9999, "localhost")).start();
        new Thread(new ChatReceiveThread(9090, "teacher")).start();
    }
}
