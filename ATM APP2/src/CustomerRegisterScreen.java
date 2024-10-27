import javax.swing.*;
import java.awt.*;

public class CustomerRegisterScreen extends JFrame {
    private JTextField tcField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;

    public CustomerRegisterScreen() {
        super("Müşteri Kayıt Ekranı");
        getContentPane().setBackground(new Color(240, 248, 255)); // Arka plan rengi
        setLayout(new GridLayout(5, 2));

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

        JLabel confirmPasswordLabel = new JLabel("Şifreyi Onayla:");
        confirmPasswordLabel.setForeground(new Color(0, 128, 128)); // Metin rengi
        add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);

        registerButton = new JButton("Kayıt Ol");
        registerButton.setBackground(new Color(59, 89, 182)); // Buton arka plan rengi
        registerButton.setForeground(Color.WHITE); // Buton metin rengi
        registerButton.setFocusPainted(false); // Kenarlık çizgisini kaldır
        registerButton.addActionListener(e -> handleRegisterButtonClick());
        add(registerButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleRegisterButtonClick() {
        String tcNumber = tcField.getText();
        char[] passwordChars = passwordField.getPassword();
        char[] confirmPasswordChars = confirmPasswordField.getPassword();

     // TC Numarası doğrulama
        if (tcNumber.length() != 11) {
            JOptionPane.showMessageDialog(this, "TC Numarası 11 haneli olmalıdır", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String password = new String(passwordChars);
        String confirmPassword = new String(confirmPasswordChars);

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Şifreler uyuşmuyor. Lütfen tekrar deneyin.", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // CustomerDatabase'e kullanıcıyı ekle
        CustomerDatabase.addCustomer(tcNumber, password);

        System.out.println("Kullanıcı Kayıt: TC Numarası - " + tcNumber + ", Şifre - " + password);
        JOptionPane.showMessageDialog(this, tcNumber+ " TC nolu kişinin kayıt işlemi başarıyla tamamlandı.", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
        // Burada kayıt işlemleri gerçekleştirilebilir.

        // Pencereyi kapat
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomerRegisterScreen());
    }
}
