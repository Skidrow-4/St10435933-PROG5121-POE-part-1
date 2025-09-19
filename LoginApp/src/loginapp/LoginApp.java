/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


package loginapp;

import javax.swing.*;
import java.awt.*;

public class LoginApp extends JFrame {
    JTextField textUser, textEmail, textPhone;
    JPasswordField textPass;
    JButton registerButton;

    private String storedUsername;
    private String storedPassword;
    private String storedEmail;
    private String storedPhone;

    public LoginApp() {
        setTitle("Register Account");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, getWidth(), getHeight());

                g.setColor(new Color(100, 149, 237));
                g.fillPolygon(new int[]{0, 150, 300}, new int[]{300, 100, 300}, 3);

                g.setColor(new Color(70, 130, 180));
                g.fillPolygon(new int[]{150, 300, 450}, new int[]{300, 80, 300}, 3);

                g.setColor(new Color(119, 136, 153));
                g.fillPolygon(new int[]{75, 225, 375}, new int[]{300, 50, 300}, 3);
            }
        };

        backgroundPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelUser = new JLabel("Username:");
        textUser = new JTextField();
        textUser.setBackground(new Color(144, 238, 144));

        JLabel labelPass = new JLabel("Password:");
        textPass = new JPasswordField();
        textPass.setBackground(new Color(144, 238, 144));

        JLabel labelEmail = new JLabel("Email:");
        textEmail = new JTextField();
        textEmail.setBackground(new Color(144, 238, 144));

        JLabel labelPhone = new JLabel("SA Mobile No:");
        textPhone = new JTextField();
        textPhone.setBackground(new Color(144, 238, 144));

        registerButton = new JButton("Register") {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isPressed()) {
                    g.setColor(new Color(0, 128, 0).darker());
                } else if (getModel().isRollover()) {
                    g.setColor(new Color(0, 150, 0));
                } else {
                    g.setColor(new Color(0, 128, 0));
                }
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }
        };
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setFocusPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setBorderPainted(false);
        registerButton.setOpaque(false);

        registerButton.addActionListener(e -> handleRegistration());

        gbc.gridx = 0; gbc.gridy = 0; backgroundPanel.add(labelUser, gbc);
        gbc.gridx = 1; backgroundPanel.add(textUser, gbc);

        gbc.gridx = 0; gbc.gridy = 1; backgroundPanel.add(labelPass, gbc);
        gbc.gridx = 1; backgroundPanel.add(textPass, gbc);

        gbc.gridx = 0; gbc.gridy = 2; backgroundPanel.add(labelEmail, gbc);
        gbc.gridx = 1; backgroundPanel.add(textEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 3; backgroundPanel.add(labelPhone, gbc);
        gbc.gridx = 1; backgroundPanel.add(textPhone, gbc);

        gbc.gridx = 1; gbc.gridy = 4; backgroundPanel.add(registerButton, gbc);

        add(backgroundPanel);
        setVisible(true);
    }

    private void handleRegistration() {
        String username = textUser.getText();
        String password = new String(textPass.getPassword());
        String email = textEmail.getText();
        String phone = textPhone.getText();

        if (!RegistrationValidator.isValidUsername(username)) {
            JOptionPane.showMessageDialog(this, "Username must be at least 5 characters long!");
            return;
        }
        if (!RegistrationValidator.isValidPassword(password)) {
            JOptionPane.showMessageDialog(this,
                "Password must be at least 8 characters long and include:\n" +
                "- Uppercase letter\n- Lowercase letter\n- Number\n- Special character");
            return;
        }
        if (!RegistrationValidator.isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format!");
            return;
        }
        if (!RegistrationValidator.isValidPhone(phone)) {
            JOptionPane.showMessageDialog(this, "Invalid South African mobile number! Must be 10 digits and start with 0.");
            return;
        }

        storedUsername = username;
        storedPassword = password;
        storedEmail = email;
        storedPhone = phone;

        JOptionPane.showMessageDialog(this, "✅ Registration successful!\n\nPlease log in.");
        openLoginWindow();
    }

    private void openLoginWindow() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 200);
        loginFrame.setLocationRelativeTo(this);
        loginFrame.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel labelUser = new JLabel("Username:");
        JTextField loginUser = new JTextField();

        JLabel labelPass = new JLabel("Password:");
        JPasswordField loginPass = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginFrame.add(labelUser); loginFrame.add(loginUser);
        loginFrame.add(labelPass); loginFrame.add(loginPass);
        loginFrame.add(new JLabel("")); loginFrame.add(loginButton);

        loginButton.addActionListener(ae -> {
            String enteredUser = loginUser.getText();
            String enteredPass = new String(loginPass.getPassword());

            if (enteredUser.equals(storedUsername) && enteredPass.equals(storedPassword)) {
                JOptionPane.showMessageDialog(loginFrame, "🎉 Welcome, " + storedUsername + "!");
                loginFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid login details!");
            }
        });

        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginApp();
    }
    /*Skhuselo. (2025). LoginApp: A Java-based registration and login system [Computer software]. Unpublished manuscript.
    Skhuselo Vilani- ST10435933 OpenAI. (2023). ChatGPT (Sep 3 version) [Large language model]. https://chat.openai.com
*/
}
