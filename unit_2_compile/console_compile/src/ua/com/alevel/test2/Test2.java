package ua.com.alevel.test2;

import org.apache.commons.lang3.*;
import org.apache.commons.collections4.*;
import java.util.Arrays;
import java.util.List;


public class Test2 {
    public void hello() {
        System.out.println(StringUtils.upperCase("console_compile:hello from class Test2"));

    }

    public void intersection() {
        System.out.println("intersection of 2 lists:");
        List<String> list1 = Arrays.asList("A", "A", "A", "C", "B", "B");
        List<String> list2 = Arrays.asList("D", "C", "B", "B");
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("Commons Objects of List 1 and List 2:" + CollectionUtils.intersection(list1, list2));
    }
}