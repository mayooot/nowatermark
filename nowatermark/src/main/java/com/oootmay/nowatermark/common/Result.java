package com.oootmay.nowatermark.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>项目文档： 返回结果</p>
 *
 * @author liming
 * @version 1.0.0
 * @createTime 2022年01月30日 11:24:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String code;
    private String msg;
    private T data;


    /**
     * 返回成功的结果，不携带数据
     * @return
     */
    public static Result<Object> success() {
        Result<Object> result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
    }

    /**
     * 返回成功的结果，携带数据
     * @return
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    /**
     * 返回失败的结果，不携带数据
     * @param code 状态码
     * @param msg 信息
     * @return 结果
     */
    public static Result<Object> error(String code, String msg) {
        Result<Object> result = new Result<>();
        result.setData(code);
        result.setMsg(msg);
        return result;
    }

}
