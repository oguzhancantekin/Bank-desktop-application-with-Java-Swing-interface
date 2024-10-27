import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
public class SellCurrencyScreen extends AbstractCurrencyScreen implements CurrencyTransactionHandler {
    public SellCurrencyScreen() {
        super("Döviz Satış Ekranı", "Döviz Sat");
    }

    @Override
    protected void handleActionButtonClick(String selectedCurrency, String sellAmount) {
        // Döviz satış işlemlerini gerçekleştir
        try {
            JOptionPane.showMessageDialog(this, "Döviz Fiyatlarının hızlı değişimi sebebiyle kısa süreli olarak Alım-Satım yapılmamaktadır", "HATA", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Döviz satış işlemi sırasında bir hata oluştu.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SellCurrencyScreen());
    }

	@Override
	public void handleTransaction(String selectedCurrency, String transactionAmount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTransactionType() {
		// TODO Auto-generated method stub
		return null;
	}
}