import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class BuyCurrencyScreen extends AbstractCurrencyScreen {
    public BuyCurrencyScreen() {
        super("Döviz Alış Ekranı", "Döviz Al");
    }

    @Override
    protected void handleActionButtonClick(String selectedCurrency, String buyAmount) {
        // Döviz alış işlemlerini gerçekleştir
        try {
            JOptionPane.showMessageDialog(this, "Döviz Fiyatlarının hızlı değişimi sebebiyle kısa süreli olarak Alım-Satım yapılmamaktadır", "HATA", JOptionPane.ERROR_MESSAGE);
             } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Döviz alış işlemi sırasında bir hata oluştu.", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BuyCurrencyScreen());
    }
}