import javax.swing.*;

public class DepositScreen extends TransactionScreen implements TransactionHandler{
    private JLabel balanceLabel;
    protected Customer getLoggedInCustomer() {
        // Burada giriş yapmış müşteriyi döndür
        // Örneğin: Customer loggedInCustomer = CustomerDatabase.getCustomerByTcNumber("12345678901");
        // return loggedInCustomer;

        // Yukarıdaki örnekte giriş yapmış müşteriyi TC numarasına göre alıyoruz.
        // Gerçek uygulamada kullanıcı girişine göre bu kısmı ayarlamanız gerekecek.
        return CustomerDatabase.getCustomerByTcNumber("12345678901");
    }


    public DepositScreen() {
        super("Para Yatırma Ekranı");
        balanceLabel = new JLabel("Bakiye: " + getLoggedInCustomer().getMoney() + " TL");
        add(balanceLabel);
    }

    @Override
	public void handleTransactionButtonClick(String depositAmount) {
        // Para yatırma işlemlerini gerçekleştir
        try {
            double amount = Double.parseDouble(depositAmount);
            if (amount > 0) {
                // Para yatırma işlemleri burada gerçekleştirilebilir.
                getLoggedInCustomer().setMoney(getLoggedInCustomer().getMoney() + amount);

                // Bakiye etiketini güncelle
                updateBalanceLabel();
                dispose();
                JOptionPane.showMessageDialog(this, "Para Yatırma İşlemi Başarılı", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Geçersiz miktar. Lütfen pozitif bir miktar girin.", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Geçersiz miktar formatı. Lütfen sayısal bir değer girin.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void updateBalanceLabel() {
        // Bakiye etiketini güncelle
        balanceLabel.setText("Bakiye: " + getLoggedInCustomer().getMoney() + " TL");
    }

    @Override
	public String getTransactionLabel() {
        return "Yatırılacak Miktar:";
    }

    @Override
	public String getTransactionButtonLabel() {
        return "Para Yatır";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DepositScreen());
    }
}
