package com.corejava.java8.streams;

import com.corejava.java8.streams.model.Address;
import com.corejava.java8.streams.model.MobileNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentStreamExamplesTest {

    @Test
    void getStudentByNameTest() {
        StudentStreamExamples.getStudentByName("jayesh");
    }

    @Test
    void getStudentByAddressTest() {
        StudentStreamExamples.getStudentByAddress(new Address("1234"));
    }

    @Test
    void getStudentByMobileNumTest() {
        StudentStreamExamples.getStudentByMobileNum(new MobileNumber("1234"));
    }

    @Test
    void getAllStudentsBuMobileNumTest() {
        StudentStreamExamples.getAllStudentsBuMobileNum("1233", "1234");
    }
}