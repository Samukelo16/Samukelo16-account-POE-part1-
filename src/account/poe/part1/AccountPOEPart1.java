/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package account.poe.part1;

import java.util.Scanner;

public class AccountPOEPart1 {

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

        boolean loginStatus = loginUser();

        // ✅ REQUIRED OUTPUT FORMAT
        if (loginStatus) {
            System.out.println("Login Successful");
            System.out.println("The system returns: True");
            chatMenu();
        } else {
            System.out.println("Login Failed");
            System.out.println("The system returns: False");
            System.out.println("Too many failed attempts. Account is locked");
        }
    }

    // ================= REGISTER USER =================
    static void registerUser() {

        // USERNAME LOOP
        while (true) {
            System.out.print("Enter username: ");
            String username = input.nextLine();

            if (checkUsername(username)) {
                System.out.println("Username successfully captured.");
                System.out.println("The system returns: True");
                storedUsername = username;
                break;
            } else {
                System.out.println("Username incorrectly formatted");
                System.out.println("The system returns: False");
            }
        }

        // PASSWORD LOOP
        while (true) {
            System.out.print("Enter password: ");
            String password = input.nextLine();

            if (checkPassword(password)) {
                System.out.println("Password meets complexity requirements.");
                System.out.println("The system returns: True");
                storedPassword = password;
                break;
            } else {
                System.out.println("Password does not meet complexity");
                System.out.println("The system returns: False");
            }
        }

        // PHONE LOOP
        while (true) {
            System.out.print("Enter phone number: ");
            String phone = input.nextLine();

            if (checkPhoneNumber(phone)) {
                System.out.println("Cell number successfully captured.");
                storedPhone = phone;
                break;
            } else {
                System.out.println("Invalid phone number. Use international format (e.g. +2783...)");
            }
        }
    }

    // ================= LOGIN =================
    static boolean loginUser() {

        // ✅ Prevent crash if not registered
        if (storedUsername == null || storedPassword == null) {
            System.out.println("No user registered.");
            return false;
        }

        int attempts = 0;

        while (attempts < 3) {

            System.out.print("Enter username: ");
            String username = input.nextLine();

            System.out.print("Enter password: ");
            String password = input.nextLine();

            // ✅ SAFE comparison
            if (username.equals(storedUsername) && password.equals(storedPassword)) {
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
            System.out.println("\n----- CHAT MENU -----");
            System.out.println("1. Send Message");
            System.out.println("2. View Message");
            System.out.println("0. Exit");
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

                case 0:
                    System.out.println("Exiting chat...");
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