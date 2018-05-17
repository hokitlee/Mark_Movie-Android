package com.example.lib;

public class MyClass {
    public static void main(String[] args) {
        A a = new A(1,2,3);
        B b = new B();
        Gson gson = new Gson();
        String json = gson.toJson(a);
        System.out.println(json);
        gson.fromJson(json,A.class);
        System.out.println("!!!");
    }
}
