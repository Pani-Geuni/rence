package test.com.rence;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ListDAOimpl implements ListDAO {

	private static final Logger logger = LoggerFactory.getLogger(ListDAOimpl.class);
	
	@Autowired
	SqlSession sqlSession;

	
	@Override
	public List<ListVO> select_all_list(String condition, String type) {
		List<ListVO> list = null;
		
		if(condition.equals("date")) {
			list = sqlSession.selectList("SQL_SELECT_ALL_BACKOFFICE_SORT_DATE", "%"+type+"%");
		}
		else if(condition.equals("rating")) {
			list = sqlSession.selectList("SQL_SELECT_ALL_BACKOFFICE_SORT_RATING", "%"+type+"%");
		}
		else if(condition.equals("cheap")) {
			list = sqlSession.selectList("SQL_SELECT_ALL_BACKOFFICE_SORT_CHEAP", "%"+type+"%");
		}
		else if(condition.equals("expensive")) {
			list = sqlSession.selectList("SQL_SELECT_ALL_BACKOFFICE_SORT_EXPENSIVE", "%"+type+"%");
		}
		
		if(list != null) {
			for(ListVO vo : list) {
				DecimalFormat dc = new DecimalFormat("###,###,###,###");	
				String ch = dc.format(Integer.parseInt(vo.getMin_room_price()));
				vo.setMin_room_price(ch);
				
				if(vo.getRoadname_address().contains(" ")) {
					String road_name = vo.getRoadname_address().split(" ")[0] + " " + vo.getRoadname_address().split(" ")[1];
					vo.setRoadname_address(road_name);
				}
			}
		}

		return list;
	}


	@Override
	public List<ListVO> search_list(String type, String location, String searchWord, String condition) {
		List<ListVO> list = null;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", "%"+type+"%");
		map.put("location", "%"+location+"%");
		map.put("searchWord", "%"+searchWord+"%");
		
		if(condition.equals("date")) {
			list = sqlSession.selectList("SQL_SEARCHLIST_SORT_DATE", map);
		}
		else if(condition.equals("rating")) {
			list = sqlSession.selectList("SQL_SEARCHLIST_SORT_RATING", map);
		}
		else if(condition.equals("cheap")) {
			list = sqlSession.selectList("SQL_SEARCHLIST_SORT_CHEAP", map);
		}
		else if(condition.equals("expensive")) {
			list = sqlSession.selectList("SQL_SEARCHLIST_SORT_EXPENSIVE", map);
		}
		
		logger.info("SEARCH - ListDAOimpl map : {}", map);
		logger.info("SEARCH - ListDAOimpl : {}", list);
		
		return list;
	}
	

}// end class
