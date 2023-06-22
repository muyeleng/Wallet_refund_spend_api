package com.it.controller;

import com.it.pojo.Client;
import com.it.pojo.Log;
import com.it.pojo.Refund;
import com.it.pojo.Result;
import com.it.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/wallet")
public class WalletControll {
    @Autowired
private WalletService walletService;
  /*  @PutMapping("/{name},{refund}")
    public Result WallerRefund( @PathVariable String name,@PathVariable  BigDecimal refund){*/
//  记录用户退费
  @PostMapping("/refund")
  public Result WallerRefund(@RequestBody Client client){
    log.info("用户:{}",client);
    walletService.refund(client);
    return Result.success();
    }
//    记录用户花费
    @PostMapping("/spend")
  public Result WalletSpend(@RequestBody Client client){
    log.info("用户:{}",client);
    walletService.spend(client);
    return Result.success();
    }
//    查询钱包明细
    @GetMapping
  public  Result Wallet(){
    List<Log> logList =walletService.quary();
    return Result.success(logList);
    }

}
