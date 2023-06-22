package com.it.service;

import com.it.pojo.Client;
import com.it.pojo.Log;

import java.util.List;

public interface WalletService {
//    void refund(String name, BigDecimal refund);

    void refund(Client client);

    void spend(Client client);

    List<Log> quary();
}
