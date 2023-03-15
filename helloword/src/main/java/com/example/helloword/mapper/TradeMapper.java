package com.example.helloword.mapper;

import com.example.helloword.entity.Trade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TradeMapper {
    String TABLE_NAME="trade";

    @Select("select * from "+TABLE_NAME+" where uid=#{uid}")
    List<Trade> queryTradeByUid(int uid);
}
