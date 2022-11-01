package test.com.rence;

import java.util.List;

public interface ListDAO {

	public List<ListVO> select_all_list(String condition, String type);
	public List<ListVO> search_list(String type, String location, String searchWord, String condition);
	
	
}// end interface
