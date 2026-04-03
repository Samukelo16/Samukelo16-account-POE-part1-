/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package account.poe.part1;

/**
 *
 * @author Student
 */
public class AccountPOEPart1 {
    private String username;
    private String password;
    private String phoneNumber;
    
    public Login(String username, String password, String phoneNumber){
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    
    // username check
    public boolen checkUsername(){
        return username.contains("-") && username.length() <= 5;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        
        // TODO code application logic here
    }
    
}
