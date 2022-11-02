package test.com.rence.office.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OfficeInfoDAOImpl implements OfficeInfoDAO {

	private static final Logger logger = LoggerFactory.getLogger(OfficeInfoDAOImpl.class);
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public OfficeInfoVO select_one_office_info(String backoffice_no) {
	
		OfficeInfoVO vo = sqlSession.selectOne("SQL_SELECT_ONE_OFFICE_INFO", backoffice_no);
		
		return vo;
	}

	@Override
	public OfficeOperatingTimeVO_date select_one_operating_time(String backoffice_no) {
		
		OfficeOperatingTimeVO_date vo = sqlSession.selectOne("SQL_SELECT_ONE_OPERATING_TIME", backoffice_no);
		
		return vo;
	}

	@Override
	public List<OfficeRoomVO> select_all_room(String backoffice_no) {
		
		List<OfficeRoomVO> list = sqlSession.selectList("SQL_SELECT_ALL_ROOM_INFO", backoffice_no);
		
		if (list != null) {
			for (OfficeRoomVO vo : list) {
				DecimalFormat dc = new DecimalFormat("###,###,###,###");
				vo.setRoom_price(dc.format(Integer.parseInt(vo.getRoom_price())));
			}
		}
		
		return list;
	}
	
	@Override
	public List<OfficeCommentsVO> select_all_comment(String backoffice_no) {
		
		List<OfficeCommentsVO> list = sqlSession.selectList("SQL_SELECT_ALL_COMMENTS_INFO", backoffice_no);
		
		return list;
	}

	@Override
	public List<OfficeReviewVO> select_all_review(String backoffice_no) {
		
		List<OfficeReviewVO> list = sqlSession.selectList("SQL_SELECT_ALL_REVIEW_INFO", backoffice_no);
		
		
		return list;
	}

	

}
