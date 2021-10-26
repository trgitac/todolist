package jp.co.internous.todolist.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.internous.todolist.model.domain.Tasks;


@Mapper
public interface TasksMapper {
	
	public List<Tasks> selectAll();
	
	public void add(Tasks form);

	public int delete(@Param("checkedIds") List<String> checkedIds);
}