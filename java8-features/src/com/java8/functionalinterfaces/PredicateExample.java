package com.java8.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Integer> p1 = (i) -> (i%2 == 0);
    static Predicate<Integer> p2 = (i) -> (i%5 == 0);

    public static void predicateAnd(int i) {
        System.out.println("is "+i+ " divisible by 2 and 5 : "+p1.and(p2).test(i));
    }
    
    public static void predicateOr(int i) {
        System.out.println("is "+i+ " divisible by 2 or 5 : "+ p1.or(p2).test(i));
    }
    
    public static void predicateNegate(int i) {
        System.out.println("Negate: Is "+i+" even ? "+p1.negate().test(i));
    }
    
    public static void main(String[] args) {
        System.out.println("Is 11 even ? "+p1.test(11));
        predicateNegate(11);
        System.out.println("Is 12 even ? "+p1.test(12));
        predicateNegate(12);
        
        predicateAnd(10);
        predicateAnd(4);
        
        predicateOr(10);
        predicateOr(3);
        
    }

}
