package com.java8.lambdas;

import java.util.function.Consumer;

public class LambdaVariable2 {

        static int v = 4;
        
    public static void main(String[] args) {
        int value = 4;
        
        Consumer<Integer> c1 = (i) -> {
            //value +=1; not allowed because value is "effectively" final inside the lambda
            v++; // allowed because this is an instance variable
            System.out.println(value);
        };
        c1.accept(4);
    }

}
