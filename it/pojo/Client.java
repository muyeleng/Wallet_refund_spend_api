package com.it.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private  Integer id;
    private  String name;
    private  BigDecimal refund;
    private  BigDecimal spend;
    private BigDecimal balance;
    private LocalDateTime crateTime;
    private LocalDateTime updateTime;
}
