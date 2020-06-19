package com.triumphxx.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author:triumphxx
 * @Date:2020/6/19
 * @Time:8:51 上午
 * @微信公众号：北漂码农有话说
 * @desc:
 **/
@Data
public class Result implements Serializable {

    // 0成功，-1失败
    private int status;
    private String msg;
    private Object data;

    public static Result success() {
        return Result.success("操作成功", null);
    }

    public static Result success(Object data) {
        return Result.success("操作成功", data);
    }

    public static Result success(String msg, Object data) {
        Result result = new Result();
        result.status = 0;
        result.msg = msg;
        result.data = data;
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result();
        result.status = -1;
        result.data = null;
        result.msg = msg;
        return result;
    }

}
