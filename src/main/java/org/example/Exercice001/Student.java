package org.example.Exercice001;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private String first_name;

    private int classNumber;

    private Date graduationDate;

    private static int studentCount;

    public Student(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public void saveStudent(String name, String first_name, int classNumber, Date graduationDate){
        Student student = new Student();
    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> allStudents = new ArrayList<>();
        return allStudents;
    }




}
