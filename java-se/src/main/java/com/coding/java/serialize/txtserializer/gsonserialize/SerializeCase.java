package com.coding.java.serialize.txtserializer.gsonserialize;

import com.coding.java.serialize.txtserializer.fastjsonserializer.User;
import com.google.gson.Gson;

/**
 * @author scq
 */
public class SerializeCase {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        User user = new User();
        user.setName("用户");
        user.setAge(27);
        user.setAddress("浙江省");

        String serialize = serialize(user);
        System.out.println(serialize);

        User user1 = (User) deserialize(serialize, User.class);
        System.out.println(user1);
    }


    public static String serialize(Object o) {
        return gson.toJson(o);
    }

    public static Object deserialize(String json, Class<?> clazz) {
        return gson.fromJson(json, clazz);
    }
}
