package org.example.Exercice001;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public String saveStudent(String name, String first_name, int classNumber, Date graduationDate) throws SQLException {
        Statement statement = DatabaseManager.getPostGreSQLException().createStatement();
        String query = "INSERT INTO etudiant (name, first_name, classNumber, graduationDate) " +
                "VALUES ('"+name+"' , '"+first_name+"' , '"+classNumber+"' , '"+graduationDate+"')";
        return query;

    }

    public ArrayList<Student> getAllStudents() throws SQLException {
        Statement statement = DatabaseManager.getPostGreSQLException().createStatement();
        ResultSet studentSet = statement.executeQuery("SELECT * FROM etudiant");
        ArrayList<Student> allStudents = new ArrayList<>();
        return allStudents;
    }

    public String deleteStudent(int id) throws SQLException {
        String query = null;
        Statement statement = DatabaseManager.getPostGreSQLException().createStatement();
        query = "DELETE FROM etudiant WHERE id = " + id;
        return query;
    }




}
