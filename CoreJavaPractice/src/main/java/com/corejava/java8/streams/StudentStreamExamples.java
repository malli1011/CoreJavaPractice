package com.corejava.java8.streams;

import com.corejava.java8.streams.model.Address;
import com.corejava.java8.streams.model.MobileNumber;
import com.corejava.java8.streams.model.Student;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentStreamExamples {

    public static List<Student> students;

    static {
        Student student1 = new Student(
                "Jayesh",
                20,
                new Address("1234"),
                List.of(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student(
                "Khyati",
                18,
                new Address("1235"),
                List.of(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student(
                "Jason",
                20,
                new Address("1235"),
                List.of(new MobileNumber("3333"), new MobileNumber("4444")));

        students = List.of(student1, student2, student3);
    }


    // Get student with exact match name "jayesh"
    public static void getStudentByName(String name) {
        students.stream().filter(student -> student.getName().equalsIgnoreCase(name)).forEach(System.out::println);
    }

    public static void getStudentByAddress(Address addr) {
        students.stream().filter(student -> student.getAddress().getZipcode().equals(addr.getZipcode())).forEach(System.out::println);
    }

    public static void getStudentByMobileNum(MobileNumber mobileNumber) {
        Predicate<Student> studentPredicate = stu -> {
            Predicate<MobileNumber> mobileNumberPredicate = num -> mobileNumber.getNumber().equalsIgnoreCase(num.getNumber());
            return stu.getMobileNumbers().stream().anyMatch(mobileNumberPredicate);
        };
        students.stream()
                .filter(studentPredicate)
                .forEach(System.out::println);
    }

    // Get all student having mobile number 1233 and 1234
    public static void getAllStudentsBuMobileNum(String m1, String m2) {
        Predicate<Student> mobileNumPredicate = student -> {
            Predicate<MobileNumber> mobileNumberPredicate = num -> num.getNumber().equals(m1) || num.getNumber().equals(m2);
            return student.getMobileNumbers().stream().allMatch(mobileNumberPredicate);
        };
        students.stream()
                .filter(mobileNumPredicate)
                .forEach(System.out::println);
    }

    //Gel All mobile numbers from all the students.
    public static void getAllStudentsMobileNumbers() {
        students.stream()
                .flatMap(student -> student.getMobileNumbers().stream())
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
}
