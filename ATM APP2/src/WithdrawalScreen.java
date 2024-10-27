import javax.swing.*;

public class WithdrawalScreen extends TransactionScreen implements TransactionHandler {
    private JLabel balanceLabel;

    public WithdrawalScreen() {
        super("Para Çekme Ekranı");
        add(createBalanceLabel());
    }

    private JLabel createBalanceLabel() {
        balanceLabel = new JLabel("Bakiye: " + getLoggedInCustomer().getMoney() + " TL");
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        return balanceLabel;
    }

    protected Customer getLoggedInCustomer() {
        // Burada giriş yapmış müşteriyi döndür
        // Örneğin: Customer loggedInCustomer = CustomerDatabase.getCustomerByTcNumber("12345678901");
        // return loggedInCustomer;

        // Yukarıdaki örnekte giriş yapmış müşteriyi TC numarasına göre alıyoruz.
        // Gerçek uygulamada kullanıcı girişine göre bu kısmı ayarlamanız gerekecek.
        return CustomerDatabase.getCustomerByTcNumber("12345678901");
    }

    @Override
    public void handleTransactionButtonClick(String withdrawalAmount) {
        // Para çekme işlemlerini gerçekleştir
        try {
            double amount = Double.parseDouble(withdrawalAmount);
            if (amount > 0) {
                double currentBalance = getLoggedInCustomer().getMoney();

                if (amount <= currentBalance) {
                    // Müşterinin mevcut parasından çekme işlemi
                    getLoggedInCustomer().setMoney(currentBalance - amount);

                    dispose();
                    // Para çekme işlemleri burada gerçekleştirilebilir.
                    JOptionPane.showMessageDialog(this, "Para Çekme İşlemi Başarılı", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Yetersiz bakiye. Çekilecek miktar mevcut bakiyeden fazla.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Geçersiz miktar. Lütfen pozitif bir miktar girin.", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Geçersiz miktar formatı. Lütfen sayısal bir değer girin.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public String getTransactionLabel() {
        return "Çekilecek Miktar:";
    }

    @Override
    public String getTransactionButtonLabel() {
        return "Para Çek";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WithdrawalScreen());
    }
}
