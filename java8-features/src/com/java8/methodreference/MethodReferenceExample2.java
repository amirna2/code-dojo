package com.java8.methodreference;

import java.util.function.Predicate;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class MethodReferenceExample2 {

    public static boolean greaterThanGradeLevel(Student s) {
        return s.getGradeLevel() >= 3.0;
    }
    static Predicate<Student> p1 = MethodReferenceExample2::greaterThanGradeLevel;

    
    public static void main(String[] args) {
        System.out.println(p1.test(StudentDataBase.studentSupplier.get()));

    }
}
