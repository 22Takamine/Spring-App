package com.example.controller;


import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.controller.entity.User;
import com.example.controller.form.IndexForm;
import com.example.controller.form.RegisterForm;
import com.example.controller.form.insertForm;
import com.example.controller.form.searchForm;
import com.example.controller.service.BusinessService;
import com.example.controller.service.UserService;

@Controller
public class indexController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BusinessService businessService;
    
    @Autowired
    MessageSource messageSource;
    
    @Autowired
	HttpSession session; 
    
    @RequestMapping({ "/","/index"})
    public String index(@ModelAttribute("index") IndexForm form, Model model) {
        return "index";
    }
    
    @RequestMapping(value = "/login",params="register", method = RequestMethod.POST)
    public String register(@ModelAttribute("index") RegisterForm form, Model model) {
    	return "register";
    }
    
    
    @RequestMapping(value = "/login",params="login", method = RequestMethod.POST)
    public String login(@Validated  @ModelAttribute("index") IndexForm form, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()){
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
    	
    	session.setAttribute("user", user);
    	model.addAttribute("businessCard",businessService.findByNameOrCompany(""));
    	
    	return "menu";
    	
    }
    
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String entry(@Validated  @ModelAttribute("index") RegisterForm form, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
            return "register";
        }
    	
    	String id = form.getId();
    	String pass = form.getPass();
    	String name = form.getName();
    	
    	User user = userService.findById(id);
    	
    	if(user != null) {
    		String errMsg = messageSource.getMessage("id.error", null, Locale.getDefault());
    		model.addAttribute("msg", errMsg);
    		return "register";
    	}
    	
    	userService.insert(id, pass, name);
    	String msg = messageSource.getMessage("register.success", null, Locale.getDefault());
    	model.addAttribute("msg", msg);
    	
    	user = userService.findById(id);
    	session.setAttribute("user", user);
    	model.addAttribute("businessCard",businessService.findByNameOrCompany(""));
    	
    	return "menu";
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(@ModelAttribute("index") insertForm form, Model model) {
    	return "insert";
    }
    
    @RequestMapping(value = "/insertDate", method = RequestMethod.POST)
    public String insertDate(@Validated  @ModelAttribute("index") insertForm form, BindingResult bindingResult, Model model) {
    	if (bindingResult.hasErrors()) {
            return "insert";
        }
    	
    	String name = form.getName();
    	String read_name = form.getRead_name();
    	String company = form.getCompany();
    	String department = form.getDepartment();
    	String position = form.getPosition();
    	String mail = form.getMail();
    	String tell = form.getTell();
    	String image = form.getImage();
    	String memo = form.getMemo();
    	
    	businessService.insert(name, read_name, company, department, position, mail, tell, image, memo);
    	
    	String msg = messageSource.getMessage("insert.success", null, Locale.getDefault());
    	model.addAttribute("msg", msg);
    	model.addAttribute("businessCard",businessService.findByNameOrCompany(""));
    	return "menu";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@Validated  @ModelAttribute("index") searchForm form, BindingResult bindingResult, Model model) {
    	String keyword = form.getKeyword();
    	model.addAttribute("businessCard",businessService.findByNameOrCompany(keyword));
    	
    	return "menu";
    }
    
    @GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("businessCard", businessService.findById(id));
		return "detail";
	}
    
    @RequestMapping(value = "/back", method = RequestMethod.GET)
    public String back(@ModelAttribute("index") searchForm form, Model model) {
    	model.addAttribute("businessCard",businessService.findByNameOrCompany(""));
    	return "menu";
    }
    
    @GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
    	businessService.delete(id);
		String msg = messageSource.getMessage("register.success", null, Locale.getDefault());
    	model.addAttribute("msg", msg);
		model.addAttribute("businessCard",businessService.findByNameOrCompany(""));
		return "menu";
	}
    
    @RequestMapping(value = "/update", params = "delete", method = RequestMethod.POST)
	public String delete2(@RequestParam("id") int id, Model model) {
		businessService.delete(id);
		String msg = messageSource.getMessage("register.success", null, Locale.getDefault());
    	model.addAttribute("msg", msg);
		model.addAttribute("businessCard",businessService.findByNameOrCompany(""));
		return "menu";
	}
    
    @GetMapping("/updateInput/{id}")
	public String updateInput(@ModelAttribute("index") insertForm form, @PathVariable("id") Integer id, Model model) {
    	model.addAttribute("businessCard",businessService.findById(id));
    	return "update";
    }
    
    @GetMapping("/update/{id}")
	public String update(@Validated @ModelAttribute("index") insertForm form, BindingResult bindingResult, @PathVariable("id") Integer id, Model model) {
    	if (bindingResult.hasErrors()) {
            return "update";
        }
    	String name = form.getName();
    	String read_name = form.getRead_name();
    	String company = form.getCompany();
    	String department = form.getDepartment();
    	String position = form.getPosition();
    	String mail = form.getMail();
    	String tell = form.getTell();
    	String image = form.getImage();
    	String memo = form.getMemo();
    	
    	businessService.update(read_name, name, company, department, position, mail, tell, image, memo, id);
    	model.addAttribute("businessCard",businessService.findByNameOrCompany(""));
    	return "menu";
    }
    
    
    
}