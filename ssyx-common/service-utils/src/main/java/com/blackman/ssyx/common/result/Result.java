package com.blackman.ssyx.common.result;

import lombok.Data;

/**
 * 返回前端的信息
 * @param <T>
 */
@Data
public class Result<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回的信息
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    private Result() {

    }

    public static<T> Result build(T data, ResultCodeEnum resultCodeEnum) {
        Result result = new Result();
        if (data != null) {
            result.setData(data);
        }
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static<T> Result ok(T data) {
        return build(data, ResultCodeEnum.SUCCESS);
    }

    public static<T> Result error(T data) {
        return build(data, ResultCodeEnum.FAIL);
    }
}
