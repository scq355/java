package com.coding.java.serialize.jdkserializer1;

import java.io.*;

/**
 * @author scq
 *
 * 序列化缘由：两个进程进行远程通信时，可以相互发送各种类型的数据，包括文本、图片、音频、视频等， 而这些数据都会以二进制序列的形式在网络上传送
 *
 * 序列化：对象转 -> 字节序列
 * 反序列化：字节序列 -> 对象
 *
 * 序列化的用途：
 * 1：实现了远程通信：在网络上传送对象的字节序列
 *
 * eg：当两个进程在进行远程通信时，彼此可以发送各种类型的数据。
 * 无论何种类型的数据都会以二进制序列的形式在网络上传送。
 * 发送方需要把这个Java对象转换为字节序列，才能在网络上传送；接收方则需要把字节序列再恢复为Java对象
 *
 * 2：实现了数据的持久化：把对象的字节序列永久地保存到硬盘上（通常存放在一个文件中）
 *
 * eg：很多应用需要对某些对象进行序列化，让它们离开内存空间，入住到物理硬盘以便长期保存。
 * 最常见的是Web服务器中的Session对象，当有 10万用户并发访问，就有可能出现10万个Session对象，内存可能吃不消，
 * 于是Web容器就会把一些seesion先序列化到硬盘中，等要用了再把保存在硬盘中的对象还原到内存中
 *
 *
 * JDK序列化API：
 *
 * 1：可对参数指定的obj对象进行序列化，把得到的字节序列写到一个目标输出流中
 * 对象输出流：java.io.ObjectOutputStream#writeObject(Object obj)
 *
 * 2：从一个源输入流中读取字节序列，再把它们反序列化为一个对象，并将其返回
 * 对象输入流：java.io.ObjectInputStream#readObject()
 *
 * 只有实现了Serializable和Externalizable接口的类的对象才能被序列化（Externalizable接口继承自 Serializable接口）
 * 实现Externalizable接口的类完全由自身来控制序列化的行为
 * 而仅实现Serializable接口的类可以 采用默认的序列化方式
 *
 * 对象序列化步骤：
 * 　　1） 创建一个对象输出流，它可以包装一个其他类型的目标输出流，如文件输出流；
 * 　　2） 通过对象输出流的writeObject()方法写对象。
 *
 * 对象反序列化步骤：
 * 　　1） 创建一个对象输入流，它可以包装一个其他类型的源输入流，如文件输入流；
 * 　　2） 通过对象输入流的readObject()方法读取对象。
 *
 *
 * 序列化注意点：
 * 父类没有实现序列化时，子类继承该父类并且实现了序列化。在反序列化该子类后，是没办法获取到父类的属性值的
 * 父类实现序列化，子类自动实现序列化，不需要显式实现Serializable接口
 * 一个对象的实例变量引用其他对象，序列化该对象时也把引用对象进行序列化，前提是该引用对象必须实现序列化接口（一个对象的成员变量是一个对象，那么这个对象的数据成员也会被保存！这是能用序列化解决深拷贝的重要原因）
 * 非所有的对象都可以序列化
 * static和transient类型的成员数据不能被序列化。因为static代表类的状态，transient代表对象的临时数据
 */
public class SerializeStart {

    public static void main(String[] args) {
        serializePerson();
        Person person = deserializePerson();
        assert person != null;
        System.out.println(person.toString());
    }


    private static void serializePerson() {
        Person person = new Person(12, "scq");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("/person.txt")))) {
            outputStream.writeObject(person);
            System.out.println("person 序列化成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person deserializePerson() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("/person.txt")))) {
            Person person = (Person) inputStream.readObject();
            System.out.println("person 反序列化成功");
            return person;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
