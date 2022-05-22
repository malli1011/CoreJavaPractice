package com.corejava.java8.streams;

import com.corejava.java8.streams.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeQueriesPractice {

    public static void countOfMaleAndFemale(List<Employee> employeeList) {
        // How many male and female employees are there in the organization?
        Map<String, Long> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        collect.forEach((key, val) -> System.out.println(key + " : " + val));
    }

    public static void printAllDepartments(List<Employee> employeeList) {
        //Print the name of all departments in the organization?
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
    }

    public static void avgAgeByGender(List<Employee> employeeList) {
        //What is the average age of male and female employees?
        employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)))
                .forEach((key, val) -> System.out.println(key + " : " + val));
    }

    public static void highestPaidEmployee(List<Employee> employeeList) {
        employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary)).ifPresent(System.out::println);
    }

    public static void employeesJoinedAfter2015(List<Employee> employeeList) {
        employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).forEach(System.out::println);
    }

    public static void avgSalaryByDept(List<Employee> employeeList) {
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((key, val) -> System.out.println(key + " : " + val));
    }

    //Get the details of the youngest male employee in the product development department?
    public static void youngestMaleEmpInProductDept(List<Employee> employeeList) {
        employeeList.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase("Product Development"))
                .filter(emp -> emp.getGender().equalsIgnoreCase("Male"))
                .min(Comparator.comparing(Employee::getAge)).ifPresent(System.out::println);
    }

    //Who has the most working experience in the organization?
    public static void mostWorkExperienceInOrg(List<Employee> employees) {
        employees.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).ifPresent(System.out::println);
    }

    //What is the average salary and total salary of the whole organization?
    public static void avgAndTotalSalaryOfOrg(List<Employee> employees) {
        DoubleSummaryStatistics summaryStatistics = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getMax());

    }

    // Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
    public static void separateEmployeesAboveAndBelow25(List<Employee> employees) {
        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy(emp -> emp.getAge() > 25));

        System.out.println("Employees over 25!");
        collect.get(true).forEach(System.out::println);
        System.out.println("Employees under 25!");
        collect.get(false).forEach(System.out::println);

    }

    //Who is the oldest employee in the organization? What is his age and which department he belongs to?
    public static void getOldestEmployee(List<Employee> employees) {
        employees.stream().max(Comparator.comparingInt(Employee::getAge)).ifPresent(System.out::println);
    }

    //Highest paid employee in each department.
    public static void getHighestPaidEmployeeByDept(List<Employee> employees) {
        Map<String, Optional<Employee>> collect = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                        )
                );

        collect.forEach((key, val) -> System.out.println(key + " : " + val.orElse(null)));

    }
}
