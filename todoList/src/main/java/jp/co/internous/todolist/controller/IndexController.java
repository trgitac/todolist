package jp.co.internous.todolist.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.todolist.model.domain.Tasks;
import jp.co.internous.todolist.model.form.TaskForm;
import jp.co.internous.todolist.model.mapper.TasksMapper;

@Controller
@RequestMapping("/task")
public class IndexController {
	
	Gson gson = new Gson();
	
	@Autowired
	TasksMapper tasksMapper;

	@RequestMapping("/")
	public String index(Model model) {
		List<Tasks> list = tasksMapper.selectAll();
		model.addAttribute("tasks",list);
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(TaskForm form) {
		Tasks tasks = new Tasks();
		tasks.setTitle(form.getTitle());
		tasksMapper.add(tasks);
		return "redirect:/task/";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean delete(@RequestBody String checkedIdList) {
		
		Map<String,List<String>> map = gson.fromJson(checkedIdList,Map.class);
		List<String> checkedIds = map.get("checkedIdList"); 
		System.out.println(checkedIds.size());
		int count = 0;
		if(checkedIds.size() > 0) {
			count = tasksMapper.delete(checkedIds);
		}
		return count > 0; 
	}
}
