package com.wang;

/**
 * @author Wang
 * @version 1.0
 * @date 2020/9/18 - 10:54
 * @description com.wang
 */
public class MyServlet extends MyHttpServlet {

    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception {
        response.write("get mytomcat");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception {
        response.write("post mytomcat");
    }
}
