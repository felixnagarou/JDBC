package org.example.Exercice001;

import java.sql.*;
import java.util.ArrayList;


public class Student {
    private String name;
    private String first_name;

    private int classNumber;

    private java.util.Date graduationDate;

    private static String query;

    private static Connection connection;

    private static  PreparedStatement statement;



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

    public java.util.Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public void saveStudent() throws SQLException {
        String query = "INSERT INTO etudiant (name, first_name, classNumber, graduationDate) " +
                "VALUES ('"+name+"' , '"+first_name+"' , '"+classNumber+"' , '"+graduationDate+"')";
        Connection connection = DatabaseManager.getPostGreSQLException();
        statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, getName());
        statement.setString(2, getFirst_name());
        statement.setInt(3, getClassNumber());
        statement.setDate(4, new Date(getGraduationDate().getTime()));
        int nbRows = statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            setId(resultSet.getInt(1));
        }

        //return query;

    }

    private void setId(int anInt) {
    }

    //private void setId(int anInt) {
    //}

    public static ArrayList<Student> getAllStudents() throws SQLException {
        Statement statement = DatabaseManager.getPostGreSQLException().createStatement();
        ResultSet studentSet = statement.executeQuery("SELECT * FROM etudiant");
        while (studentSet.next()){
            Student s = new Student();
            s.setName(studentSet.getString("name"));
            s.setFirst_name(studentSet.getString("first_name"));
            s.setClassNumber(studentSet.getInt("classNumber"));
            s.setGraduationDate(studentSet.getDate("graduationDate"));
        }
        ArrayList<Student> allStudents = new ArrayList<>();
        return allStudents;
    }

    public void deleteStudent(int id) throws SQLException {
        String query = null;
        Statement statement = DatabaseManager.getPostGreSQLException().createStatement();
        query = "DELETE FROM etudiant WHERE id = " + id;
        //return query;
    }

    public ArrayList getStudentByClass(int classNumber) {
        String query = null;
       // return query;
    }




}
