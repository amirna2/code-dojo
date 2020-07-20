package com.java8.functionalinterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    
    static Comparator<Integer> comp = (a,b) -> a.compareTo(b);
    
    static BinaryOperator<Integer> bop1 = (a,b) -> a * b;
    static BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comp);
    static BinaryOperator<Integer> minBy = BinaryOperator.minBy(comp);

    public static void main(String[] args) {
        
        System.out.println(maxBy.apply(2, 12));
        System.out.println(minBy.apply(2, 12));

        System.out.println(bop1.apply(2, 12));
    }
    
}
