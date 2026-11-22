package first;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class First_swing extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    // =========================================================
    // PREMIUM COLOR PALETTE
    // =========================================================
    private static final Color NAVY = new Color(8, 27, 52);
    private static final Color NAVY_LIGHT = new Color(15, 45, 78);
    private static final Color BLUE = new Color(37, 99, 235);
    private static final Color BLUE_HOVER = new Color(29, 78, 216);
    private static final Color WHITE = Color.WHITE;
    private static final Color LIGHT_BG = new Color(246, 249, 252);
    private static final Color TEXT_DARK = new Color(31, 41, 55);
    private static final Color TEXT_GRAY = new Color(107, 114, 128);
    private static final Color BORDER = new Color(220, 226, 234);
    private static final Color SUCCESS = new Color(22, 163, 74);

    // Premium fonts
    private static final Font TITLE_FONT =
            new Font("Segoe UI", Font.BOLD, 24);

    private static final Font SUBTITLE_FONT =
            new Font("Segoe UI", Font.PLAIN, 14);

    private static final Font HEADING_FONT =
            new Font("Segoe UI", Font.BOLD, 21);

    private static final Font LABEL_FONT =
            new Font("Segoe UI", Font.BOLD, 14);

    private static final Font FIELD_FONT =
            new Font("Segoe UI", Font.PLAIN, 15);

    private static final Font BUTTON_FONT =
            new Font("Segoe UI", Font.BOLD, 14);

    public First_swing() {

        // =========================================================
        // WINDOW SETTINGS
        // =========================================================

        setTitle("Hospital Booking System");
        setSize(520, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // =========================================================
        // MAIN BACKGROUND
        // =========================================================

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT_BG);

        // =========================================================
        // PREMIUM HEADER
        // =========================================================

        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(520, 190));
        headerPanel.setBackground(NAVY);
        headerPanel.setLayout(null);

        // Hospital icon
        JLabel hospitalIcon = new JLabel("+");
        hospitalIcon.setForeground(WHITE);
        hospitalIcon.setFont(new Font("Segoe UI", Font.BOLD, 36));
        hospitalIcon.setHorizontalAlignment(SwingConstants.CENTER);
        hospitalIcon.setBorder(
                BorderFactory.createLineBorder(
                        new Color(255, 255, 255, 80), 2
                )
        );
        hospitalIcon.setBounds(230, 20, 60, 60);

        // Main title
        JLabel titleLabel =
                new JLabel("HOSPITAL BOOKING SYSTEM");

        titleLabel.setForeground(WHITE);
        titleLabel.setFont(TITLE_FONT);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(50, 88, 420, 35);

        // Subtitle
        JLabel welcomeLabel =
                new JLabel("Secure healthcare appointment management");

        welcomeLabel.setForeground(
                new Color(205, 218, 235)
        );

        welcomeLabel.setFont(SUBTITLE_FONT);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(50, 125, 420, 25);

        // Small status indicator
        JLabel statusLabel =
                new JLabel("●  SYSTEM ONLINE");

        statusLabel.setForeground(
                new Color(74, 222, 128)
        );

        statusLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 11)
        );

        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setBounds(175, 155, 170, 20);

        headerPanel.add(hospitalIcon);
        headerPanel.add(titleLabel);
        headerPanel.add(welcomeLabel);
        headerPanel.add(statusLabel);

        // =========================================================
        // LOGIN AREA
        // =========================================================

        JPanel loginArea = new JPanel(new BorderLayout());
        loginArea.setBackground(LIGHT_BG);
        loginArea.setBorder(
                new EmptyBorder(25, 55, 25, 55)
        );

        // =========================================================
        // LOGIN CARD
        // =========================================================

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(WHITE);

        loginPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER, 1
                        ),
                        new EmptyBorder(10, 10, 10, 10)
                )
        );

        // =========================================================
        // LOGIN TITLE
        // =========================================================

        JLabel accountLabel =
                new JLabel("Welcome Back");

        accountLabel.setFont(HEADING_FONT);
        accountLabel.setForeground(TEXT_DARK);
        accountLabel.setBounds(45, 25, 300, 35);

        JLabel accountSubtitle =
                new JLabel("Sign in to access your account");

        accountSubtitle.setFont(
                new Font("Segoe UI", Font.PLAIN, 13)
        );

        accountSubtitle.setForeground(TEXT_GRAY);
        accountSubtitle.setBounds(45, 58, 300, 25);

        // =========================================================
        // USERNAME
        // =========================================================

        JLabel usernameLabel =
                new JLabel("USERNAME");

        usernameLabel.setFont(LABEL_FONT);
        usernameLabel.setForeground(TEXT_DARK);
        usernameLabel.setBounds(45, 100, 150, 25);

        usernameField = new JTextField();

        usernameField.setFont(FIELD_FONT);
        usernameField.setForeground(TEXT_DARK);
        usernameField.setBackground(
                new Color(250, 251, 253)
        );

        usernameField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER, 1
                        ),
                        new EmptyBorder(
                                5, 12, 5, 12
                        )
                )
        );

        usernameField.setBounds(45, 127, 320, 40);

        // =========================================================
        // PASSWORD
        // =========================================================

        JLabel passwordLabel =
                new JLabel("PASSWORD");

        passwordLabel.setFont(LABEL_FONT);
        passwordLabel.setForeground(TEXT_DARK);
        passwordLabel.setBounds(45, 182, 150, 25);

        passwordField = new JPasswordField();

        passwordField.setFont(FIELD_FONT);
        passwordField.setForeground(TEXT_DARK);
        passwordField.setBackground(
                new Color(250, 251, 253)
        );

        passwordField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER, 1
                        ),
                        new EmptyBorder(
                                5, 12, 5, 12
                        )
                )
        );

        passwordField.setBounds(45, 209, 320, 40);

        // =========================================================
        // LOGIN BUTTON
        // =========================================================

        loginButton =
                new JButton("SIGN IN");

        loginButton.setFont(BUTTON_FONT);
        loginButton.setForeground(WHITE);
        loginButton.setBackground(BLUE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        loginButton.setBounds(45, 275, 320, 45);

        // Hover effect
        loginButton.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent e) {

                        loginButton.setBackground(
                                BLUE_HOVER
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent e) {

                        loginButton.setBackground(
                                BLUE
                        );
                    }
                }
        );

        // =========================================================
        // SECURITY MESSAGE
        // =========================================================

        JLabel securityLabel =
                new JLabel("🔒  Your information is securely protected");

        securityLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 11)
        );

        securityLabel.setForeground(TEXT_GRAY);
        securityLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        securityLabel.setBounds(45, 335, 320, 25);

        // =========================================================
        // ADD COMPONENTS
        // =========================================================

        loginPanel.add(accountLabel);
        loginPanel.add(accountSubtitle);

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);

        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        loginPanel.add(loginButton);
        loginPanel.add(securityLabel);

        loginArea.add(loginPanel, BorderLayout.CENTER);

        // =========================================================
        // FOOTER
        // =========================================================

        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(LIGHT_BG);
        footerPanel.setPreferredSize(
                new Dimension(520, 45)
        );

        JLabel footerLabel =
                new JLabel(
                        "© 2026 Hospital Booking System  •  Healthcare Management"
                );

        footerLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 11)
        );

        footerLabel.setForeground(TEXT_GRAY);

        footerPanel.add(footerLabel);

        // =========================================================
        // ADD EVERYTHING TO MAIN WINDOW
        // =========================================================

        mainPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        mainPanel.add(
                loginArea,
                BorderLayout.CENTER
        );

        mainPanel.add(
                footerPanel,
                BorderLayout.SOUTH
        );

        add(mainPanel);

        // =========================================================
        // BUTTON ACTION
        // =========================================================

        loginButton.addActionListener(this);

        // Press ENTER to login
        passwordField.addActionListener(this);

        setVisible(true);
    }

    // =============================================================
    // MAIN METHOD
    // =============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new First_swing();
        });
    }

    // =============================================================
    // LOGIN FUNCTION
    // =============================================================

    @Override
    public void actionPerformed(ActionEvent e) {

        String username =
                usernameField.getText().trim();

        String password =
                new String(
                        passwordField.getPassword()
                );

        // =========================================================
        // VALIDATE INPUT
        // =========================================================

        if (username.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter your username and password.",
                    "Login Required",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // =========================================================
        // DATABASE CONNECTION
        // =========================================================

        try (Connection con =
                     DBConnection.getConnection()) {

            if (con == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Unable to connect to the database.",
                        "Database Connection Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // =====================================================
            // LOGIN QUERY
            // =====================================================

            String sql =
                    "SELECT * FROM users " +
                    "WHERE username = ? AND password = ?";

            try (PreparedStatement ps =
                         con.prepareStatement(sql)) {

                ps.setString(1, username);
                ps.setString(2, password);

                try (ResultSet rs =
                             ps.executeQuery()) {

                    if (rs.next()) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Welcome, " + username +
                                "! Login successful.",
                                "Welcome",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        passwordField.setText("");
                        
                        this.dispose();                          // closes the login window
                        new PatientForm().setVisible(true);      // opens your main hospital system window

                        // =================================================
                        // OPEN MAIN HOSPITAL SYSTEM HERE
                        // =================================================
                        //
                        // this.dispose();
                        // new HospitalMainScreen();
                        //
                        // =================================================

                    } else {

                        JOptionPane.showMessageDialog(
                                this,
                                "Invalid username or password.",
                                "Login Failed",
                                JOptionPane.ERROR_MESSAGE
                        );

                        passwordField.setText("");
                        passwordField.requestFocus();
                    }
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error:\n" +
                    ex.getMessage(),
                    "System Error",
                    JOptionPane.ERROR_MESSAGE
            );

            ex.printStackTrace();
        }
    }
}
