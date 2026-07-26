package Mock.first;

import com.example.MockTesting.first.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.BaseStubbing;

public class TransactionProcessorTest {

        @Test
        @DisplayName("Снятие успешно")
        public void testProcessTransaction_Withdrawal_Success() {
            BalanceService balanceService = Mockito.mock(BalanceService.class);
            NotificationService notificationService = Mockito.mock(NotificationService.class);

            TransactionProcessor transactionProcessor = new TransactionProcessor(balanceService,notificationService);

            String accountId = "22222";
            double amount = 100.0;

            Mockito.when(balanceService.hasSufficientFunds(accountId, amount))
                    .thenReturn(true);

            transactionProcessor.processTransaction(accountId,new Transaction(amount, TransactionType.WITHDRAWAL));

            Mockito.verify(notificationService,Mockito.times(1))
                    .sendNotification("22222","Снятие средств успешно выполнено");
        }

    @Test
    @DisplayName("Снятие неудачно")
    public void testProcessTransaction_Withdrawal_InsufficientFunds() {
        BalanceService balanceService = Mockito.mock(BalanceService.class);
        NotificationService notificationService = Mockito.mock(NotificationService.class);

        TransactionProcessor transactionProcessor = new TransactionProcessor(balanceService,notificationService);

        String accountId = "11111";
        double amount = 11000.0;

        Mockito.when(balanceService.hasSufficientFunds(accountId, amount))
                .thenReturn(false);

        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class,
                () -> { transactionProcessor.processTransaction(accountId, new Transaction(amount, TransactionType.WITHDRAWAL));});

        Mockito.verify(notificationService,Mockito.never())
                .sendNotification(accountId, "Снятие средств успешно выполнено");
    }
}
