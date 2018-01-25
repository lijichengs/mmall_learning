package com.mmall.common;

/**
 * Created with IntelliJ IDEA.
 * ResponseCode
 *
 * @author lijc
 * @date 2018/1/25 15:04
 */
public enum ResponseCode {
    SUCCESS(0, "SUCCCESS"),
    ERROR(1, "ERROR"),
    NEED_LOGIN(10, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
