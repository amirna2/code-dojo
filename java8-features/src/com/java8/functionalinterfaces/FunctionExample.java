package com.java8.functionalinterfaces;

import java.util.function.Function;

public class FunctionExample {

    // the Function takes a String input and returns a String
    public static Function<String, String> toUpperCase = (name) -> name.toUpperCase();
    // the Function takes a String input and the string appended to the word "Hello"

    public static Function<String, String> appendToHello = (name) -> "Hello ".concat(name);
    
    public static void main(String[] args) {
        
        // returns upper cased string
        System.out.println(toUpperCase.apply("Hello World"));
        // returns upper cased name then appends it to the word "Hello": "Amir" -> Hello AMIR  
        System.out.println(toUpperCase.andThen(appendToHello).apply("Amir"));
        // Appends the name to "Hello" first, then performs upper case of the result: "Hello Amir" -> "HELLO AMIR"
        System.out.println(toUpperCase.compose(appendToHello).apply("Amir"));

    }

}
