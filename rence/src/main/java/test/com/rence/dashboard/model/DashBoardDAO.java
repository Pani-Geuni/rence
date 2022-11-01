/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.util.List;

import test.com.rence.backoffice.BackOfficeVO;

public interface DashBoardDAO {

	public List<ReserveSummaryVO> reserve_summary_selectAll(String backoffice_no);

	public List<CommentSummaryVO> comment_summary_selectAll(String backoffice_no);

	public SalesSettlementSummaryVO payment_summary_selectOne(String backoffice_no);

	public RoomSummaryVO room_summary_selectOne(String backoffice_no);

	public List<ReserveVO> backoffice_reserve_selectAll(String backoffice_no, String reserve_state);

	public List<ReserveVO> backoffice_search_reserve(String backoffice_no, String searchword);
	
	public BackOfficeVO backoffice_setting_selectOne(BackOfficeVO bvo);

	public BackOfficeVO backoffice_select_pw(BackOfficeVO bvo);

	public int backoffice_setting_delete(BackOfficeVO bvo);

}
