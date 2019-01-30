package com.coding.java.serialize.jdkserializer2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UserTwo extends SuperUser implements Serializable {
    private String name;
    private int age;
    public static int num=5;

    private transient String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        UserTwo.num = num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserTwo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    /**
     * 序列化
     * @param outputStream
     */
    private void writeObject(ObjectOutputStream outputStream) {
        try {
            outputStream.defaultWriteObject();
            outputStream.writeObject(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化
     * @param inputStream
     */
    private void readObject(ObjectInputStream inputStream) {
        try {
            inputStream.defaultReadObject();
            address = (String) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
