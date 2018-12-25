package com.itxxx.controller;

import com.itxxx.domain.Product;
import com.itxxx.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService ps;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> list = ps.findAll();
        mv.addObject("productList",list);
        mv.setViewName("product-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String saveProduct(Product product){
        ps.saveProduct(product);
        return "redirect:findAll.do";
    }
}
