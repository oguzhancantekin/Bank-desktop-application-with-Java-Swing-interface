import javax.swing.*;
import java.awt.*;

public class TransferScreen extends JFrame {
    private JLabel tcNumberLabel;
    private JLabel transferAmountLabel;
    private JButton transferButton;
    private JButton backButton;

    public TransferScreen() {
        super("Para Transferi Ekranı");
        setLayout(new GridLayout(4, 2));

        tcNumberLabel = new JLabel("Hedef TC Numarası:");
        add(tcNumberLabel);

        JTextField tcNumberField = new JTextField();
        add(tcNumberField);

        transferAmountLabel = new JLabel("Transfer Tutarı:");
        add(transferAmountLabel);

        JTextField transferAmountField = new JTextField();
        add(transferAmountField);

        transferButton = new JButton("Para Transfer Et");
        transferButton.addActionListener(e -> handleTransferButtonClick(tcNumberField.getText(), transferAmountField.getText()));
        add(transferButton);

        backButton = new JButton("Geri Dön");
        backButton.addActionListener(e -> handleBackButtonClick());
        add(backButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleTransferButtonClick(String targetTcNumber, String transferAmount) {
        try {
            // Transfer işlemleri
            Customer loggedInCustomer = getLoggedInCustomer();
            double amount = Double.parseDouble(transferAmount);

         // TC Numarası doğrulama
            if (targetTcNumber.length() != 11) {
                JOptionPane.showMessageDialog(this, "TC Numarası 11 haneli olmalıdır", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Bakiyeden çıkarma
            if (loggedInCustomer.getMoney() >= amount) {
                loggedInCustomer.setMoney(loggedInCustomer.getMoney() - amount);

                // Hedef hesaba ekleme
                Customer targetCustomer = CustomerDatabase.getCustomerByTcNumber(targetTcNumber);
                if (targetCustomer != null) {
                    targetCustomer.setMoney(targetCustomer.getMoney() + amount);

                    JOptionPane.showMessageDialog(this, "Para Transferi Başarılı", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Hedef hesap bulunamadı
                    JOptionPane.showMessageDialog(this, "Hedef TC numarasına sahip hesap bulunamadı.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Yetersiz bakiye
                JOptionPane.showMessageDialog(this, "Yetersiz bakiye.", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Geçersiz miktar formatı. Lütfen sayısal bir değer girin.", "Hata", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Transfer işlemi sırasında bir hata oluştu.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleBackButtonClick() {
        // Geri dön butonuna tıklandığında bu ekranı kapat
        dispose();
    }

    private Customer getLoggedInCustomer() {
        // Giriş yapmış müşteriyi döndür
        // Bu kısmı uygulamaya göre düzenlemeniz gerekecek
        return CustomerDatabase.getCustomerByTcNumber("12345678901");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TransferScreen());
    }
}
