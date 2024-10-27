import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCustomerScreen extends JFrame {
    private JTextField tcField;
    private JPasswordField newPasswordField;
    private JButton updateButton;
    private JButton backButton;

    public UpdateCustomerScreen() {
        super("Müşteri Güncelleme Ekranı");
        setLayout(new GridLayout(4, 1));

        JLabel tcLabel = new JLabel("TC Numarası:");
        add(tcLabel);

        tcField = new JTextField();
        add(tcField);

        JLabel newPasswordLabel = new JLabel("Yeni Şifre:");
        add(newPasswordLabel);

        newPasswordField = new JPasswordField();
        add(newPasswordField);

        updateButton = new JButton("Güncelle");
        updateButton.addActionListener(e -> handleUpdateButtonClick());
        add(updateButton);

        backButton = new JButton("Geri Dön");
        backButton.addActionListener(e -> handleBackButtonClick());
        add(backButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleUpdateButtonClick() {
        String tcNumber = tcField.getText();
        char[] newPasswordChars = newPasswordField.getPassword();
        String newPassword = new String(newPasswordChars);

        // TC numarasına göre müşteriyi güncelle
        Customer customer = CustomerDatabase.getCustomerByTcNumber(tcNumber);
        if (customer != null) {
            customer.setPassword(newPassword);
            System.out.println("Müşteri Güncellendi: TC Numarası - " + tcNumber + ", Yeni Şifre - " + newPassword);
        } else {
            System.out.println("Müşteri bulunamadı.");
        }

        // Burada güncelleme işlemleri gerçekleştirilebilir.

        // Pencereyi kapat
        dispose();
    }

    private void handleBackButtonClick() {
        // Geri dön
        dispose();
        System.out.println("Geri Dönüldü");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UpdateCustomerScreen());
    }
}
