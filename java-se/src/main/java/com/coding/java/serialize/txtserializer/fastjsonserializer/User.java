package com.coding.java.serialize.txtserializer.fastjsonserializer;

/**
 * @author scq
 */
public class User {
    private String name;
    private int age;
    /**
     * 静态变量
     */
    public static int num = 5;

    /**
     * Transient关键字的作用是控制变量的序列化，在变量声明前加上该关键字，可以阻止该变量被序列化到文件中，在被反序列化后，
     * transient变量的值被设为初始值，如 int型的是0，对象型的是null。
     */
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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }



}
