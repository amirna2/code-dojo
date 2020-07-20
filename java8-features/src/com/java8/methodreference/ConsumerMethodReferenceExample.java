package com.java8.methodreference;

import java.util.function.Consumer;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class ConsumerMethodReferenceExample {

    static Consumer<Student> c1 = (s -> System.out.println(s));
    static Consumer<Student> c2 = Student::printListOfActivities;
    public static void main(String[] args) {
        StudentDataBase.getAllStudents().forEach(c1);
        StudentDataBase.getAllStudents().forEach(c2);
    }
}
