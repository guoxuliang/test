package com.example.administrator.test;

/**
 * Created by Administrator on 2017/6/26 0026.
 */

public class SecondEvent {
    private String mMsg;
    public SecondEvent(String msg) {
        // TODO Auto-generated constructor stub
        mMsg = "MainEvent:"+msg;
    }
    public String getMsg(){
        return mMsg;
    }
}
