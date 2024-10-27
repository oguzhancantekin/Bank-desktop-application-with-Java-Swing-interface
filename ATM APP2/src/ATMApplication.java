import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMApplication extends JFrame {

    public ATMApplication() {
        super("ATM Uygulaması");
        setTitle("CNTKNBANK");
        getContentPane().setLayout(new GridLayout(3, 1));

        JButton customerLoginButton = createStyledButton("Müşteri Girişi");
        customerLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomerLoginScreen();
            }
        });
        getContentPane().add(customerLoginButton);

        JButton customerRegisterButton = createStyledButton("Müşteri Kayıt");
        customerRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomerRegisterScreen();
            }
        });
        getContentPane().add(customerRegisterButton);

        JButton bankEmployeeLoginButton = createStyledButton("Banka Personeli Girişi");
        bankEmployeeLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openBankEmployeeLoginScreen();
            }
        });
        getContentPane().add(bankEmployeeLoginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(599, 391);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(50, 150, 200)); // Özel renk ayarı
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false); // Kenarlık çizgilerini kapat
        button.setBorder(BorderFactory.createLineBorder(new Color(30, 100, 150), 2)); // Kenarlık rengi ve kalınlığı
        return button;
    }

    private void openWithdrawalScreen() {
        SwingUtilities.invokeLater(() -> new WithdrawalScreen());
    }

    private void handleWithdrawButtonClick() {
        openWithdrawalScreen();
    }

    private void openCustomerDashboardScreen() {
        SwingUtilities.invokeLater(() -> new CustomerDashboardScreen());
    }

    private void handleCustomerLoginButtonClick() {
        openCustomerDashboardScreen();
    }

    private void openCustomerLoginScreen() {
        SwingUtilities.invokeLater(() -> new CustomerLoginScreen());
    }

    private void openCustomerRegisterScreen() {
        SwingUtilities.invokeLater(() -> new CustomerRegisterScreen());
    }

    private void openBankEmployeeLoginScreen() {
        SwingUtilities.invokeLater(() -> new BankEmployeeLoginScreen());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATMApplication();
            }
        });
    }
}
