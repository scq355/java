package com.coding.java.serialize.byteserialize.jdkserializer2;

import java.io.IOException;

/**
 *
 * 深克隆：
 * 被复制对象的所有变量都含有与原来的对象相同的值，除去那些引用其他对象的变量。
 * 那些引用其他对象的变量将指向被复制过的新对象，而不再是原有的那些被引用的对象。换言之，深拷贝把要复制的对象所引用的对象都复制了一遍。
 *
 * @author scq
 */
public class CloneCase {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Email email = new Email();
        email.setContent("今天晚上6点半开会");
        Person person = new Person("人民");
        person.setEmail(email);

        System.out.println("浅克隆");
        /**
         * 浅克隆：被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象
         */
        Person person1 = person.clone();
        person1.setName("007");
        person1.getEmail().setContent("今天晚上7点半开会");
        /**
         * 浅克隆不能复制新的引用，Email引用还是指向的同一个对象
         */
        System.out.println(person.getName() + "->" + person.getEmail().getContent());
        System.out.println(person1.getName() + "->" + person1.getEmail().getContent());


        System.out.println("深克隆");
        Person person2 = person.deepClone();
        person2.setName("9527");
        person2.getEmail().setContent("今天晚上8点半开会");
        System.out.println(person.getName() + "->" + person.getEmail().getContent());
        System.out.println(person1.getName() + "->" + person2.getEmail().getContent());
    }
}
