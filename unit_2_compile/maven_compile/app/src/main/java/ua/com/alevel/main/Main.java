package ua.com.alevel.main;

import ua.com.alevel.test1.Test1;
import ua.com.alevel.test2.Test2;
import org.apache.commons.lang3.*;
import org.apache.commons.collections4.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\tMAVEN_COMPILE");
        new Test1().hello();
        new Test2().hello();
        new Test2().intersection();
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

}