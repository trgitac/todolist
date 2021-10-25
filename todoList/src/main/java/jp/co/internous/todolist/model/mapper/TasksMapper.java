package jp.co.internous.todolist.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.internous.todolist.model.domain.Tasks;


@Mapper
public interface TasksMapper {
	
	public List<Tasks> selectAll();
	
	public void add(Tasks form);

	public void delete(List<String> checkIds); //Listの引数の受け渡しがわかりません。
}