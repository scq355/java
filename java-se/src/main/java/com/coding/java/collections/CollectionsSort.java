package com.coding.java.collections;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionsSort {

    @Test
    public void test() {
        List<Staff> staffs = Arrays.asList(
                new Staff("小明", 18, new BigDecimal(2000)),
                new Staff("小明1", 33, new BigDecimal(22020)),
                new Staff("小明2", 44, new BigDecimal(2800)),
                new Staff("小明3", 23, new BigDecimal(2700)),
                new Staff("小明4", 21, new BigDecimal(2600)),
                new Staff("小明5", 10, new BigDecimal(2000)),
                new Staff("小明6", 56, new BigDecimal(21000)),
                new Staff("小明7", 49, new BigDecimal(12000))
        );

        List<Integer> list=Arrays.asList(3,41,23,65,12,77,33, 1,4);

        Collections.sort(list);
        System.out.println(list.toString());
        Collections.reverse(list);
        System.out.println(list.toString());
        Collections.shuffle(list);
        System.out.println(list.toString());

        List<Integer> collect = staffs.stream().map(Staff::getAge).collect(Collectors.toList());
        System.out.println("年龄集合"+collect);

        List<BigDecimal> collect2 = staffs.stream().map(Staff::getSalary).collect(Collectors.toList());
        System.err.println("工资集合"+collect2);


        staffs.sort(new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println("对象集合按年龄排序"+staffs);
        Collections.sort(collect);
        System.out.println("年龄排序"+collect);
    }

    @Test
    public void test1() {
        Staff staff = new Staff("小明", 18, new BigDecimal(2000));
        Staff staff1 = new Staff("小明1", 33, new BigDecimal(22020));
        Staff staff2 = new Staff("小明2", 44, new BigDecimal(2800));
        Staff staff3 = new Staff("小明3", 23, new BigDecimal(2700));
        Staff staff4 = new Staff("小明4", 21, new BigDecimal(2600));
        Staff staff5 = new Staff("小明5", 10, new BigDecimal(2000));
        Staff staff6 = new Staff("小明6", 56, new BigDecimal(21000));
        Staff staff7 = new Staff("小明7", 49, new BigDecimal(12000));

    }
}
