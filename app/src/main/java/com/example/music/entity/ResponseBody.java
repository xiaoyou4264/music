package com.example.music.entity;

public class ResponseBody {

    private int code;
    private String msg;
    Page<HomePageInfo> data;

    public ResponseBody() {
    }

    public ResponseBody(int code, String msg, Page<HomePageInfo> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Page<HomePageInfo> getData() {
        return data;
    }

    public void setData(Page<HomePageInfo> data) {
        this.data = data;
    }
}
