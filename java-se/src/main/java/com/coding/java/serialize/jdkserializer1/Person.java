package com.coding.java.serialize.jdkserializer1;

import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author scq
 */
@Accessors(chain = true)
public class Person implements Serializable {
    /**
     * 没有指定serialVersionUID，java编译器会自动给class进行一个摘要算法（类似于指纹算法）
     * 只要这个文件多一个空格，得到的UID就会截然不同的，可以保证在这么多类中，这个编号是唯一的
     *
     * serialVersionUID的取值是Java运行时环境根据类名、接口名、成员方法及属性等来生成一个64位的哈希字段
     * 如果对类的源代码作了修改，再重新编译，新生成的类文件的serialVersionUID的取值有可能也会发生变化
     *
     * serialVersionUID的默认值完全依赖于Java编译器的实现，
     * 对于同一个类，用不同的Java编译器编译，有可能会导致不同的 serialVersionUID，也有可能相同。
     * 为了提高serialVersionUID的独立性和确定性，强烈建议在一个可序列化类中显示的定义serialVersionUID，为它赋予明确的值
     *
     *
     * 显式地定义serialVersionUID的两种用途：
     *  1、 希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有相同的serialVersionUID；
     *  2、 不希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有不同的serialVersionUID。
     */
    private static final long serialVersionUID = -5809782578272943999L;

    private int age;
    private String name;
    private String sex;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
