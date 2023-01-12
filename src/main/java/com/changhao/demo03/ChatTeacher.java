package com.changhao.demo03;

public class ChatTeacher {
    public static void main(String[] args) {
        new Thread(new ChatSendThread(2345, 9090, "localhost")).start();
        new Thread(new ChatReceiveThread(9999, "students")).start();
    }
}
