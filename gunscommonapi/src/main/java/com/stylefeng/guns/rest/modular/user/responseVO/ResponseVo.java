package com.stylefeng.guns.rest.modular.user.responseVO;

public class ResponseVo<T> {
     private T data;
     private int status;
     private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResponseVo() {
    }

    public ResponseVo(T data, int status, String msg) {
        this.data = data;
        this.status = status;
        this.msg = msg;
    }
}
