/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.util.List;

import test.com.rence.backoffice.BackOfficeVO;
import test.com.rence.office.model.OfficeInfoVO;

public interface DashBoardDAO {

	public List<ReserveSummaryVO> reserve_summary_selectAll(String backoffice_no);

	public List<CommentSummaryVO> comment_summary_selectAll(String backoffice_no);

	public SalesSettlementSummaryVO payment_summary_selectOne(String backoffice_no);

	public RoomSummaryVO room_summary_selectOne(String backoffice_no);

	public List<ReserveVO> backoffice_reserve_selectAll(String backoffice_no, String reserve_state);

	public List<ReserveVO> backoffice_search_reserve(String backoffice_no, String searchword);

	public SalesSettlementPreVO backoffice_sales_selectOne(String backoffice_no, String sales_date);

	public List<SalesSettlementVO> backoffice_sales_selectAll(String backoffice_no);

	public BackOfficeVO backoffice_setting_selectOne(BackOfficeVO bvo);
	
	public BackOfficeVO backoffice_select_pw(BackOfficeVO bvo);
	
	public int backoffice_setting_delete(BackOfficeVO bvo);

	public int backoffice_updateOK_sales(String backoffice_no, String room_no);

	public List<RoomVO> dashboard_room_list(String backoffice_no);

	public int backoffice_insertOK_room(String backoffice_no, RoomVO rvo);

	public BackOfficeVO select_one_backoffice_info(String backoffice_no);

	public int backoffice_updateOK_room(String backoffice_no, RoomVO rvo);

	public int backoffice_deleteOK_room(String backoffice_no, String room_no);
}
