package com.java8.lambdas;

import java.util.Comparator;

public class ComparableLambdaExample {

    public static void main(String[] args) {

        // Before Java 8
        
        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // -1 o1 < o2
                // +1 o1 > o2
                //  0 o1 == o2 
                return o1.compareTo(o2);
            }  
        };
        
        System.out.println("Before Java 8: Comparing 10 to 12: "+ comparator.compare(10, 12));
        
        // Java 8 lambdas
        Comparator<Integer> comparatorLambda1 = (Integer o1, Integer o2) -> o1.compareTo(o2);
        Comparator<Integer> comparatorLambda2 = (o1, o2) -> o1.compareTo(o2);

        System.out.println("Java 8 Lambda: Comparing 10 to 12: "+ comparatorLambda1.compare(10, 12));
        System.out.println("Java 8 Lambda: Comparing 10 to 12: "+ comparatorLambda2.compare(10, 12));

        
    }

}
