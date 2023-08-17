package org.example.Exercice001;

import java.sql.Date;

public class Student {
    private String name;
    private String first_name;

    private int classNumber;

    private Date graduationDate;

    //private static int studentCount;

    public Student(String name, String first_name, int classNumber, Date graduationDate){
        //id = studentCount++;
        this.name = name;
        this.first_name = first_name;
        this.classNumber = classNumber;
        this.graduationDate = graduationDate;
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


}
