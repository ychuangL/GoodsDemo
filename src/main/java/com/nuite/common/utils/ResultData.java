package com.nuite.common.utils;

import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回数据
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
public class ResultData extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResultData() {
        put("code", 0);
        put("msg", "success");
    }

    public ResultData put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static ResultData error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static ResultData error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static ResultData error(int code, String msg) {
        ResultData resultData = new ResultData();
        resultData.put("code", code);
        resultData.put("msg", msg);
        return resultData;
    }


    public static ResultData ok() {
        return new ResultData();
    }

    public static ResultData ok(String msg) {
        ResultData resultData = new ResultData();
        resultData.put("msg", msg);
        return resultData;
    }

    public static ResultData ok(Map<String, Object> map) {
        ResultData resultData = new ResultData();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (map != null)
            list.add(map);
        resultData.put("result", list);
        return resultData;
    }

    public static ResultData ok(List<Map<String, Object>> list) {
        ResultData resultData = new ResultData();
        resultData.put("result", list);
        return resultData;
    }

    public static ResultData ok(Object obj) {
        ResultData resultData = new ResultData();
        resultData.put("result", obj);
        return resultData;
    }

}
