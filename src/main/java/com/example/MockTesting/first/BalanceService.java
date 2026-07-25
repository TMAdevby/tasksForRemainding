package com.example.MockTesting.first;

public interface BalanceService {
    // Возвращает true, если на счете достаточно средств для снятия суммы amount
    boolean hasSufficientFunds(String accountId, double amount);
}
