package menu;

import model.Brand;
import model.UserData;
import persistence.RepositoryUserData;
import validation.Validation;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// implement your project on intellij
// Proceed with the implementation for the package 'model'
// Add all classes reference your database diagram
// Add the @Entity, @Id, @Id, auto_increment, add all foreign keys (FK) - @ManyToOne
// Tips: do everything in small steps

public class MainMenu {

    public static Validation val = new Validation();
    public static Scanner scanner = new Scanner(System.in);

    public static void login() {

        RepositoryUserData repositoryUserData = new RepositoryUserData();
        UserData userData = new UserData();

        System.out.println("Username");
        String userInput = scanner.next();

        if (val.username(userInput)) {
            userData.setUsername(userInput);
        } else {
            System.out.println("Username must contain only characters!");
            System.out.println("Username cant be shorther than 3 characters or bigger than 20 characters");
        }

        System.out.println("Password");
        userInput = scanner.next();

        if (val.password(userInput)) {
            userData.setPwd(userInput);
        } else {
            System.out.println("Password must contain only numbers!");
            System.out.println("Password cant be shorter than 6 numbers and larger than 10 numbers");
        }

        System.out.println("Email");
        userInput = scanner.next();

        if (val.email(userInput)) {
            userData.setEmail(userInput);
        } else {
            System.out.println("This is not correct email address");
        }

        System.out.println("Address");
        userData.setAddress(scanner.next());

        System.out.println("Phone number");
        userData.setPhone(scanner.nextInt());

        repositoryUserData.login(userData);

    }

    public static void addNewUser() {

        RepositoryUserData repositoryUserData = new RepositoryUserData();
        UserData userData = new UserData();

        System.out.println("Username");
        String userInput = scanner.next();

        if (val.username(userInput)) {
            userData.setUsername(userInput);
        } else {
            System.out.println("Username must contain only characters!");
            System.out.println("Username cant be shorther than 3 characters or bigger than 20 characters");
        }

        System.out.println("Password");
        userInput = scanner.next();

        if (val.password(userInput)) {
            userData.setPwd(userInput);
        } else {
            System.out.println("Password must contain only numbers!");
            System.out.println("Password cant be shorter than 6 numbers and larger than 10 numbers");
        }

        System.out.println("Email");
        userInput = scanner.next();

        if (val.email(userInput)) {
            userData.setEmail(userInput);
        } else {
            System.out.println("This is not correct email address");
        }

        System.out.println("Address");
        userData.setAddress(scanner.next());

        System.out.println("Phone number");
        userData.setPhone(scanner.nextInt());

        repositoryUserData.createNewAccount(userData);

    }

    public static void main(String[] args) {

        boolean working = true;

        while (working) {
            System.out.println("Menu");
            System.out.println("1. Create new user");
            System.out.println("2. Login");
            System.out.println("10. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewUser();
                    break;

                case 2:
                    login();
                    break;

                case 10:
                    working = false;
                    break;

                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }

    }

}
