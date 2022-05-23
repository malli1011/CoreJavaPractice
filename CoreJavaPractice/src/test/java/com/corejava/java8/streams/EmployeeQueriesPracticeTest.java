package com.corejava.java8.streams;

import com.corejava.java8.streams.model.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

class EmployeeQueriesPracticeTest {

    private static final List<Employee> employeeList = Employee_Queries.employeeList;

    @Test
    void countOfMaleAndFemaleTest() {
        EmployeeQueriesPractice.countOfMaleAndFemale(employeeList);
    }

    @Test
    void printAllDepartmentsTest() {
        EmployeeQueriesPractice.printAllDepartments(employeeList);
    }

    @Test
    void avgAgeByGenderTest() {
        EmployeeQueriesPractice.avgAgeByGender(employeeList);
    }

    @Test
    void highestPaidEmployeeTest() {
        EmployeeQueriesPractice.highestPaidEmployee(employeeList);
    }

    @Test
    void employeesJoinedAfter2015Test() {
        EmployeeQueriesPractice.employeesJoinedAfter2015(employeeList);
    }

    @Test
    void avgSalaryByDeptTest() {
        EmployeeQueriesPractice.avgSalaryByDept(employeeList);
    }

    @Test
    void youngestMaleEmpInProductDept() {
        EmployeeQueriesPractice.youngestMaleEmpInProductDept(employeeList);
    }

    @Test
    void mostWorkExperienceInOrgTest() {
        EmployeeQueriesPractice.mostWorkExperienceInOrg(employeeList);
    }

    @Test
    void avgAndTotalSalaryOfOrgTest() {
        EmployeeQueriesPractice.avgAndTotalSalaryOfOrg(employeeList);
    }

    @Test
    void separateEmployeesAboveAndBelow25Test() {
        EmployeeQueriesPractice.separateEmployeesAboveAndBelow25(employeeList);
    }

    @Test
    void getOldestEmployeeTest() {
        EmployeeQueriesPractice.getOldestEmployee(employeeList);
    }

    @Test
    void getHighestPaidEmployeeByDeptTest() {
        EmployeeQueriesPractice.getHighestPaidEmployeeByDept(employeeList);
    }

    @Test
    void groupEmployeesByAgeAndPrintDescOrderTest() {
        EmployeeQueriesPractice.groupEmployeesByAgeAndPrintDescOrder(employeeList);
    }
}