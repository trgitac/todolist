package jp.co.internous.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.todolist.model.domain.Tasks;
import jp.co.internous.todolist.model.mapper.TasksMapper;

@Controller
@RequestMapping("/todolist")
public class IndexController {
	
	@Autowired
	TasksMapper tasksMapper;

	@RequestMapping("/")
	public String index(Model model) {
		List<Tasks> list = tasksMapper.selectAll();
		model.addAttribute("tasks",list);
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(Tasks todo) {
		tasksMapper.add(todo);
		return "index";
	}
}
