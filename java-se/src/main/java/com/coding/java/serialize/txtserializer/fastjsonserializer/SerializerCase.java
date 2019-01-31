package com.coding.java.serialize.txtserializer.fastjsonserializer;

import com.alibaba.fastjson.JSON;

/**
 * @author scq
 */
public class SerializerCase {

    public static void main(String[] args) {
        User user = new User();
        user.setName("用户");
        user.setAge(27);
        user.setAddress("浙江省");

        String serizlize = serizlize(user);
        System.out.println(serizlize);

        User user1 = (User) deserialize(serizlize, User.class);
        System.out.println(user1);
    }


    public static String serizlize(Object object) {
        return JSON.toJSONString(object);
    }

    public static Object deserialize(String json, Class<?> clazz) {
        return JSON.parseObject(json, clazz);
    }
}
