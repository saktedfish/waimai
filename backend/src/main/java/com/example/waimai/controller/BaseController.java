package com.example.waimai.controller;

import com.google.gson.Gson;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//import com.alibaba.fastjson.JSONObject;

public class BaseController {
    public String defaultFilePath = "/usr/local/workspace/files/fishing/files/";

    public String defaultNetFilePath = "http://39.99.52.162:8080/fishing/files/";

    public String makeToken() {
        String token = (System.currentTimeMillis() + (new Random()).nextInt(999999999)) + "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] md5 = md.digest(token.getBytes());
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String returnJSONObjectString(JSONObject json, String key) {
        String value = "";
        if (json.has(key))
            try {
                value = json.getString(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return value;
    }

    public JSONArray returnJSONObjectJSONArray(JSONObject json, String key) {
        JSONArray value = new JSONArray();
        if (json.has(key))
            try {
                value = json.getJSONArray(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return value;
    }

    public int returnJSONObjectInt(JSONObject json, String key) {
        int value = -1;
        if (json.has(key))
            try {
                value = json.getInt(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return value;
    }

    public String replaceNull(String s) {
        if (StringUtils.isNotEmpty(s)) {
            if (s.contains("null"))
                s = s.replace("null", "");
        } else {
            s = "";
        }
        return s;
    }

    public <T> String objectToJSONString(T o) {
        Gson gson = new Gson();
        String json = gson.toJson(o);
        return json;
    }

    public <T> String listToJSONString(List<T> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    public String mapToJSONString(HashMap<Object, Object> map) {
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return json;
    }

    public String listMapToJSONString(List<HashMap<Object, Object>> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    public <T> T jsonToObject(String jsonString, Class<T> c) {
        Gson gson = new Gson();
        T t = (T)gson.fromJson(jsonString, c);
        return t;
    }

//    public <T> List<T> jsonToList(String jsonString) {
//        List<T> list = new ArrayList<>();
//        Gson gson = new Gson();
//        list = (List<T>)gson.fromJson(jsonString, (new Object(this)).getType());
//        return list;
//    }
//
//    public <T> Map<Object, T> jsonToMap(String jsonString) {
//        Map<Object, T> map = new HashMap<>();
//        Gson gson = new Gson();
//        map = (Map<Object, T>)gson.fromJson(jsonString, (new Object(this)).getType());
//        return map;
//    }
//
//    public <T> List<Map<Object, T>> jsonToListMap(String jsonString) {
//        List<Map<Object, T>> list = new ArrayList<>();
//        Gson gson = new Gson();
//        list = (List<Map<Object, T>>)gson.fromJson(jsonString, (new Object(this)).getType());
//        return list;
//    }
}
