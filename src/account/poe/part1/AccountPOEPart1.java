/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package account.poe.part1;

import java.util.Scanner;

public class  AccountPOEPart1 {

    static Scanner input = new Scanner(System.in);

    // ================= USER DETAILS =================
    static String storedUsername;
    static String storedPassword;
    static String storedPhone;
    static String firstName;
    static String lastName;

    // ================= MESSAGE DETAILS =================
    static String messagePayload = "";
    static boolean messageSent = false;
    static boolean messageReceived = false;
    static boolean messageRead = false;

    public static void main(String[] args) {

        System.out.print("Enter first name: ");
        firstName = input.nextLine();

        System.out.print("Enter last name: ");
        lastName = input.nextLine();

        registerUser();

        if (loginUser()) {
            System.out.println("Login successful");
            chatMenu();
        } else {
            System.out.println("Too many failed attempts. Account is locked");
        }
    }

    // ================= REGISTER USER =================
    static void registerUser() {

        System.out.print("Enter username: ");
        String username = input.nextLine();

        if (checkUsername(username)) {
            System.out.println("Username successfully captured.");
            storedUsername = username;
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            return;
        }

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (checkPassword(password)) {
            System.out.println("Password successfully captured.");
            storedPassword = password;
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            return;
        }

        System.out.print("Enter phone number: ");
        String phone = input.nextLine();

        if (checkPhoneNumber(phone)) {
            System.out.println("Cell number successfully captured.");
            storedPhone = phone;
        } else {
            System.out.println("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.");
        }
    }

    // ================= LOGIN =================
    static boolean loginUser() {

        int attempts = 0;

        while (attempts < 3) {

            System.out.print("Enter username: ");
            String username = input.nextLine();

            System.out.print("Enter password: ");
            String password = input.nextLine();

            if (storedUsername.equals(username) && storedPassword.equals(password)) {
                return true;
            } else {
                attempts++;
                System.out.println("Login failed");
            }
        }

        return false;
    }

    // ================= CHAT MENU =================
    static void chatMenu() {

        int option;

        do {
            System.out.println("\n-----CHAT MENU-----");
            System.out.println("Send Message");
            System.out.println("View Message");
            System.out.print("Menu option: ");

            option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:
                    sendMessage();
                    break;

                case 2:
                    viewMessage();
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (option != 0);
    }

    // ================= SEND MESSAGE =================
    static void sendMessage() {

        System.out.print("Enter your message: ");
        messagePayload = input.nextLine();

        messageSent = true;
        messageReceived = true;
        messageRead = false;

        System.out.println("Message successfully sent.");
        displayStatus();
    }

    // ================= VIEW MESSAGE =================
    static void viewMessage() {

        if (messagePayload.equals("")) {
            System.out.println("No message available.");
            return;
        }

        System.out.println("Message: " + messagePayload);

        messageRead = true;

        displayStatus();
    }

    // ================= MESSAGE STATUS =================
    static void displayStatus() {

        if (messageSent) {
            System.out.println("Sent ✔");
        }

        if (messageReceived) {
            System.out.println("Received ✔✔");
        }

        if (messageRead) {
            System.out.println("Read ✔✔");
        }
    }

    // ================= VALIDATION METHODS =================

    static boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    static boolean checkPassword(String password) {

        if (password.length() < 8) return false;

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    static boolean checkPhoneNumber(String phone) {
        return phone.matches("^\\+\\d{1,3}\\d{1,10}$");
    }
}