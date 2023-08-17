package org.example.Exercice001;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import org.example.Exercice001.Student;

public class Menu {
    private static ArrayList<Student> studentList;


    public static void afficherMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Student student = null;
        int choix;



        do {
            System.out.println("=== Menu principal ===");
            System.out.println();
            System.out.println("1. Ajouter un étudiant ");
            System.out.println("2. Afficher la liste des étudiants");
            System.out.println("3. Supprimer un étudiant");
            System.out.println("4. Liste des étudiants par classe");
            System.out.println("0. Quitter");
            System.out.println("Votre choix :");

            choix= scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    student.saveStudent();
                    break;
                case 2:
                    student.getAllStudents();
                    break;
                case 3 :
                    student.deleteStudent();
                    break;
                case 4 :
                    student.getStudentByClass();
                    break;
                case 0 :
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez entrer un choix valide !!!!");

            }


        }while (choix != 0);

        scanner.close();

    }
}
