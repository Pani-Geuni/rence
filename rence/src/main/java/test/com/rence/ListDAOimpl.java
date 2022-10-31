package test.com.rence;

import java.text.DecimalFormat;
import java.util.List;

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
			
		}
		else if(condition.equals("cheap")) {
			
		}
		else if(condition.equals("expensive")) {
			
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

}// end class
