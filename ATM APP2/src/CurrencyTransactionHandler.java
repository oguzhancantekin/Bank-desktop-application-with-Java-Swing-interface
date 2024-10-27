public interface CurrencyTransactionHandler {
    void handleTransaction(String selectedCurrency, String transactionAmount);
    String getTransactionType();
}
