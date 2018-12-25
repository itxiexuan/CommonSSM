package com.itxxx.dao;

import com.itxxx.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId = #{orderId})")
    List<Traveller> findById(String orderId);
}
