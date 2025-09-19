/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package loginapp;

public class RegistrationValidator {
    public static boolean isValidUsername(String username) {
        return username != null && username.length() >= 5;
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.matches(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$"
        );
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches(
            "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$"
        );
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^0\\d{9}$");
    }
}