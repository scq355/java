package com.coding.java.serialize.byteserialize.jdkserializer2;

import java.io.*;

/**
 * @author scq
 */
public class Person implements Cloneable, Serializable {
    private String name;
    private Email email;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email=" + email +
                '}';
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    /**
     * 深克隆：把对象序列化输出到一个流中，然后在把对象从序列化流中读取出来，这个对象就不是原来的对象了
     * @return Person
     */
    public Person deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
        return (Person) inputStream.readObject();
    }
}
