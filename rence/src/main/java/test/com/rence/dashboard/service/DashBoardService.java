/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.backoffice.BackOfficeVO;
import test.com.rence.dashboard.model.CommentSummaryVO;
import test.com.rence.dashboard.model.CommentVO;
import test.com.rence.dashboard.model.DashBoardDAO;
import test.com.rence.dashboard.model.PaymentVO;
import test.com.rence.dashboard.model.ReserveSummaryVO;
import test.com.rence.dashboard.model.ReserveVO;
import test.com.rence.dashboard.model.RoomSummaryVO;
import test.com.rence.dashboard.model.RoomVO;
import test.com.rence.dashboard.model.SalesSettlementSummaryVO;

@Service
public class DashBoardService {
	private static final Logger logger = LoggerFactory.getLogger(DashBoardService.class);
	
	@Autowired
	DashBoardDAO dao;

	public List<ReserveSummaryVO> reserve_summary_selectAll(String backoffice_no) {
		logger.info("reserve_summary_selectAll()...");
		return dao.reserve_summary_selectAll(backoffice_no);
	}

	public List<CommentSummaryVO> comment_summary_selectAll(String backoffice_no) {
		logger.info("comment_summary_selectAll()...");
		return dao.comment_summary_selectAll(backoffice_no);
	}

	public SalesSettlementSummaryVO payment_summary_selectOne(String backoffice_no) {
		logger.info("payment_summary_selectOne()...");
		return dao.payment_summary_selectOne(backoffice_no);
	}

	public RoomSummaryVO room_summary_selectOne(String backoffice_no) {
		logger.info("room_summary_selectOne()...");
		return dao.room_summary_selectOne(backoffice_no);
	}

	public List<ReserveVO> backoffice_reserve_selectAll(String backoffice_no, String reserve_state) {
		logger.info("backoffice_reserve_selectAll()...");
		return dao.backoffice_reserve_selectAll(backoffice_no, reserve_state);
	}

	public List<ReserveVO> backoffice_search_reserve(String backoffice_no, String searchword) {
		logger.info("backoffice_search_reserve()...");
		return dao.backoffice_search_reserve(backoffice_no, searchword);
	}
	
	//환경설정 페이지 출력
	public BackOfficeVO backoffice_setting_selectOne(BackOfficeVO bvo) {
		logger.info("selectOne()...");
		return dao.backoffice_setting_selectOne(bvo);
	}

	//환경설정에서 비밀번호 변경
	public BackOfficeVO backoffice_select_pw(BackOfficeVO bvo) {
		logger.info("backoffice_select_pw()...");
		return dao.backoffice_select_pw(bvo);
	}

	//환경설정에서 업체 삭제 요청
	public int backoffice_setting_delete(BackOfficeVO bvo) {
		logger.info("backoffice_setting_delete()...");
		return dao.backoffice_setting_delete(bvo);
	}
}
