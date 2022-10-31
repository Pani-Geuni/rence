package test.com.rence;

import java.util.List;

public interface ListDAO {

	public List<ListVO> select_all_list(String condition, String type);
	
	
}// end interface
