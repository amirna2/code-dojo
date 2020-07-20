package com.java8.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class StreamsExample {

    public static void main(String[] args) {
        
        Predicate<Student> gradeLevel = (student -> student.getGradeLevel()>=3);
        Predicate<Student> gpaLevel = (student -> student.getGradeLevel()>=3.9);

        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
        .collect(Collectors.toMap(Student::getName, Student::getActivities));
        
        // filtered stream
        Map<String, List<String>> studentMap2 = StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGradeLevel()>=3)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        
        // filtered stream by predicate
        Map<String, List<String>> studentMap3 = StudentDataBase.getAllStudents().stream()
                .filter(gradeLevel)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        
        Map<String, List<String>> studentMap4 = StudentDataBase.getAllStudents().stream()
                .filter(gradeLevel)
                .filter(gpaLevel)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        
        // parallel stream
        Map<String, List<String>> studentMap5 = StudentDataBase.getAllStudents().parallelStream()
                .filter(gradeLevel)
                .filter(gpaLevel)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        
        
        // stream (with peek)
        Map<String, List<String>> studentMap6 = StudentDataBase.getAllStudents().stream()
                .peek((student -> System.out.println("BEFORE FILTER:"+student)))
                .filter(gradeLevel)
                .peek((student -> System.out.println("after 1st filter:"+student)))
                .filter(gpaLevel)
                .peek((student -> System.out.println("after 2nd filter:"+student)))

                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        
        System.out.println("-------------------------");
        System.out.println(studentMap);
        System.out.println("-------------------------");
        System.out.println(studentMap2);
        System.out.println("-------------------------");
        System.out.println(studentMap3);
        System.out.println("-------------------------");
        System.out.println(studentMap4);
        System.out.println("-------------------------");
        System.out.println(studentMap5);
        System.out.println("-------------------------");
        System.out.println(studentMap6);
        



    }

}
