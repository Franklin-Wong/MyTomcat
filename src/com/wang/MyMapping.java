package com.wang;

import java.util.HashMap;

/**
 * @author Wang
 * @version 1.0
 * @date 2020/9/17 - 17:32
 * @description com.wang
 */
public class MyMapping {

    public static HashMap<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("/mytomcat", "com.wang.MyServlet");
    }
    public HashMap<String, String> getHashMap() {
        return hashMap;
    }
}
