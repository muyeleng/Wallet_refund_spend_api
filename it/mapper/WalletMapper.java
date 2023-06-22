package com.it.mapper;

import com.it.pojo.Client;
import com.it.pojo.Log;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WalletMapper {
    /* @Update("update client set balance = balance + #{refund} where name = #{name}")
     void add(String name, BigDecimal refund);
     @Insert("insert into log (name,refund,balance) values (#{name},#{refund},balance - #{refund})")
     void log(String name, BigDecimal refund);*/
    @Update("update client set balance = balance + #{refund}, update_time = #{updateTime} where name = #{name}")
    void add(Client client);

    //    @Insert("insert into log (name,refund) values (#{name},#{add})")
    void log(Client client);

    @Update("update client set balance = balance - #{spend}, update_time = #{updateTime} where name = #{name}")
    void logReduce(Client client);

    void reduce(Client client);
    @Select("select * from log")
    List<Log> quary();
}
