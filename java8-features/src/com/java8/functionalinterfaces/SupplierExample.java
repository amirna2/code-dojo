package com.java8.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class SupplierExample {
    
    static Supplier<Student> sup1 = () -> { 
        return new Student("Adam",2,3.6, "male",Arrays.asList("swimming", "basketball","volleyball"));
        };
    static Supplier<List<Student>> sup2 = () -> { 
            return StudentDataBase.getAllStudents();
        };
    public static void main(String[] args) {
        System.out.println(sup1.get());
        System.out.println(sup2.get());

    }
    
}
