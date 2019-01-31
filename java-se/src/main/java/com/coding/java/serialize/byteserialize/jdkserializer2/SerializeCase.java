package com.coding.java.serialize.byteserialize.jdkserializer2;

import java.io.*;

/**
 * @author scq
 */
public class SerializeCase {

    public static void main(String[] args) {
        ISerializer serializer = new JavaSerializer();
        User user = new User();
        user.setName("用户");
        user.setAge(27);
        user.setSex("男");
        user.setAddress("浙江省");
        byte[] bytes = serializer.serializer(user);

        // 序列化时，并不保存静态变量，这其实比较容易理解，序列化保存的是对象的状态，静态变量属于类的状态，因此序列化并不保存静态变量
        User.num = 10;

        User result = serializer.deSerializer(bytes, User.class);
        System.out.println(result);
        // 类没有实现序列化时，子类继承该父类并且实现了序列化。在反序列化该子类后，是没办法获取到父类的属性值的
        System.out.println(result.getSex());
        // address 为transient类型，不参与序列化
        System.out.println(result.getAddress());
        System.out.println(User.num);

        // 绕开transient机制
        UserTwo userTwo = new UserTwo();
        userTwo.setName("用户");
        userTwo.setAge(27);
        userTwo.setSex("男");
        userTwo.setAddress("浙江省");
        // ObjectOutputStream使用了反射来寻找是否声明了这两个方法
        bytes = serializer.serializer(userTwo);
        UserTwo userTwo1 = serializer.deSerializer(bytes, UserTwo.class);
        System.out.println(userTwo1 + "  :  " + userTwo1.getAddress());


        /**
         * 同一对象两次写入文件，打印出写入一次对象后的存储大小和写入两次后的存储大小，第二次写入对象时文件只增加了5个字节。
         * 这是因为，Java 序列化机制为了节省磁盘空间，具有特定的存储规则，当写入文件为同一对象时，并不会再将对象的内容进行存储，
         * 而只是再次存储一份引用，上面增加的5个字节的存储空间就是新增引用和一些控制信息的空间。反序列化时，恢复引用关系，该存储规则极大的节省了存储空间。
         */
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("user")))){
            User users=new User();
            users.setName("taofut");
            users.setAge(27);
            users.setSex("男");
            outputStream.flush();
            outputStream.writeObject(users);
            System.out.println(new File("user").length());
            outputStream.writeObject(users);
            System.out.println(new File("user").length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
