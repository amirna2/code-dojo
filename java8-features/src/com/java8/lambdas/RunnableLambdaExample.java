package com.java8.lambdas;

public class RunnableLambdaExample {

    public static void main(String[] args) {

        // Before Java 8
        
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable: before Java 8");
            }
        };
        
        // Java 8 lambdas
        
        // () -> {}
        Runnable runnableLambdaV1 = () -> {
            System.out.println("Inside Runnable: java 8 lambda v1 ");
        };
        
        new Thread(runnable).start();
        new Thread(runnableLambdaV1).start();

        // Runnable lambda expression embedded as method argument to the Thread constructor
        // Note that the runnable has a single statement which makes the {} optional
        new Thread  (() -> System.out.println("Inside Runnable: java 8 lambda v2 ")).start();
    }

}
