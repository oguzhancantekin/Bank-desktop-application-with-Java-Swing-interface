import javax.swing.*;
import java.awt.*;

public class CustomerLoginScreen extends JFrame {
    private JTextField tcField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public CustomerLoginScreen() {
        super("Müşteri Giriş Ekranı");
        getContentPane().setBackground(new Color(240, 248, 255)); // Arka plan rengi
        setLayout(new GridLayout(4, 2));

        JLabel tcLabel = new JLabel("TC Numarası:");
        tcLabel.setForeground(new Color(0, 128, 128)); // Metin rengi
        add(tcLabel);

        tcField = new JTextField();
        add(tcField);

        JLabel passwordLabel = new JLabel("Şifre:");
        passwordLabel.setForeground(new Color(0, 128, 128)); // Metin rengi
        add(passwordLabel);

        passwordField = new JPasswordField();
        add(passwordField);

        loginButton = new JButton("Giriş Yap");
        loginButton.setBackground(new Color(59, 89, 182)); // Buton arka plan rengi
        loginButton.setForeground(Color.WHITE); // Buton metin rengi
        loginButton.setFocusPainted(false); // Buton kenarlığı etkisini kaldır
        loginButton.addActionListener(e -> handleLoginButtonClick());
        add(loginButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void openCustomerDashboardScreen() {
        SwingUtilities.invokeLater(() -> new CustomerDashboardScreen());
        // Giriş ekranını kapat
        dispose();
    }

    private void handleLoginButtonClick() {
        String tcNumber = tcField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        // TC Numarası doğrulama
        if (tcNumber.length() != 11) {
            JOptionPane.showMessageDialog(this, "TC Numarası 11 haneli olmalıdır", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kullanıcıyı oluştur ve veritabanına ekle
        Customer.addCustomer(tcNumber, password);

        // Giriş kontrolü
        if (CustomerDatabase.isValidCustomer(tcNumber, password)) {
            // Giriş başarılı
            openCustomerDashboardScreen();
        } else {
            // Giriş başarısız
            JOptionPane.showMessageDialog(this, "Geçersiz TC Numarası veya Şifre", "Hata", JOptionPane.ERROR_MESSAGE);
            // Hatalı giriş durumunda şifre alanını temizle
            passwordField.setText("");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomerLoginScreen());
    }
}
