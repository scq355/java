package com.coding.java.serialize.byteserialize.kryoserialize;

import com.coding.java.serialize.txtserializer.fastjsonserializer.User;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/**
 * @author scq
 */
public class SerializeCase {

    private static Kryo kryo = new Kryo();


    public static void main(String[] args) {
        User user = new User();
        user.setName("用户");
        user.setAge(27);
        user.setAddress("浙江省");

        byte[] serizlize = serialize(user);
        System.out.println(serizlize);

        User user1 = (User) deserizlize(serizlize);
        System.out.println(user1);
    }


    public static byte[] serialize(Object o) {
        byte[] buffer = new byte[2048];
        Output output = new Output(buffer);

        kryo.writeClassAndObject(output, o);

        byte[] bytes = output.toBytes();
        output.close();
        return bytes;
    }

    public static Object deserizlize(byte[] bytes) {
        Input input = new Input(bytes);
        Object o = kryo.readClassAndObject(input);
        input.close();
        return o;
    }
}
