package org.example.Exercice001;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import org.example.Exercice001.Student;

public class Menu {
    private static ArrayList<Student> studentList;


    public static void afficherMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
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

            choix = scanner.nextInt();
            scanner.nextLine();

            try {
                    switch (choix) {
                        case 1:
                        System.out.println("Saisir nom");
                        String name = scanner.nextLine();
                        System.out.println("Saisir prénom");
                        String first_name = scanner.nextLine();
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
                            graduationDate = new Date(01 - 01 - 1990);
                        }
                        studentList.get().saveStudent();
                        break;
                        case 2:
                            studentList.get().getAllStudents();
                            break;
                        case 3:
                            System.out.println("Entrer l'identifiant de l'étudiant à supprimer de la liste");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            studentList.get().deleteStudent();
                            break;
                        case 4:
                            studentList.get().getStudentByClass();
                            break;
                        case 0:
                            System.out.println("Bye bye");
                            break;
                        default:
                            System.out.println("Choix invalide. Veuillez entrer un choix valide !!!!");

                    }


            }
        } while (choix != 0) ;

        scanner.close();
    }
}
