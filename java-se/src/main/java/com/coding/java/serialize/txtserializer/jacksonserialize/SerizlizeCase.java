package com.coding.java.serialize.txtserializer.jacksonserialize;

import com.coding.java.serialize.txtserializer.fastjsonserializer.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author scq
 */
public class SerizlizeCase {

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

    private static ObjectMapper mapper = new ObjectMapper();
    public static String serialize(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object deserialize(String json, Class<?> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
