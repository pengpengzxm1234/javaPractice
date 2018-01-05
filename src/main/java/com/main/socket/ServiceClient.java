package com.main.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author pengpeng
 * @date 2018/1/5 下午2:24
 * @desc
 */
public class ServiceClient {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try{
            // 向服务器发出请求建立连接
            socket = new Socket("localhost", 8899);
            // 从socket中获取输入输出流
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            PrintWriter writer = new PrintWriter(out);
            writer.println("hello world!!!");
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String result = reader.readLine();
            System.out.println(result);

            in.close();
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            socket.close();
        }

    }
}
