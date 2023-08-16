package org.example;

import org.example.util.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo1 {

    public static void mai(String[] args){
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        try {
            connection = DatabaseManager.getPostgreSQLConnection();
            System.out.println("Merci de saisir le prénom:");
            String firstname = scanner.nextLine();
            System.out.println("Merci de saisir le nom:");
            String lastname = scanner.nextLine();
            String request = "INSERT INTO person (fisrt_name, last_name) VALUES ('"+firstname+"' , '"+lastname+"')";

            Statement statement = connection.createStatement();
            boolean res = statement.execute(request);
            if (res){
                System.out.println("Des données renvoyées par la requête");
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
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
