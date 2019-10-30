package edu.mum.cs.students_data.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Student {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private Double gpa;
    private Integer age;
    private LocalDate birthday;

    public Student() {
    }

    public Student(Integer id, String firstName, String lastName, Double gpa, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gpa=" + gpa +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
