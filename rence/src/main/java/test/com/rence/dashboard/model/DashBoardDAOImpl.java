/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.com.rence.backoffice.BackOfficeVO;

@Repository
public class DashBoardDAOImpl implements DashBoardDAO {
	private static final Logger logger = LoggerFactory.getLogger(DashBoardDAOImpl.class);

	@Autowired
	SqlSession sqlSession;

	// main
	@Override
	public List<ReserveSummaryVO> reserve_summary_selectAll(String backoffice_no) {
		logger.info("reserve_summary_selectAll...DAOImpl()...");

		List<ReserveSummaryVO> rvos = sqlSession.selectList("SQL_SELECT_ALL_RESERVE_SUMMARY", backoffice_no);

		return rvos;
	}

	@Override
	public List<CommentSummaryVO> comment_summary_selectAll(String backoffice_no) {
		logger.info("comment_summary_selectAll...DAOImpl()...");

		List<CommentSummaryVO> cvos = sqlSession.selectList("SQL_SELECT_ALL_COMMENT_SUMMARY", backoffice_no);

		return cvos;
	}

	@Override
	public SalesSettlementSummaryVO payment_summary_selectOne(String backoffice_no) {
		logger.info("payment_summary_selectOne...DAOImpl()...");

		SalesSettlementSummaryVO svo = sqlSession.selectOne("SQL_SELECT_ONE_PAYMENT_SUMMARY", backoffice_no);
		logger.info("임플임플::::::::",(svo.getSales_total()));
		logger.info("임플임플::::::::",(svo.getSales_cancel()));
		if (svo != null) {
			svo.setSales_income(svo.getSales_total() - svo.getSales_cancel());
		}

		return svo;
	}

	@Override
	public RoomSummaryVO room_summary_selectOne(String backoffice_no) {
		logger.info("room_summary_selectOne...DAOImpl()...");

		RoomSummaryVO rmvo = sqlSession.selectOne("SQL_SELECT_ONE_ROOM_SUMMARY", backoffice_no);

		return rmvo;
	}

	// 예약 관리
	@Override
	public List<ReserveVO> backoffice_reserve_selectAll(String backoffice_no, String reserve_state) {
		logger.info("backoffice_reserve_selectAll...DAOImpl()...");

		Map<String, String> map = new HashMap<String, String>();
		map.put("backoffice_no", backoffice_no);
		map.put("reserve_state", reserve_state);

		List<ReserveVO> rvos = sqlSession.selectList("SQL_SELECT_ALL_B_RESERVE", map);
//		if (rvos!=null) {	        
//			  	Map<String, String> map2 = new HashMap<String, String>();
//				map2.put("backoffice_no", backoffice_no);
//				map2.put("now", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//		 
//			sqlSession.update("SQL_UPDATE_B_RESERVE_STATE", map);
//		}

		return rvos;
	}

	@Override
	public List<ReserveVO> backoffice_search_reserve(String backoffice_no, String searchword, String reserve_state) {
		logger.info("backoffice_search_reserve...DAOImpl()...");

		Map<String, String> map = new HashMap<String, String>();
		map.put("backoffice_no", backoffice_no);
		map.put("reserve_state", reserve_state);
		map.put("searchword", "%" + searchword + "%");

		List<ReserveVO> rvos = sqlSession.selectList("SQL_SELECT_ALL_B_RESERVE_SEARCH", map);

		return rvos;
	}

	// 환경설정
	@Override
	public BackOfficeVO backoffice_setting_selectOne(BackOfficeVO bvo) {
		logger.info("backoffice_setting_selectOne()..");
		logger.info("{}", bvo);

		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_SELECTONE_BACKOFFICE_SETTING", bvo);

		return bvo2;
	}

	@Override
	public BackOfficeVO backoffice_select_pw(BackOfficeVO bvo) {
		logger.info("backoffice_pw_findOK()...");
		logger.info("{}", bvo);

		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_PW", bvo);

		return bvo2;
	}

	@Override
	public int backoffice_setting_delete(BackOfficeVO bvo) {
		logger.info("backoffice_setting_delete()...");
		logger.info("{}", bvo);

		int flag = sqlSession.update("SQL_UPDATE_BACKOFFICE_SETTING_O", bvo);

		return flag;
	}

	// 정산 관리
	@Override
	public SalesSettlementPreVO backoffice_sales_selectOne(String backoffice_no, String sales_date) {
		logger.info("backoffice_sales_selectOne...DAOImpl()...");

		Map<String, String> map = new HashMap<String, String>();
		map.put("backoffice_no", backoffice_no);
		map.put("reserve_state", sales_date);

		SalesSettlementPreVO svo = sqlSession.selectOne("SQL_SELECT_ONE_SALES", map);
		
		if (svo != null) {
			svo.setSales_income(svo.getSales_total() - svo.getSales_cancel());
			svo.setPre_sales_income(svo.getPre_sales_total()-svo.getPre_sales_cancel());
			svo.setSales_gap(svo.getPre_sales_income()-svo.getSales_income());
		}

		return svo;
	}

	@Override
	public List<SalesSettlementVO> backoffice_sales_selectAll(String backoffice_no) {
		logger.info("backoffice_sales_selectAll...DAOImpl()...");

		List<SalesSettlementVO> svos = sqlSession.selectList("SQL_SELECT_ALL_SALES", backoffice_no);

		return svos;
	}

	// 정산 상태 변경
	@Override
	public int backoffice_updateOK_sales(String backoffice_no, String room_no, String payment_no) {
		logger.info("backoffice_updateOK_sales()...");
		logger.info("{}", backoffice_no);

		Map<String, String> map = new HashMap<String, String>();
		map.put("backoffice_no", backoffice_no);
		map.put("room_no", room_no);
		map.put("payment_no", payment_no);
		
		int result = sqlSession.update("SQL_UPDATE_SALES_STATE_T", map);
		int flag =0;
		if (result==1) {
			Map<String, String> map2 = new HashMap<String, String>();
			map2.put("payment_no", payment_no);
			flag = sqlSession.update("SQL_UPDATE_MILEAGE_SUCCESS", map2);
		}

		return flag;
	}

	// 공간 관리 (리스트)
	@Override
	public List<RoomVO> dashboard_room_list(String backoffice_no) {
		logger.info("dashboard_room_list...DAOImpl()...");

		List<RoomVO> rvos = sqlSession.selectList("SQL_SELECT_ALL_ROOM", backoffice_no);

		return rvos;
	}

	// 공간 추가
	@Override
	public int backoffice_insertOK_room(String backoffice_no, RoomVO rvo) {
		logger.info("backoffice_insertOK_room()...");
		logger.info("{}", backoffice_no);
		logger.info("{}", rvo);

		int flag = sqlSession.update("SQL_INSERT_ROOM", rvo);

		return flag;
	}

	// 공간 추가/수정 팝업
	@Override
	public BackOfficeVO select_one_backoffice_info(String backoffice_no) {
		logger.info("select_one_backoffice_info...DAOImpl()...");

		BackOfficeVO bvo = sqlSession.selectOne("SQL_SELECT_ONE_BACKOFFICE_INFO", backoffice_no);

		return bvo;
	}

	// 공간 수정
	@Override
	public int backoffice_updateOK_room(String backoffice_no, RoomVO rvo) {
		logger.info("backoffice_updateOK_room()...");
		logger.info("{}", backoffice_no);
		logger.info("{}", rvo);

		int flag = sqlSession.update("SQL_UPDATE_ROOM", rvo);

		return flag;
	}

	// 공간 삭제
	@Override
	public int backoffice_deleteOK_room(String backoffice_no, String room_no) {
		logger.info("backoffice_updateOK_room()...");
		logger.info("{}", backoffice_no);
		logger.info("{}", room_no);

		Map<String, String> map = new HashMap<String, String>();
		map.put("backoffice_no", backoffice_no);
		map.put("room_no", room_no);

		int flag = sqlSession.update("SQL_DELETE_ROOM", map);

		return flag;
	}

	// 후기 리스트
	@Override
	public List<ReviewVO> backoffice_review_selectAll(String backoffice_no) {
		logger.info("backoffice_review_selectAll...DAOImpl()...");

		List<ReviewVO> rvvos = sqlSession.selectList("SQL_SELECT_ALL_REVIEW_LIST", backoffice_no);

		return rvvos;
	}

	//공간 정보
	@Override
	public RoomVO select_one_room_info(String backoffice_no, String room_no) {
		logger.info("select_one_room_info...DAOImpl()...");

		Map<String, String> map = new HashMap<String, String>();
		map.put("backoffice_no", backoffice_no);
		map.put("room_no", room_no);

		RoomVO rmvo = sqlSession.selectOne("SQL_SELECT_ONE_ROOM_INFO", map);

		return rmvo;
	}

	//QnA 리스트
	@Override
	public List<CommentVO> backoffice_qna_q_selectAll(String backoffice_no) {
		logger.info("backoffice_qna_q_selectAll...DAOImpl()...");

		List<CommentVO> qvos = sqlSession.selectList("SQL_SELECT_ALL_QNA_Q", backoffice_no);
		
		return qvos;
	}
	
	//QnA 리스트
	@Override
	public List<CommentVO> backoffice_qna_a_selectAll(String backoffice_no) {
		logger.info("backoffice_qna_a_selectAll...DAOImpl()...");
		
		List<CommentVO> avos = sqlSession.selectList("SQL_SELECT_ALL_QNA_A", backoffice_no);
		
		return avos;
	}

	//답변 작성 팝업
	@Override
	public CommentVO backoffice_insert_comment(String backoffice_no, String room_no, String comment_no) {
		logger.info("backoffice_insert_comment...DAOImpl()...");

		Map<String, String> map = new HashMap<String, String>();
		map.put("backoffice_no", backoffice_no);
		map.put("room_no", room_no);
		map.put("comment_no", comment_no);

		CommentVO cvo2 = sqlSession.selectOne("SQL_SELECT_ONE_COMMENT_INFO", map);

		return cvo2;
	}
	
	//답변 작성
	@Override
	public int backoffice_insertOK_comment(String backoffice_no, CommentVO cvo) {
		logger.info("backoffice_insertOK_comment...DAOImpl()...");

		Map<String, String> map = new HashMap<String, String>();
		map.put("backoffice_no", backoffice_no);
		map.put("room_no", cvo.getRoom_no());
		cvo.setMother_no(cvo.getComment_no());
		map.put("mother_no", cvo.getMother_no());
		map.put("comment_content", cvo.getComment_content());

		int result = sqlSession.insert("SQL_INSERT_QNA", map);
		int flag = 0;
		if (result==1) {
				Map<String, String> map2 = new HashMap<String, String>();
				map2.put("backoffice_no", backoffice_no);
				map2.put("mother_no", cvo.getMother_no());
				
				flag = sqlSession.update("SQL_UPDATE_Q_STATE_T", map2);
		}

		return flag;
	}

	//답변 삭제
	@Override
	public int backoffice_deleteOK_comment(String backoffice_no, String comment_no, String mother_no) {
		logger.info("backoffice_deleteOK_comment()...");
		logger.info("{}", backoffice_no);
		logger.info("{}", comment_no);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("backoffice_no", backoffice_no);
		map.put("comment_no", comment_no);

		int result = sqlSession.update("SQL_DELETE_QNA_A", map);
		int flag = 0;
		if (result==1) {
			Map<String, String> map2 = new HashMap<String, String>();
			map2.put("backoffice_no", backoffice_no);
			map2.put("mother_no", mother_no);
			
			flag = sqlSession.update("SQL_UPDATE_Q_STATE_F", map2);
		}

		return flag;
	}


}
