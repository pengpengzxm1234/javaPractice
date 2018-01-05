package com.main.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 一个简单的socket编程
 * @author pengpeng
 * @date 2018/1/5 下午1:46
 * @desc
 * socket服务端,
 */
public class ServiceServer {


    public static void main(String[] args) throws Exception {
            //创建一个socketServer，地址localhost，端口号8899
            ServerSocket server = new ServerSocket();
            server.bind(new InetSocketAddress("localhost", 8899));

            //接受客户端的请求，accept（）是一个阻塞方法，会一直等待，直到又客户端请求连接才返回
            boolean isTrue = true;
            while (isTrue) {
                Socket socket = server.accept();
                new Thread(new ServiceServerTask(socket)).start();
            }
    }


}
