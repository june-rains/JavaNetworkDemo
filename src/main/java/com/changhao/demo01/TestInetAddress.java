package com.changhao.demo01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            InetAddress inetAddress2 = InetAddress.getByName("localhost");
            InetAddress inetAddress3 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress1);
            System.out.println(inetAddress2);
            System.out.println(inetAddress3);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}


