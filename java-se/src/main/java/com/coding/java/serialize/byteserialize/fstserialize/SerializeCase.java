package com.coding.java.serialize.byteserialize.fstserialize;

import org.nustaq.serialization.FSTConfiguration;

/**
 * @author scq
 */
public class SerializeCase {
    private static FSTConfiguration configuration = FSTConfiguration.createDefaultConfiguration();

    public static void main(String[] args) {
        User user = new User();
        user.setName("用户");
        user.setAge(27);
        user.setAddress("浙江省");

        byte[] serialize = serialize(user);
        System.out.println(serialize);

        User deserialize = (User) deserialize(serialize);
        System.out.println(deserialize);
    }


    public static byte[] serialize(Object o) {
        return configuration.asByteArray(o);
    }

    public static Object deserialize(byte[] ser) {
        return configuration.asObject(ser);
    }
}
