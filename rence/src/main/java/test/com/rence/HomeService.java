package test.com.rence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.user.model.MyPageDAO;
import test.com.rence.user.model.MyPageReserveListVO;
import test.com.rence.user.model.MyPage_ReviewVO;

@Service
public class HomeService {

	private static final Logger logger = LoggerFactory.getLogger(HomeService.class);

	@Autowired
	ListDAO dao;

	public HomeService() {
		logger.info("HomeSerivice()...");
	}

	public List<ListVO> select_all_list(String type, String condition){
		List<ListVO> list = dao.select_all_list(condition, type);
		
		return list;
	}
	
	
}// end class
