package com.java8.functionalinterfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class PredicateStudentExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3.0;
    static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

    static BiConsumer<String, List<String>> bc1 = (name, activities) -> System.out.println("name: "+name+ " activities: "+ activities);
    static BiPredicate<Integer, Double> bp1 = (grade, gpa) -> (grade >= 3 && gpa >=3.9);
    
    static Consumer<Student> c1 = (s) -> {
        if (p1.test(s)) {
            System.out.println(s);
        }
    };
    
    // combining consumer and predicate
    static Consumer<Student> c2 = (s) -> {
        if (p1.and(p2).test(s)) {
            System.out.println(s);
        }
    };

    // combining consumer and 2 predicates
    static Consumer<Student> c3 = (s) -> {
        if (p1.and(p2).test(s)) {
            bc1.accept(s.getName(), s.getActivities());
        }
    };
    
    // combining consumer with the bi predicate
    static Consumer<Student> c4 = (s) -> {
        if (bp1.test(s.getGradeLevel(), s.getGpa())) {
            bc1.accept(s.getName(), s.getActivities());
        }
    };
    
    static void filterStudentByGradeLevel() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach( s -> {
            if (p1.and(p2).test(s)) {
                System.out.println(s);
            }
        });
    }
    
    static void filterByGradeAndGpa() {
        List<Student> students = StudentDataBase.getAllStudents();
        //students.forEach( s -> c2.accept(s));
        students.forEach(c2);

    }
    
    static void showByNameAndActivities() {
        List<Student> students = StudentDataBase.getAllStudents();
        //students.forEach(s -> c3.accept(s));
        students.forEach(c3);

    }
    static void showByNameAndActivitiesWithBiPredicate() {
        List<Student> students = StudentDataBase.getAllStudents();
        //students.forEach(s -> c3.accept(s));
        students.forEach(c4);

    }
    
    public static void main(String[] args) {
        System.out.println("==== filterStudentByGradeLevel: ===========================");
        filterStudentByGradeLevel();
        System.out.println("==== filterByGradeAndGpa: =================================");
        filterByGradeAndGpa();
        System.out.println("==== showByNameAndActivities: =============================");
        showByNameAndActivities();
        System.out.println("==== showByNameAndActivitiesWithBiPredicate: ==============");
        showByNameAndActivitiesWithBiPredicate();
    }

}
