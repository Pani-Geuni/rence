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

import test.com.rence.backoffice.BackOfficeService;
import test.com.rence.dashboard.model.CommentVO;
import test.com.rence.dashboard.model.DashBoardDAO;
import test.com.rence.dashboard.model.PaymentVO;
import test.com.rence.dashboard.model.ReserveVO;
import test.com.rence.dashboard.model.RoomVO;

@Service
public class DashBoardService {
	private static final Logger logger = LoggerFactory.getLogger(DashBoardService.class);
	
	@Autowired
	DashBoardDAO dao;

	public List<ReserveVO> reserve_summary_selectAll() {
		logger.info("reserve_summary_selectAll()...");
		return dao.reserve_summary_selectAll();
	}

	public List<CommentVO> comment_summary_selectAll() {
		logger.info("comment_summary_selectAll()...");
		return dao.comment_summary_selectAll();
	}

	public List<PaymentVO> payment_summary_selectAll() {
		logger.info("payment_summary_selectAll()...");
		return dao.payment_summary_selectAll();
	}

	public List<RoomVO> room_summary_selectAll() {
		logger.info("room_summary_selectAll()...");
		return dao.room_summary_selectAll();
	}
}
