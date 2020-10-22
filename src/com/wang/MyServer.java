package com.wang;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Wang
 * @version 1.0
 * @date 2020/9/18 - 11:29
 * @description com.wang
 */
public class MyServer {

    public static void main(String[] args) {
        int port = 8080;
        try {
            StartServer(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void StartServer(int port) throws Exception {

        ServerSocket serverSocket = new ServerSocket(port);
        //定义客户端套接字
        Socket socket = null;

        while (true) {
            //获取套接字
            socket = serverSocket.accept();
            //通过套接字获取输入流输出流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            //定义请求对象
            MyRequest request = new MyRequest(inputStream);
            //响应对象
            MyResponse response = new MyResponse(outputStream);
            //
            String clazz = new MyMapping().getHashMap().get(request.getRequestUrl());
            if (clazz != null) {
                Class<?> aClass = Class.forName(clazz);
                MyServlet myServlet = (MyServlet) aClass.newInstance();
                myServlet.service(request,response);
            }
        }
    }

}
