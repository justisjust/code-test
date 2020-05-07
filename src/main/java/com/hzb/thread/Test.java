package com.hzb.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-04-03 10:19
 * @Version 1.0
 */
public class Test {

    volatile static Map<String, Integer> map = new ConcurrentHashMap();

//    public static void main(String[] args) throws InterruptedException {
//
//            map.put("1", 1);
//            new Thread(() -> {
//                    map.put("1",2);
//            }).start();
//
//        Thread.sleep(1000);
//        System.out.println(map.get("1"));
//    }

    public static void main(String[] args) {
        String s = "{\"task_id\":240,\"rsp_code\":0,\"task_status\":2,\"finish_num\":1,\"total_num\":1,\"finish_pkts\":0,\"total_pkts\":0}";
        ProcessRate process = JSON.parseObject(s, ProcessRate.class);
        JSONObject object = JSON.parseObject(s);
        System.out.println(JSON.toJSONString(process));
        System.out.println(process.getRspCode());
    }
}
