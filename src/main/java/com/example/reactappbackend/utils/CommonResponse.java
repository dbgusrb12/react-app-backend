package com.example.reactappbackend.utils;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommonResponse extends Response {
    private HashMap<String, Object> data;

    public CommonResponse() {
        super();
        data = new HashMap<>();
    }

    private CommonResponse(HashMap<String, Object> data) {
        this();
        this.data.putAll(data);
    }

    public CommonResponse data(HashMap<String, Object> data) {
        setData(data);
        return this;
    }

    public void addData(String key, Object value) {
        data.put(key, value);
    }

    public static CommonResponse of() {
        return new CommonResponse();
    }

    public static <T> CommonResponse of(T t) {
        if(t instanceof HashMap) {
            return new CommonResponse((HashMap<String, Object>) t);
        }
        if (t instanceof List) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("list", t);
            return CommonResponse.of(map);
        }

        CommonResponse commonResponse = new CommonResponse();

        if (Objects.isNull(t)) {
            return commonResponse;
        }
//        try {
//            commonResponse.getData().putAll(JsonUtil.objectToMap(t));
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw Error.of(ErrorSpec.ExecuteFailedError, ": 결과값을 Map 으로 변환 실패");
//        }
        return commonResponse;

    }
}
