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
import test.com.rence.dashboard.model.ReserveSummaryVO;
import test.com.rence.dashboard.model.ReserveVO;
import test.com.rence.dashboard.model.ReviewVO;
import test.com.rence.dashboard.model.RoomSummaryVO;
import test.com.rence.dashboard.model.RoomVO;
import test.com.rence.dashboard.model.SalesSettlementPreVO;
import test.com.rence.dashboard.model.SalesSettlementSummaryVO;
import test.com.rence.dashboard.model.SalesSettlementVO;

@Service
public class DashBoardService {
	private static final Logger logger = LoggerFactory.getLogger(DashBoardService.class);
	
	@Autowired
	DashBoardDAO dao;

	// 메인 요약 리스트 하위 4개
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

	//예약 관리 리스트
	public List<ReserveVO> backoffice_reserve_selectAll(String backoffice_no, String reserve_state) {
		logger.info("backoffice_reserve_selectAll()...");
		return dao.backoffice_reserve_selectAll(backoffice_no, reserve_state);
	}

	//예약 관리 검색 (예약자)
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

	//정산 left
	public SalesSettlementPreVO backoffice_sales_selectOne(String backoffice_no, String sales_date) {
		logger.info("backoffice_sales_selectOne()...");
		return dao.backoffice_sales_selectOne(backoffice_no, sales_date);
	}

	//정산 right
	public List<SalesSettlementVO> backoffice_sales_selectAll(String backoffice_no) {
		logger.info("backoffice_sales_selectAll()...");
		return dao.backoffice_sales_selectAll(backoffice_no);
	}

	//정산 상태 변경
	public int backoffice_updateOK_sales(String backoffice_no, String room_no) {
		logger.info("backoffice_updateOK_sales()...");
		return dao.backoffice_updateOK_sales(backoffice_no,room_no);
	}

	//공간 관리 (리스트)
	public List<RoomVO> dashboard_room_list(String backoffice_no) {
		logger.info("dashboard_room_list()...");
		return dao.dashboard_room_list(backoffice_no);
	}
	
	//공간 추가/수정 팝업
	public BackOfficeVO select_one_backoffice_info(String backoffice_no) {
		logger.info("select_one_backoffice_info()...");
		return dao.select_one_backoffice_info(backoffice_no);
	}

	//공간 추가
	public int backoffice_insertOK_room(String backoffice_no, RoomVO rvo) {
		logger.info("backoffice_insertOK_room()...");
		return dao.backoffice_insertOK_room(backoffice_no,rvo);
	}

	//공간 수정
	public int backoffice_updateOK_room(String backoffice_no, RoomVO rvo) {
		logger.info("backoffice_updateOK_room()...");
		return dao.backoffice_updateOK_room(backoffice_no,rvo);
	}

	//공간 삭제
	public int backoffice_deleteOK_room(String backoffice_no, String room_no) {
		logger.info("backoffice_deleteOK_room()...");
		return dao.backoffice_deleteOK_room(backoffice_no,room_no);
	}

	//리뷰 리스트
	public List<ReviewVO> backoffice_review_selectAll(String backoffice_no) {
		logger.info("backoffice_review_selectAll()...");
		return dao.backoffice_review_selectAll(backoffice_no);
	}

	//공간 수정 시, 공간 정보 가져옴
	public RoomVO select_one_room_info(String backoffice_no, String room_no) {
		logger.info("select_one_room_info()...");
		return dao.select_one_room_info(backoffice_no,room_no);
	}

	public List<CommentVO> backoffice_qna_selectAll(String backoffice_no) {
		logger.info("backoffice_qna_selectAll()...");
		return dao.backoffice_qna_selectAll(backoffice_no);
	}

}
