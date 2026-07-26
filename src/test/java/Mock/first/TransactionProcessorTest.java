package com.example.MockTesting.first;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionProcessorTest {

    @Mock
    private BalanceService balanceService;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private TransactionProcessor transactionProcessor;

    @Test
    @DisplayName("Снятие успешно")
    void testProcessTransaction_Withdrawal_Success() {
        // Given
        String accountId = "22222";
        double amount = 100.0;
        when(balanceService.hasSufficientFunds(accountId, amount)).thenReturn(true);

        // When
        transactionProcessor.processTransaction(accountId, new Transaction(amount, TransactionType.WITHDRAWAL));

        // Then
        verify(notificationService, times(1)).sendNotification(accountId, "Снятие средств успешно выполнено");
    }

    @Test
    @DisplayName("Снятие неудачно")
    void testProcessTransaction_Withdrawal_InsufficientFunds() {
        // Given
        String accountId = "11111";
        double amount = 11000.0;
        when(balanceService.hasSufficientFunds(accountId, amount)).thenReturn(false);

        // When & Then
        assertThrows(RuntimeException.class, () ->
                transactionProcessor.processTransaction(accountId, new Transaction(amount, TransactionType.WITHDRAWAL))
        );

        verify(notificationService, never()).sendNotification(anyString(), anyString());
    }

    @Test
    @DisplayName("Успешное пополнение")
    void testProcessTransaction_Deposit_Success() {
        // Given
        String accountId = "11111";
        double amount = 11000.0;

        // When
        transactionProcessor.processTransaction(accountId, new Transaction(amount, TransactionType.DEPOSIT));

        // Then
        verify(notificationService, times(1)).sendNotification(accountId, "Счет успешно пополнен");
        verify(balanceService, never()).hasSufficientFunds(anyString(), anyDouble());
    }
}
