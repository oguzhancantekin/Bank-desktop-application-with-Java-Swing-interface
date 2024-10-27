import javax.swing.*;
import java.awt.*;

public class BalanceInquiryScreen extends JFrame {
    private JLabel balanceLabel;
    private JButton backButton;

    public BalanceInquiryScreen() {
        super("Bakiye Öğrenme Ekranı");
        getContentPane().setBackground(new Color(240, 248, 255)); // Arka plan rengi
        setLayout(new GridLayout(2, 1));

        balanceLabel = new JLabel("Bakiye: " + getCustomerBalance());
        balanceLabel.setForeground(new Color(0, 128, 128)); // Metin rengi
        add(balanceLabel);

        backButton = new JButton("Geri Dön");
        backButton.setBackground(new Color(59, 89, 182)); // Buton arka plan rengi
        backButton.setForeground(Color.WHITE); // Buton metin rengi
        backButton.setFocusPainted(false); // Buton kenarlığı etkisini kaldır
        backButton.addActionListener(e -> handleBackButtonClick());
        add(backButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private double getCustomerBalance() {
        // Giriş yapmış müşterinin bakiyesini al
        Customer loggedInCustomer = getLoggedInCustomer(); // Bu metodun içine giriş yapmış müşteriyi döndürecek kodu eklemelisiniz.
        if (loggedInCustomer != null) {
            return loggedInCustomer.getMoney(); // Başlangıç bakiyesini eklememize gerek yok
        } else {
            return 0.0; // Giriş yapmış müşteri yoksa varsayılan olarak 0.0 döndürüyoruz.
        }
    }

    private void handleBackButtonClick() {
        // Geri dön butonuna tıklandığında bu ekranı kapat
        dispose();
    }

    private Customer getLoggedInCustomer() {
        // Örneğin, bir kullanıcı oturumu yönetim sisteminiz varsa,
        // bu sistem üzerinden giriş yapmış müşteriyi alabilirsiniz.
        // Bu örnekte sabit bir müşteri kullanıyorum, gerçek uygulamada
        // müşteri oturum yönetim sistemini kullanmalısınız.
        
        String loggedInCustomerTcNumber = "12345678901"; // Örneğin giriş yapmış müşterinin TC numarası
        return CustomerDatabase.getCustomerByTcNumber(loggedInCustomerTcNumber);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BalanceInquiryScreen());
    }
}
