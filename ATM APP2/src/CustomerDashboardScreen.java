import javax.swing.*;
import java.awt.*;

public class CustomerDashboardScreen extends JFrame {
    private JButton checkBalanceButton;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton transferButton;
    private JButton buyCurrencyButton;
    private JButton sellCurrencyButton;

    public CustomerDashboardScreen() {
        super("Müşteri Hesap Ekranı");
        getContentPane().setBackground(new Color(240, 240, 240)); // Arka plan rengi
        setLayout(new GridLayout(3, 2));

        checkBalanceButton = createStyledButton("Bakiye Öğrenme");
        checkBalanceButton.addActionListener(e -> handleCheckBalanceButtonClick());
        add(checkBalanceButton);

        withdrawButton = createStyledButton("Para Çekme");
        withdrawButton.addActionListener(e -> handleWithdrawButtonClick());
        add(withdrawButton);

        depositButton = createStyledButton("Para Yatırma");
        depositButton.addActionListener(e -> handleDepositButtonClick());
        add(depositButton);

        transferButton = createStyledButton("Para Transferi");
        transferButton.addActionListener(e -> handleTransferButtonClick());
        add(transferButton);

        buyCurrencyButton = createStyledButton("Döviz Alış");
        buyCurrencyButton.addActionListener(e -> handleBuyCurrencyButtonClick());
        add(buyCurrencyButton);

        sellCurrencyButton = createStyledButton("Döviz Satış");
        sellCurrencyButton.addActionListener(e -> handleSellCurrencyButtonClick());
        add(sellCurrencyButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(50, 120, 200)); // Buton arka plan rengi
        button.setForeground(Color.WHITE); // Buton metin rengi
        button.setFocusPainted(false); // Kenarlık çizgisini kaldır
        button.setBorder(BorderFactory.createLineBorder(new Color(30, 60, 150), 2)); // Kenarlık rengi ve kalınlığı
        return button;
    }

    private void handleCheckBalanceButtonClick() {
        SwingUtilities.invokeLater(() -> new BalanceInquiryScreen());
    }

    private void handleWithdrawButtonClick() {
        SwingUtilities.invokeLater(() -> new WithdrawalScreen());
    }

    private void handleDepositButtonClick() {
        SwingUtilities.invokeLater(() -> new DepositScreen());
    }

    private void handleTransferButtonClick() {
        SwingUtilities.invokeLater(() -> new TransferScreen());
    }

    private void handleBuyCurrencyButtonClick() {
        SwingUtilities.invokeLater(() -> new BuyCurrencyScreen());
    }

    private void handleSellCurrencyButtonClick() {
        SwingUtilities.invokeLater(() -> new SellCurrencyScreen());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CustomerDashboardScreen::new);
    }
}
