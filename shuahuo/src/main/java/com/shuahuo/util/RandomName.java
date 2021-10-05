package com.shuahuo.util;

import java.util.Date;

public class RandomName {
    public static String GetRandomName(){
        int len = 8;
        String chars = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678";  //默认去掉了容易混淆的字符oOLl,9gq,Vv,Uu,I1
        int maxPos = chars.length();
        String randomstr = "";
        for(int i = 0; i < len; i++){
            randomstr += chars.charAt((int)Math.floor(Math.random() * maxPos));
        }

        Date now = new Date();
        int IntYear = now.getYear()+1900;
        String year = Integer.toString(IntYear);

        int IntMouth = now.getMonth()+1;
        String mouth = "";
        if(IntMouth<10) {
            mouth = "0" + Integer.toString(IntMouth);
        }else{
            mouth = Integer.toString(IntMouth);
        }

        int IntDate = now.getDate();
        String date = "";
        if(IntDate<10) {
            date = "0" + Integer.toString(IntDate);
        }else{
            date = Integer.toString(IntDate);
        }

        int IntHours = now.getHours();
        String hours = "";
        if(IntHours<10) {
            hours = "0" + Integer.toString(IntHours);
        }else{
            hours = Integer.toString(IntHours);
        }

        int IntMinutes = now.getMinutes();
        String minutes = "";
        if(IntMinutes<10) {
            minutes = "0" + Integer.toString(IntMinutes);
        }else{
            minutes = Integer.toString(IntMinutes);
        }
        String time = year+mouth+date+hours+minutes;

        System.out.println("getTime:"+now);
        System.out.println("时间"+time+"_"+randomstr);
        return time+"_"+randomstr;
    }

    public static String GetRandomNumber(int digit){
        if(digit > 10){
            return "最高随机10位数";
        }
        long flag = 10;
        for (int i = 1;i<digit-1;i++){
            flag = flag * 10;
        }
        int newNum = (int)((Math.random()*9+1)*flag);
        System.out.println(newNum);
        return String.valueOf(newNum);
    }
}
