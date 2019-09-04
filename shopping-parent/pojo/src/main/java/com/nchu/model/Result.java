package com.nchu.model;

import java.io.Serializable;

/**
 * 返回结果
 * success:返回成功与失败的boolean的值
 * message：返回具体信息
 */
public class Result implements Serializable {
    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "success:'" + success + '\'' +
                ", message:'" + message + '\'' +
                '}';
    }
}
