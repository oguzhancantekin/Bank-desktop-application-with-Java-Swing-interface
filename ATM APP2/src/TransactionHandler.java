public interface TransactionHandler {
    public void handleTransactionButtonClick(String transactionAmount);
    public String getTransactionLabel();
    public String getTransactionButtonLabel();
}