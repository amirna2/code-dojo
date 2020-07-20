package com.java8.functionalinterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class FunctionStudentExample {

    public static Function<List<Student>, Map<String, Double>> functionGpa = (students -> {
        Map<String, Double> studentGpa = new HashMap<>();
        
        students.forEach(student ->{
            if (PredicateStudentExample.p1.test(student)) {
                studentGpa.put(student.getName(), student.getGpa());
            }
        });
        return studentGpa;
    });
    
    public static void main(String[] args) { 
        System.out.println(functionGpa.apply(StudentDataBase.getAllStudents()));
    }
}




