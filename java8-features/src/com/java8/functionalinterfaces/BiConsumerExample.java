package com.java8.functionalinterfaces;

import java.util.List;
import java.util.function.BiConsumer;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class BiConsumerExample {

    public static void nameAndActivities() {
        BiConsumer<String, List<String>> biConsumer = (name, activities) -> {
            System.out.println("name: "+name+ " activities: "+activities);
        };
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach((s -> biConsumer.accept(s.getName(), s.getActivities())));  
    }
    
    public static void main(String[] args) {

        BiConsumer<String, String>  biConsumer = (a,b) -> {
            System.out.println("a: "+a+" b: "+b);
        };
        
        biConsumer.accept("Hello", "World");
        
        BiConsumer<Integer, Integer> multiply = (a,b) -> {
            System.out.println("multiply: "+(a*b));
        };
        
        BiConsumer<Integer, Integer> divide = (a,b) -> {
            System.out.println("divide: "+(a/b));
        };
        
        multiply.andThen(divide).accept(120, 3);
        
        nameAndActivities();
    }

}
