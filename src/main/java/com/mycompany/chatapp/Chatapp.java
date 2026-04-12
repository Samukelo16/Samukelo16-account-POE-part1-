/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class Chatapp {

 private String username;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    public Chatapp(String username, String password, String phoneNumber, String firstName, String lastName){
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Username check
    public boolean checkUsername(){
        return username.contains("_") && username.length() <= 5;
    }

    // Password check
    public boolean checkPassword(){
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        if (password.length() >= 8) {
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    hasCapital = true;
                } else if (Character.isDigit(c)) {
                    hasNumber = true;
                } else if (!Character.isLetterOrDigit(c)) {
                    hasSpecial = true;
                }
            }
        }
        return hasCapital && hasNumber && hasSpecial;
    }

    // Phone check
    public boolean checkPhoneNumber(){
        return phoneNumber.matches("^\\+\\d{1,3}\\d{1,10}$");
    }

    // Registration messages
    public String registerUser(){

        if (!checkUsername()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPassword()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkPhoneNumber()) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        return "Username and password successfully captured.";
    }

    //  LOGIN METHOD
    public boolean loginUser(String enteredUsername, String enteredPassword){
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    //  LOGIN STATUS MESSAGE
    public String returnLoginStatus(boolean loginSuccess){
        if (loginSuccess){
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // MAIN METHOD
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter phone number: ");
        String phone = input.nextLine();

        Chatapp user = new Chatapp(username, password, phone, firstName, lastName);

        System.out.println(user.registerUser());

        // LOGIN SECTION
        System.out.print("\nEnter username to login: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password to login: ");
        String loginPass = input.nextLine();

        boolean loginResult = user.loginUser(loginUser, loginPass);
        System.out.println(user.returnLoginStatus(loginResult));
    }
}