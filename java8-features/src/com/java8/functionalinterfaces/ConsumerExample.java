package com.java8.functionalinterfaces;

import java.util.List;
import java.util.function.Consumer;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class ConsumerExample {

    static Consumer<Student> c1 = (s -> System.out.println(s));
    static Consumer<Student> c2 = (s -> System.out.print(s.getName()));
    static Consumer<Student> c3 = (s -> System.out.println("\t==>\t" +s.getActivities()));
    
    public static void printName() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(s -> System.out.println(s));
    }
    
    public static void printNameWithConsumer() {
        List<Student> students = StudentDataBase.getAllStudents();
        // the forEach implementation will invoke the accept method in an enhanced loop
        students.forEach(c1);
    }
   
    public static void printNameAndActivities() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach( s -> {
             System.out.print(s.getName());
             System.out.println("\t==>\t"+s.getActivities());
        });
    }
    
    public static void printNameAndActivitiesWithConsumer() {    
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach( c2.andThen(c3) );
    }
    
    public static void printNameAndActivitiesWithConsumerCondition() {    
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach( s -> {
            if (s.getGradeLevel() >= 3) {
                c2.andThen(c3).accept(s);
            }
        } );
    }
    
    public static void main(String[] args) {

        // Functional Interfaces in Java 8 have only a single abstract method
        // Consumer is a functional interface that accept() an object and transforms/consumes it
        System.out.println(">>>>>>>>>>>>>>>>>>> Consumer accept()" );
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        c1.accept("Hello World");
        System.out.println("\n>>>>>>>>>>>>>>>>>>> printName()\n" );
        printName();
        System.out.println("\n>>>>>>>>>>>>>>>>>>> printNameWithConsumer()\n" );
        printNameWithConsumer();
        System.out.print("\n>>>>>>>>>>>>>>>>>>> printNameAndActivities()\n" );
        printNameAndActivities();
        System.out.print("\n>>>>>>>>>>>>>>>>>>> printNameAndActivitiesWithConsumer()\n" );
        printNameAndActivitiesWithConsumer();
        System.out.print("\n>>>>>>>>>>>>>>>>>>> printNameAndActivitiesWithConsumerCondition()\n" );
        printNameAndActivitiesWithConsumerCondition();
    }

}
