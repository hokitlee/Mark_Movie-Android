package com.limitip.mm.mark_movie.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.limitip.mm.mark_movie.pojo.Subjects;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;

/**
 * Created by hokitlee on 2018/5/3.
 */

public class test {
    public static void main(String[] args) throws JSONException {

//        String str = "1,2,3,4";
//        Gson gson = new Gson();
//        A a = new A(1,2);
//        Subjects subjects = new Subjects();
//        subjects.setId(1);
//        subjects.setToken("2");
        Gson gson2 = new GsonBuilder().enableComplexMapKeySerialization().create();
//        Map<String, Object> map = new HashMap<>();
//        map.put("subjects", subjects);
//        map.put("str", str);
//        map.put("a",a);
//        System.out.println(gson2.toJson(map));
//        String route= gson.toJson(a);
//        System.out.println(route);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        Map<String,Object> mm = new HashMap<>();
        mm.put("1",arrayList);
        String aa = gson2.toJson(mm.get("1"));
        System.out.println("aa = " + aa);
        Type type = new TypeToken<ArrayList>() {
        }.getType();
        ArrayList qwe = gson2.fromJson(aa,type);
        System.out.println(qwe.get(0));
    }
}