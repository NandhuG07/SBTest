package com.example.emsFordSBFinalTest.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;


@Entity
@Table(name="Emp_tb")
public class Ems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;
    @Column(name="FNAME")
    @NotBlank(message="Emp First Name can not be blank")
    @Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*" ,message="Emp First Name Invalid}")
    private String firstName;

    @Column(name="LNAME")
    @NotBlank(message="Emp Last Name can not be blank")
    @Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*" ,message="Emp Last Name Invalid}")
    private String lastName;

    @Column(name="DEPT")
    @NotBlank(message="Emp Department Name can not be blank")
    private String department;

    @Column(name="DESG")
    @NotBlank(message="Emp designation can not be blank")
    private String designation;

    @Column(name="SALARY")
    @NotBlank(message="Emp Salary can not be blank")
    @Positive(message = "Salary must be Positive")
    @Min(value=20000, message = "Salary must be greater than 20000")
    private double salary;

    public Ems() {
    }

    public Ems(int empId, String firstName, String lastName, String department, String designation, double salary) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.designation = designation;
        this.salary=salary;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Ems{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
