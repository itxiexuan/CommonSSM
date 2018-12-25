package com.itxxx.controller;

import com.itxxx.domain.SysLog;
import com.itxxx.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService service;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<SysLog> list = service.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("sysLogs",list);
        mv.setViewName("syslog-list");
        return mv;
    }
}
