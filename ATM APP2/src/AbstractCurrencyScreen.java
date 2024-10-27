import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// AbstractCurrencyScreen adında soyut bir sınıf oluşturduk.
// Ortak özellikleri ve davranışları burada tanımlayabiliriz.
public abstract class AbstractCurrencyScreen extends JFrame {
    protected JLabel currencyLabel;
    protected JLabel amountLabel;
    protected JButton actionButton;
    protected JButton backButton;
    protected JComboBox<String> currencyComboBox;

    public AbstractCurrencyScreen(String title, String actionButtonText) {
        super(title);
        getContentPane().setBackground(new Color(240, 248, 255)); // Arka plan rengi
        setLayout(new GridLayout(4, 2));

        currencyLabel = new JLabel("Döviz Türü:");
        currencyLabel.setForeground(new Color(0, 128, 128)); // Metin rengi
        add(currencyLabel);

        String[] currencies = {"Amerikan Doları - USD", "Euro - EUR", "İngiliz Sterlini (Pound) - GBP", "Japon Yeni - JPY", "Kanada Doları - CAD"};
        currencyComboBox = new JComboBox<>(currencies);
        add(currencyComboBox);

        amountLabel = new JLabel("İşlem Tutarı:");
        amountLabel.setForeground(new Color(0, 128, 128)); // Metin rengi
        add(amountLabel);

        JTextField amountField = new JTextField();
        add(amountField);

        actionButton = new JButton(actionButtonText);
        actionButton.setBackground(new Color(59, 89, 182)); // Buton arka plan rengi
        actionButton.setForeground(Color.WHITE); // Buton metin rengi
        actionButton.setFocusPainted(false); // Buton kenarlığı etkisini kaldır
        // Soyut sınıfta bir action listener belirleyebiliriz, alt sınıflarda bu metodu implemente ederiz.
        actionButton.addActionListener((ActionEvent e) -> handleActionButtonClick((String) currencyComboBox.getSelectedItem(), amountField.getText()));
        add(actionButton);

        backButton = new JButton("Geri Dön");
        backButton.setBackground(new Color(59, 89, 182)); // Buton arka plan rengi
        backButton.setForeground(Color.WHITE); // Buton metin rengi
        backButton.setFocusPainted(false); // Buton kenarlığı etkisini kaldır
        backButton.addActionListener(e -> handleBackButtonClick());
        add(backButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Soyut metodlar, alt sınıflar tarafından implemente edilecek.
    protected abstract void handleActionButtonClick(String selectedCurrency, String transactionAmount);

    protected void handleBackButtonClick() {
        dispose();
    }

    // Ana metot, buradan alt sınıfların nesnelerini oluşturabiliriz.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BuyCurrencyScreen());
    }
}