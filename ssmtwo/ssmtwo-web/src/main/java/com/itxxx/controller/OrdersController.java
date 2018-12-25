package com.itxxx.controller;

import com.github.pagehelper.PageInfo;
import com.itxxx.domain.Orders;
import com.itxxx.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
//    @Autowired
//    private OrdersService os;
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        List<Orders> lis = os.findAll();
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("ordersList",lis);
//        mv.setViewName("orders-list");
//        return mv;
//    }
    @Autowired
    private OrdersService os;
    @RequestMapping("/findAll.do")
    public ModelAndView findByPage(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page
            , @RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception {
        List<Orders> lis = os.findByPage(page,size);
        PageInfo pageInfo = new PageInfo(lis);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id){
        ModelAndView mv = new ModelAndView();
        Orders orders = os.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
