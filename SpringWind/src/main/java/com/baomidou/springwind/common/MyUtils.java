package com.baomidou.springwind.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MyUtils {
    /**
     * 生成订单的编号
     * @return
     */
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return newDate+result;
    }

    /**
     * 通过用户的id生成订单编号
     * @param userId    用户的id
     * @return  带用户id的订单编号
     */
    public static String getOrderIdByTime(String userId) {
        String orderIdByTime = getOrderIdByTime();

        return orderIdByTime+userId;
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getOrderIdByTime());
        System.out.println(getOrderIdByTime("20"));
    }
}
