package org.example.Exercice001;


import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        try {
            connection = DatabaseManager.getPostGreSQLException();
            System.out.println("Saisir nom");
            String name = scanner.nextLine();
            System.out.println("Saisir prénom");
            String firstname = scanner.nextLine();
            System.out.println("Saisir numéro classe");
            int classNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Saisir date obtention diplôme");
            String dateString = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            Date graduationDate;
            try {
                graduationDate = (Date) dateFormat.parse(dateString);
            } catch (ParseException e) {
                graduationDate = new Date(01-01-1990);
            }
            Student student = new Student();


            String query = "INSERT INTO etudiant (name, first_name, classNumber, graduationDate) " +
                    "VALUES ('"+name+"' , '"+firstname+"' , '"+classNumber+"' , '"+graduationDate+"')";

            Statement statement = connection.createStatement();
            boolean dataCheck = statement.execute(query);
            if (dataCheck){
                System.out.println("Data send successfully");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }


    }
}
