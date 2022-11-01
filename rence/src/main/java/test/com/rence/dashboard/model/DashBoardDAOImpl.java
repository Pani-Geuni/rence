/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.text.DecimalFormat;
import java.util.HashMap;
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

	//main
	@Override
	public List<ReserveSummaryVO> reserve_summary_selectAll(String backoffice_no) {
		logger.info("reserve_summary_selectAll...DAOImpl()...");

		List<ReserveSummaryVO> rvos = sqlSession.selectList("SQL_SELECT_ALL_RESERVE_SUMMARY",backoffice_no);

		return rvos;
	}

	@Override
	public List<CommentSummaryVO> comment_summary_selectAll(String backoffice_no) {
		logger.info("comment_summary_selectAll...DAOImpl()...");

		List<CommentSummaryVO> cvos = sqlSession.selectList("SQL_SELECT_ALL_COMMENT_SUMMARY",backoffice_no);

		return cvos;
	}

	@Override
	public SalesSettlementSummaryVO payment_summary_selectOne(String backoffice_no) {
		logger.info("payment_summary_selectOne...DAOImpl()...");

		SalesSettlementSummaryVO svo = sqlSession.selectOne("SQL_SELECT_ONE_PAYMENT_SUMMARY",backoffice_no);
		if (svo!=null) {
			svo.setSales_income(svo.getSales_total()-svo.getSales_cancel());
			
			DecimalFormat df = new DecimalFormat("###,###");
			svo.setSales_income(Integer.parseInt(df.format(svo.getSales_income())));
			svo.setSales_total(Integer.parseInt(df.format(svo.getSales_total())));
			svo.setSales_cancel(Integer.parseInt(df.format(svo.getSales_cancel())));
		}
		
		return svo;
	}

	@Override
	public RoomSummaryVO room_summary_selectOne(String backoffice_no) {
		logger.info("room_summary_selectOne...DAOImpl()...");

		RoomSummaryVO rmvo = sqlSession.selectOne("SQL_SELECT_ONE_ROOM_SUMMARY",backoffice_no);

		return rmvo;
	}

	//예약 관리
	@Override
	public List<ReserveVO> backoffice_reserve_selectAll(String backoffice_no, String reserve_state) {
		logger.info("backoffice_reserve_selectAll...DAOImpl()...");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("backoffice_no", backoffice_no);
		map.put("reserve_state", reserve_state);

		List<ReserveVO> rvos = sqlSession.selectList("SQL_SELECT_ALL_B_RESERVE",map);

		return rvos;
	}

	@Override
	public List<ReserveVO> backoffice_search_reserve(String backoffice_no, String searchword) {
		logger.info("backoffice_search_reserve...DAOImpl()...");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("backoffice_no", backoffice_no);
		map.put("searchword", "%"+searchword+"%");

		List<ReserveVO> rvos = sqlSession.selectList("SQL_SELECT_ALL_B_RESERVE_SEARCH",map);

		return rvos;
	}
	
	//환경설정
	@Override
	public BackOfficeVO backoffice_setting_selectOne(BackOfficeVO bvo) {
		logger.info("backoffice_setting_selectOne()..");
		logger.info("{}", bvo);
		
		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_SELECTONE_BACKOFFICE_SETTING",bvo);
		
		return bvo2;
	}

	@Override
	public BackOfficeVO backoffice_select_pw(BackOfficeVO bvo) {
		logger.info("backoffice_pw_findOK()...");
		logger.info("{}", bvo);

//		String originText = bvo.getBackoffice_pw();

//		String encText = aes.encryptAES("0123456789abcdefghij0123456789ab", originText, true);
//		logger.info("encText (encodeBase64URLSafeString) : " + encText);
		
//		bvo.setBackoffice_pw(encText);
		
		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_PW",bvo);

		return bvo2;
	}

	@Override
	public int backoffice_setting_delete(BackOfficeVO bvo) {
		logger.info("backoffice_setting_delete()...");
		logger.info("{}", bvo);

		int flag = sqlSession.update("SQL_UPDATE_BACKOFFICE_SETTING_O",bvo);

		return flag;
	}

}
