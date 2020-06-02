package com.softwareconstruction.math.utils;

/**
 * @author NGX
 * @Date 2020/5/16 19:01
 */
public class Result {
    private static final int SUCCESS = 200;
    private static final int FAILED = 500;
    private int code;
    private String message;
    private Object data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result successWithData(Object data) {
        return new Result(SUCCESS, "success", data);
    }

    public static Result successWithoutData() {
        return new Result(SUCCESS, "success");
    }
}