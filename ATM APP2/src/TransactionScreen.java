import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// Soyut sınıf
public abstract class TransactionScreen extends JFrame {
    private JLabel amountLabel;
    private JButton backButton;
    protected abstract Customer getLoggedInCustomer();

    // Soyut metot, alt sınıflarda implemente edilecektir.
    protected abstract void handleTransactionButtonClick(String transactionAmount);

    // Constructor
    public TransactionScreen(String title) {
        super(title);
        setLayout(new GridLayout(3, 2));

        amountLabel = new JLabel(getTransactionLabel());
        add(amountLabel);

        JTextField transactionAmountField = new JTextField();
        add(transactionAmountField);

        JButton transactionButton = new JButton(getTransactionButtonLabel());
        transactionButton.addActionListener(e -> handleTransactionButtonClick(transactionAmountField.getText()));
        add(transactionButton);

        backButton = new JButton("Geri Dön");
        backButton.addActionListener(e -> handleBackButtonClick());
        add(backButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Soyut metot, alt sınıflarda implemente edilecektir.
    protected abstract String getTransactionLabel();

    // Soyut metot, alt sınıflarda implemente edilecektir.
    protected abstract String getTransactionButtonLabel();

    private void handleBackButtonClick() {
        // Geri dön butonuna tıklandığında bu ekranı kapat
        dispose();
    }

    public static void main(String[] args) {
        // Burada bir şey yapmanıza gerek yok, alt sınıflar kullanılacaktır.
    }
}
