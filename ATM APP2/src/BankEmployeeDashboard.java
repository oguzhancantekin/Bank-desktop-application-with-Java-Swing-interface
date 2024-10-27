import javax.swing.*;
import java.awt.*;

public class BankEmployeeDashboard extends JFrame {
    private JButton customerManagementButton;
    private JButton transactionHistoryButton;
    private JButton logoutButton;

    public BankEmployeeDashboard() {
        super("Banka Personeli Kontrol Paneli");
        getContentPane().setBackground(new Color(240, 248, 255)); // Arka plan rengi
        setLayout(new GridLayout(3, 1));

        customerManagementButton = new JButton("Müşteri Yönetimi");
        customerManagementButton.setBackground(new Color(59, 89, 182)); // Buton arka plan rengi
        customerManagementButton.setForeground(Color.WHITE); // Buton metin rengi
        customerManagementButton.setFocusPainted(false); // Buton kenarlığı etkisini kaldır
        customerManagementButton.addActionListener(e -> handleCustomerManagementButtonClick());
        add(customerManagementButton);

        transactionHistoryButton = new JButton("İşlem Geçmişi");
        transactionHistoryButton.setBackground(new Color(59, 89, 182)); // Buton arka plan rengi
        transactionHistoryButton.setForeground(Color.WHITE); // Buton metin rengi
        transactionHistoryButton.setFocusPainted(false); // Buton kenarlığı etkisini kaldır
        transactionHistoryButton.addActionListener(e -> handleTransactionHistoryButtonClick());
        add(transactionHistoryButton);

        logoutButton = new JButton("Çıkış Yap");
        logoutButton.setBackground(new Color(59, 89, 182)); // Buton arka plan rengi
        logoutButton.setForeground(Color.WHITE); // Buton metin rengi
        logoutButton.setFocusPainted(false); // Buton kenarlığı etkisini kaldır
        logoutButton.addActionListener(e -> handleLogoutButtonClick());
        add(logoutButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleCustomerManagementButtonClick() {
        // Müşteri yönetimi ekranını aç
        // Örnek: new CustomerManagementScreen();
        SwingUtilities.invokeLater(() -> new CustomerManagementScreen());
    }

    private void handleTransactionHistoryButtonClick() {
        // İşlem geçmişi ekranını aç
        // Örnek: new TransactionHistoryScreen();
        System.out.println("İşlem Geçmişi Ekranı Açıldı");
    }

    private void handleLogoutButtonClick() {
        // Çıkış yap
        dispose();
        System.out.println("Çıkış Yapıldı");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankEmployeeDashboard());
    }
}
