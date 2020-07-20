package com.java8.lambdas;

import java.util.function.Consumer;

public class LambdaVariable1 {

    public static void main(String[] args) {
        int i = 0;
        
        Consumer<Integer> c1 = (i2) -> {
            
            System.out.println("value is "+ i);
        };
    }

}
