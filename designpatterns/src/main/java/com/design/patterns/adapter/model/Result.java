package com.design.patterns.adapter.model;

public class Result<T> {

    private String code;
    private T objcet;
    private String msg;

    private static final String FAIL_CODE = "500";
    private static final String SUCCESS_CODE = "200";

    public Result(String code, T objcet, String msg) {
        this.code = code;
        this.objcet = objcet;
        this.msg = msg;
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result() {

    }

    public Result(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getObjcet() {
        return objcet;
    }

    public void setObjcet(T objcet) {
        this.objcet = objcet;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public  Result createError() {
        return new Result<T>(FAIL_CODE, "登录错误");
    }

    public  Result createError(T object) {
        return new Result<T>(FAIL_CODE, objcet, "出现异常");
    }

    public Result createSuccess() {
        return new Result<T>(SUCCESS_CODE, "登录成功");
    }

    public Result createSuccess(T object) {
        return new Result<T>(SUCCESS_CODE, objcet, "处理成功");
    }
}
