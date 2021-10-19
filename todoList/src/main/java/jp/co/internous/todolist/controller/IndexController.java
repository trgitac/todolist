package jp.co.internous.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.todolist.model.domain.Todo;
import jp.co.internous.todolist.model.mapper.TodoMapper;

@Controller
@RequestMapping("/todolist")
public class IndexController {
	
	@Autowired
	TodoMapper todoMapper;

	@RequestMapping("/")
	public String index(Model model) {
		List<Todo> list = todoMapper.selectAll();
		model.addAttribute("todos",list);
		return "index";
	}
	
}
