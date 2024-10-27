import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerManagementScreen extends JFrame {
    private JButton addCustomerButton;
    private JButton updateCustomerButton;
    private JButton deleteCustomerButton;
    private JButton backButton;

    public CustomerManagementScreen() {
        super("Müşteri İşlemleri Ekranı");
        setLayout(new GridLayout(4, 1));

        updateCustomerButton = new JButton("Müşteri Güncelle");
        updateCustomerButton.addActionListener(e -> handleUpdateCustomerButtonClick());
        add(updateCustomerButton);

        backButton = new JButton("Geri Dön");
        backButton.addActionListener(e -> handleBackButtonClick());
        add(backButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

  

    private void handleUpdateCustomerButtonClick() {
        // Müşteri güncelleme ekranını aç
        // Örnek: new UpdateCustomerScreen();
    	 SwingUtilities.invokeLater(() -> new UpdateCustomerScreen());
	 }

    private void handleBackButtonClick() {
        // Geri dön
        dispose();
        System.out.println("Geri Dönüldü");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomerManagementScreen());
    }
}
