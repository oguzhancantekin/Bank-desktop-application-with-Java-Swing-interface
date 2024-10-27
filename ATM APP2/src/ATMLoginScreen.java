import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMLoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public ATMLoginScreen() {
        // JFrame ve layout ayarları
        super("ATM Giriş Ekranı");
        getContentPane().setBackground(new Color(240, 248, 255)); // Arka plan rengi
        setLayout(new GridLayout(3, 2));

        // Kullanıcı Adı etiketi ve alanı
        JLabel usernameLabel = new JLabel("Kullanıcı Adı:");
        usernameLabel.setForeground(new Color(0, 128, 128)); // Metin rengi
        add(usernameLabel);

        usernameField = new JTextField();
        add(usernameField);

        // Parola etiketi ve alanı
        JLabel passwordLabel = new JLabel("Parola:");
        passwordLabel.setForeground(new Color(0, 128, 128)); // Metin rengi
        add(passwordLabel);

        passwordField = new JPasswordField();
        add(passwordField);

        // Giriş Butonu
        JButton loginButton = new JButton("Giriş Yap");
        loginButton.setBackground(new Color(59, 89, 182)); // Buton arka plan rengi
        loginButton.setForeground(Color.WHITE); // Buton metin rengi
        loginButton.setFocusPainted(false); // Buton kenarlığı etkisini kaldır
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Giriş butonuna tıklandığında yapılacak işlemler
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Burada giriş bilgilerini kontrol edebilir ve işlemleri gerçekleştirebilirsiniz.
                // Örneğin, kullanıcı adı ve şifre doğruysa ana pencereyi açabilirsiniz.
                // Şu an sadece basit bir çıktı alıyoruz.
                System.out.println("Kullanıcı Adı: " + username);
                System.out.println("Parola: " + password);
            }
        });
        add(loginButton);

        // Ekran ayarları
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); // Pencereyi ekranın ortasına yerleştir
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATMLoginScreen();
            }
        });
    }
}
