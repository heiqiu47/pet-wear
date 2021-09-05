package com.example.petwear.utils;

import static com.example.petwear.utils.Constants.RESULT_CODE_SERVER_ERROR;

public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "请求成功";
    private static final String DEFAULT_FAIL_MESSAGE = "请求失败";

    public static Result<Object> genSuccessResult() {
        Result<Object> result = new Result<>();
        result.setCode(Constants.RESULT_CODE_SUCCESS);
        result.setMsg(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static Result<Object> genSuccessResult(String msg) {
        Result<Object> result = new Result<>();
        result.setCode(Constants.RESULT_CODE_SUCCESS);
        result.setMsg(msg);
        return result;
    }
    public static <T> Result<T> genSuccessResult(T data) {
        Result<T> result = new Result<>();
        result.setCode(Constants.RESULT_CODE_SUCCESS);
        result.setMsg(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }
    public static <T> Result<T> genSuccessResult(String msg,T data) {
        Result<T> result = new Result<>();
        result.setCode(Constants.RESULT_CODE_SUCCESS);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result<Object> genErrorResult(String message) {
        Result<Object> result = new Result<>();
        result.setCode(RESULT_CODE_SERVER_ERROR);
        result.setMsg(message);
        return result;
    }
}
