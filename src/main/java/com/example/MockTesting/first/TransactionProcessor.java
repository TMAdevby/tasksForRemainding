package com.example.MockTesting.first;

public class TransactionProcessor {

    private final BalanceService balanceService;
    private final NotificationService notificationService;

    public TransactionProcessor(BalanceService balanceService, NotificationService notificationService) {
        this.balanceService = balanceService;
        this.notificationService = notificationService;
    }

    public void processTransaction(String accountId, Transaction transaction) {
        if (transaction.getType() == TransactionType.WITHDRAWAL) {
            boolean hasFunds = balanceService.hasSufficientFunds(accountId, transaction.getAmount());
            if (!hasFunds) {
                throw new RuntimeException("Недостаточно средств на счете");
            }
            notificationService.sendNotification(accountId, "Снятие средств успешно выполнено");
        } else if (transaction.getType() == TransactionType.DEPOSIT) {
            notificationService.sendNotification(accountId, "Счет успешно пополнен");
        }
    }
}
