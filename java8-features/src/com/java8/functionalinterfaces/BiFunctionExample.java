package com.java8.functionalinterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class BiFunctionExample {

    public static BiFunction<String, String, String> append = (s1, s2) -> s1.concat(s2);
    
    public static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> studentFilter = ((students, predicate) -> {
        Map<String, Double> studentGpa = new HashMap<>();
        
        students.forEach(student ->{
            if (predicate.test(student)) {
                studentGpa.put(student.getName(), student.getGpa());
            }
        });
        return studentGpa;
    });
    public static void main(String[] args) {
        System.out.println(append.apply("Hello", "World"));
        System.out.println(studentFilter.apply(StudentDataBase.getAllStudents(), PredicateStudentExample.p1));
    }

}
