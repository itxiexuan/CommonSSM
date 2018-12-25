package com.itxxx.service.impl;

import com.github.pagehelper.PageHelper;
import com.itxxx.dao.OrdersDao;
import com.itxxx.domain.Orders;
import com.itxxx.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Orders> findAll() throws Exception {
        List<Orders> list = ordersDao.findAll();
        return list;
    }

    @Override
    public List<Orders> findByPage(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<Orders> list = ordersDao.findByPage();
        return list;
    }

    @Override
    public Orders findById(String id) {
        Orders orders = ordersDao.findById(id);
        return orders;
    }
}
