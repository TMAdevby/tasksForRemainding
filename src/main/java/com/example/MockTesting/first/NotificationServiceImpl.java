package com.example.MockTesting.first;

public class NotificationServiceImpl implements NotificationService{
    @Override
    public void sendNotification(String accountId, String message) {
        System.out.println(message);
    }
}
