package com.coding.java.serialize.jdkserializer2;

import java.io.*;

/**
 * @author scq
 */
public class JavaSerializer implements ISerializer {
    @Override
    public <T> byte[] serializer(T obj) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            outputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T deSerializer(byte[] data, Class<T> clazz) {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
             ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream)) {

            return (T) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
