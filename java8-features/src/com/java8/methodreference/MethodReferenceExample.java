package com.java8.methodreference;

import java.util.function.Function;

public class MethodReferenceExample {

    public static Function<String, String> toUpperCase = (name) -> name.toUpperCase();
    public static Function<String, String> toUpperCase2 = String::toUpperCase; // method reference
    
    public static void main(String[] args) {
        System.out.println(toUpperCase.apply("Amir"));
        System.out.println(toUpperCase2.apply("Amir"));

    }
}
