package com.itxxx.controller;

import com.itxxx.domain.Role;
import com.itxxx.domain.UserInfo;
import com.itxxx.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService us;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> list = us.findAll();
        mv.addObject("userList",list);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String saveUser(UserInfo user){
        us.saveUser(user);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = us.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String id) throws Exception {
        ModelAndView mv= new ModelAndView();
        UserInfo userInfo = us.findById(id);
        List<Role> list = us.findOtherRole(id);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",list);
        mv.setViewName("user-role-add");
        return mv;
    }
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser (@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] ids){
        us.addRoleToUser(userId,ids);
        return "redirect:findAll.do";
    }
}
