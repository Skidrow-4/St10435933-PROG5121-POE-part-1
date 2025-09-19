/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package loginapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class RegistrationValidatorTest {

    @Test
    public void testValidUsername() {
        assertTrue(RegistrationValidator.isValidUsername("Skhuselo"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(RegistrationValidator.isValidUsername("abc"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(RegistrationValidator.isValidPassword("Strong@123"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(RegistrationValidator.isValidPassword("weakpass"));
    }

    @Test
    public void testValidEmail() {
        assertTrue(RegistrationValidator.isValidEmail("user@example.com"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(RegistrationValidator.isValidEmail("user@com"));
    }

    @Test
    public void testValidPhone() {
        assertTrue(RegistrationValidator.isValidPhone("0821234567"));
    }

    @Test
    public void testInvalidPhone() {
        assertFalse(RegistrationValidator.isValidPhone("123456789"));
    }
}