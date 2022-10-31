/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.com.rence.backoffice.BackOfficeVO;
import test.com.rence.dashboard.service.DashBoardService;

@Repository
public class DashBoardDAOImpl implements DashBoardDAO {
	private static final Logger logger = LoggerFactory.getLogger(DashBoardDAOImpl.class);

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<ReserveVO> reserve_summary_selectAll() {
		logger.info("reserve_summary_selectAll...DAOImpl()...");

		List<ReserveVO> rvos = sqlSession.selectList("SQL_SELECT_ALL_RESERVE_SUMMARY");

		return rvos;
	}

	@Override
	public List<CommentVO> comment_summary_selectAll() {
		logger.info("comment_summary_selectAll...DAOImpl()...");

		List<CommentVO> cvos = sqlSession.selectList("SQL_SELECT_ALL_COMMENT_SUMMARY");

		return cvos;
	}

	@Override
	public List<PaymentVO> payment_summary_selectAll() {
		logger.info("reserve_summary_selectAll...DAOImpl()...");

		List<PaymentVO> pvos = sqlSession.selectList("SQL_SELECT_ALL_PAYMENT_SUMMARY");

		return pvos;
	}

	@Override
	public List<RoomVO> room_summary_selectAll() {
		logger.info("reserve_summary_selectAll...DAOImpl()...");

		List<RoomVO> rmvos = sqlSession.selectList("SQL_SELECT_ALL_ROOM_SUMMARY");

		return rmvos;
	}

}
