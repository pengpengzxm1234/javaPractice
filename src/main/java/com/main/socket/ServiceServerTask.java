package com.main.socket;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

/**
 * @author pengpeng
 * @date 2018/1/5 下午2:05
 * @desc
 */
public class ServiceServerTask implements Runnable {
    Socket socket;

    public ServiceServerTask(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try{
            //从socket连接中获取客户端之间的网络通信输入流
            in = socket.getInputStream();
            out = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            //从socket通信的输入流中获取输入流的数据
            //socket的inputstream输入流是阻塞的
            String param = "";
            while ((param = reader.readLine()) != null){
                String result = new GetDataServiceImpl().getData(param);

                PrintWriter pw = new PrintWriter(out);
                pw.println(result);
                pw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
