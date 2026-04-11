/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package account.poe.part1;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccountPOEPart1Test {

    // USERNAME TESTS
    @Test
    public void testUsernameValid(){
        AccountPOEPart1 user = new AccountPOEPart1("kyl_1","Password1!","+27838968976","Kyle","Smith");
        assertEquals(true, user.checkUsername());
    }

    @Test
    public void testUsernameInvalid(){
        AccountPOEPart1 user = new AccountPOEPart1("kyle123","Password1!","+27838968976","Kyle","Smith");
        assertEquals(false, user.checkUsername());
    }

    // PASSWORD TESTS
    @Test
    public void testPasswordValid(){
        AccountPOEPart1 user = new AccountPOEPart1("kyl_1","Ch&&sec@ke99","+27838968976","Kyle","Smith");
        assertEquals(true, user.checkPassword());
    }

    @Test
    public void testPasswordInvalid(){
        AccountPOEPart1 user = new AccountPOEPart1("kyl_1","password","+27838968976","Kyle","Smith");
        assertEquals(false, user.checkPassword());
    }

    // PHONE TESTS
    @Test
    public void testPhoneValid(){
        AccountPOEPart1 user = new AccountPOEPart1("kyl_1","Password1!","+27838968976","Kyle","Smith");
        assertEquals(true, user.checkPhoneNumber());
    }

    @Test
    public void testPhoneInvalid(){
        AccountPOEPart1 user = new AccountPOEPart1("kyl_1","Password1!","08966553","Kyle","Smith");
        assertEquals(false, user.checkPhoneNumber());
    }

    // REGISTER TEST
    @Test
    public void testRegisterSuccess(){
        AccountPOEPart1 user = new AccountPOEPart1("kyl_1","Password1!","+27838968976","Kyle","Smith");
        assertEquals("Username and password successfully captured.", user.registerUser());
    }

    // LOGIN TESTS
    @Test
    public void testLoginSuccess(){
        AccountPOEPart1 user = new AccountPOEPart1("kyl_1","Password1!","+27838968976","Kyle","Smith");
        assertEquals(true, user.loginUser("kyl_1","Password1!"));
    }

    @Test
    public void testLoginFail(){
        AccountPOEPart1 user = new AccountPOEPart1("kyl_1","Password1!","+27838968976","Kyle","Smith");
        assertEquals(false, user.loginUser("wrong","wrong"));
    }

    // LOGIN MESSAGE TESTS
    @Test
    public void testLoginMessageSuccess(){
        AccountPOEPart1 user = new AccountPOEPart1("kyl_1","Password1!","+27838968976","Kyle","Smith");
        assertEquals("Welcome Kyle Smith, it is great to see you again.", user.returnLoginStatus(true));
    }

    @Test
    public void testLoginMessageFail(){
        AccountPOEPart1 user = new AccountPOEPart1("kyl_1","Password1!","+27838968976","Kyle","Smith");
        assertEquals("Username or password incorrect, please try again.", user.returnLoginStatus(false));
    }
}