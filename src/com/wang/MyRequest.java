package com.wang;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Wang
 * @version 1.0
 * @date 2020/9/17 - 16:56
 * @Description com.wang
 */
public class MyRequest {
    //请求方式
    private String requestMethod;
    //请求地址
    private String requestUrl;
    /**
     * 请求
     * @param inputStream 输入流
     */
    public MyRequest(InputStream inputStream) throws IOException {
        //缓存区域
        byte[] buffer = new byte[1024];
        //定义请求长度
        int len = 0;
        //定义请求变量
        String str = "";
        //读取输入流
        if ((len = inputStream.read(buffer)) > 0) {
            str = new String(buffer, 0, len);
        }
        //解析.GET HTTP 1.1,取第一个元素
        String data = str.split("\n")[0];
        String[] params = data.split(" ");
        this.requestMethod = params[0];
        requestUrl = params[1];

    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }


}
