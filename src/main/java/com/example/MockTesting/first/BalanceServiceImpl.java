package com.example.MockTesting.first;

import java.util.HashMap;
import java.util.Map;

public class BalanceServiceImpl implements BalanceService {

    Map<String, Double> map = new HashMap<>();

    public BalanceServiceImpl(Map<String, Double> map) {
        this.map = map;
        map.put("11111",10000.00);
        map.put("22222",5000.00);
        map.put("33333",3000.00);
    }


    @Override
    public boolean hasSufficientFunds(String accountId, double amount) {
        if(map.containsKey(accountId)){
            return true;
        }else {
            return false;
        }
    }
}
