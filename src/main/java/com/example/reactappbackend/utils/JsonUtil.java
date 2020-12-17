package com.example.reactappbackend.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;



public class JsonUtil  {
    private static ObjectMapper objectMapper = new ObjectMapper();


    public static Map objectToMap(Object object) {
        return objectMapper.convertValue(object, Map.class);
    }

}
