package com.itxxx.service;

import com.itxxx.domain.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findAll() throws Exception;
    List<Orders> findByPage(Integer page,Integer size) throws Exception;
    Orders findById(String id);
}
