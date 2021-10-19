package jp.co.internous.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todolist")
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
}
