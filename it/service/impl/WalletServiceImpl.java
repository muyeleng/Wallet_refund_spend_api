package com.it.service.impl;

import com.it.mapper.WalletMapper;
import com.it.pojo.Client;
import com.it.pojo.Log;
import com.it.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletMapper walletMapper;
//    @Override
//    public void refund(String name, BigDecimal refund) {
//        walletMapper.add(name,refund);
//        walletMapper.log(name,refund);
//
//
//    }

    @Override
    public void refund(Client client) {
        client.setUpdateTime(LocalDateTime.now());
        walletMapper.add(client);
        walletMapper.log(client);
    }

    @Override
    public void spend(Client client) {
        client.setUpdateTime(LocalDateTime.now());
        walletMapper.reduce(client);
        walletMapper.logReduce(client);
    }

    @Override
    public List<Log> quary() {
        List<Log> logList =walletMapper.quary();
        return  logList;
    }
}
