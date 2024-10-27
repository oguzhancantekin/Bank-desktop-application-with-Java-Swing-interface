import javax.swing.*;
import java.awt.*;

public class BankEmployeeLoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public BankEmployeeLoginScreen() {
        super("Banka Personeli Giriş Ekranı");
        getContentPane().setBackground(new Color(240, 248, 255)); // Arka plan rengi
        setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Kullanıcı Adı:");
        usernameLabel.setForeground(new Color(0, 0, 128)); // Metin rengi
        add(usernameLabel);

        usernameField = new JTextField();
        add(usernameField);

        JLabel passwordLabel = new JLabel("Şifre:");
        passwordLabel.setForeground(new Color(0, 0, 128)); // Metin rengi
        add(passwordLabel);

        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Giriş Yap");
        loginButton.setBackground(new Color(59, 89, 182)); // Buton arka plan rengi
        loginButton.setForeground(Color.WHITE); // Buton metin rengi
        loginButton.setFocusPainted(false); // Kenarlık çizgisini kaldır
        loginButton.addActionListener(e -> handleLoginButtonClick());
        add(loginButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleLoginButtonClick() {
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        if (EmployeeDatabase.isValidEmployee(username, password)) {
            // Doğru çalışan girişi, bir sonraki adıma geçilebilir.
            openBankEmployeeDashboardScreen();
        } else {
            JOptionPane.showMessageDialog(this, "Geçersiz kullanıcı adı veya şifre.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openBankEmployeeDashboardScreen() {
        SwingUtilities.invokeLater(() -> new BankEmployeeDashboard());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankEmployeeLoginScreen());
    }
}
