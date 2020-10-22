package com.wang;

/**
 * @author Wang
 * @version 1.0
 * @date 2020/9/17 - 17:58
 * @description com.wang
 */
public abstract class MyHttpServlet {

    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";


    public abstract void doGet(MyRequest request, MyResponse response) throws Exception;
    public abstract void doPost(MyRequest request, MyResponse response) throws Exception;

    /**
     * 判断请求类型,选择处理方式
     * @param request
     * @param response
     */
    public void service(MyRequest request, MyResponse response) throws Exception {
        if (METHOD_GET.equals(request.getRequestMethod())) {
            doGet(request, response);
        } else if (METHOD_POST.equals(request.getRequestMethod())) {
            doPost(request, response);
        }
    }
}
