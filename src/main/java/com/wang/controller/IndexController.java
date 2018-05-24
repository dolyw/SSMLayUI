package com.wang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.entity.User;
import com.wang.service.IUserService;
import com.wang.util.JsonListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public String index(){
		return "index";
	}

	@ResponseBody
	@RequestMapping("/getUsers")
	public Map getUsers(int page, int limit){
		PageHelper.startPage(page, limit);
		List<User> users = userService.selectAll();
		PageInfo<User> selectPage = new PageInfo<User>(users);
		Map map = new HashMap();
		map.put("code", "0");
		//map.put("msg", "");
		map.put("count", selectPage.getTotal());
		map.put("data", selectPage.getList());
		return map;
	}

	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public void addUser(User user){
		if(user.getId() == null){
			user.setRegtime(new Date());
			int count = userService.insert(user);
		}else{
			int count = userService.updateByPrimaryKeySelective(user);
		}
	}

	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String jsons){
		List<User> users = JsonListUtil.jsonToList(jsons, User.class);
		for (int i = 0; i < users.size(); i++) {
			userService.delete(users.get(i));
		}
	}

	@ResponseBody
	@RequestMapping("/findById")
	public Map findById(String jsons){
		List<User> users = JsonListUtil.jsonToList(jsons, User.class);
		User user = userService.selectOne(users.get(0));
		Map map = new HashMap();
		map.put("obj", user);
		return map;
	}
}
