package com.example.controller;


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.controller.entity.User;
import com.example.controller.form.IndexForm;
import com.example.controller.service.UserService;

@Controller
public class indexController {
	
	@Autowired
	UserService userService;
    
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping({ "/", "/index"})
    public String index(@ModelAttribute("index") IndexForm form, Model model) {
        return "index";
    }
    
    @RequestMapping(value = "/login",params="register", method = RequestMethod.POST)
    public String register(@Validated  @ModelAttribute("index") IndexForm form, BindingResult bindingResult, Model model) {
    	return "register";
    }
    
    @RequestMapping(value = "/login",params="login", method = RequestMethod.POST)
    public String login(@Validated  @ModelAttribute("index") IndexForm form, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
            return "index";
        }
    	
    	String id = form.getId();
    	String pass = form.getPass();
    	
    	User user = userService.findByIdAndPass(id, pass);
    	
    	if(user == null) {
    		String errMsg = messageSource.getMessage("login.error", null, Locale.getDefault());
    		model.addAttribute("msg", errMsg);
    		return "index";
    	}
//    	model.addAttribute("id",id);
//    	model.addAttribute("pass",pass);
    	return "menu";
    }



    
}