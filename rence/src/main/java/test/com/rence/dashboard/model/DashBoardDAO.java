/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.util.List;

public interface DashBoardDAO {

	public List<ReserveVO> reserve_summary_selectAll();

	public List<CommentVO> comment_summary_selectAll();

	public List<PaymentVO> payment_summary_selectAll();

	public List<RoomVO> room_summary_selectAll();

}
