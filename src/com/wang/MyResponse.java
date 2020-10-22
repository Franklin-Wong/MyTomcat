package com.wang;

import java.io.OutputStream;

/**
 * @author Wang
 * @version 1.0
 * @date 2020/9/17 - 17:24
 * @description com.wang
 */
public class MyResponse {

    //响应数据
    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String string) throws Exception{
        StringBuilder builder = new StringBuilder();
        builder.append("HTTP/1.1 200 OK\n")
        .append("Content-Type:text/html\n")
                .append("\r\n")
                .append("<Html>")
                .append("<Body>")
        .append("<h1>"+string+"</h1>")
        .append("</Body>")
        .append("</Html>");
        outputStream.write(builder.toString().getBytes());
        outputStream.flush();
        outputStream.close();
    }

}
