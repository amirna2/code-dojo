package com.java8.functionalinterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    
    public static UnaryOperator<String> uop1 = (s) -> s.concat(" World");
    public static void main(String[] args) {
        
        System.out.println(uop1.apply("Hello"));
    }
    
}
