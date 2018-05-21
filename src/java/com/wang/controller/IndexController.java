package com.wang.controller;

import com.wang.entity.User;
import com.wang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @Desc 主页
 * @Author Wang926454
 * @Date 2018/5/21 17:01
 */
@Controller
/*@RequestMapping("/index")*/
@ApiIgnore
public class IndexController {

	private final IUserService userService;

	@Autowired
	public IndexController(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/index")
	public String index(Model model){
		List<User> users = userService.selectAll();
		model.addAttribute("users", users);
		return "index";
	}
}
