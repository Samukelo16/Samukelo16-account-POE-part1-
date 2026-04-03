/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package account.poe.part1;

import java.util.Scanner;

public class AccountPOEPart1 {

    private String username;
    private String password;
    private String phoneNumber;

    public AccountPOEPart1(String username, String password, String phoneNumber){
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // username check
    public boolean checkUsername(){
        return username.contains("_") && username.length() <= 5;
    }

    // Password check
    public boolean checkPassword() {
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

    // SA Phone Validation
    public boolean checkPhoneNumber() {
        return phoneNumber.matches("^\\+27\\d{9}$");
    }

    // Registration message
    public String registerUser() {

        if (!checkUsername()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPassword()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkPhoneNumber()) {
            return "Cell phone number is incorrectly formatted or does not contain international code.";
        }

        return "Username and password successfully captured.";
    }

    // ✅ MAIN METHOD (put it inside the same class)
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter phone number: ");
        String phone = input.nextLine();

        // ✅ create object of SAME class
        AccountPOEPart1 user = new AccountPOEPart1(username, password, phone);

        System.out.println(user.registerUser());
    }
}