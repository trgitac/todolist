package jp.co.internous.todolist.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.internous.todolist.model.domain.Todo;


@Mapper
public interface TodoMapper {
	
	public List<Todo> selectAll();
}