/**
 * @author 전판근
 */

package test.com.rence.office.model;

import java.text.ParseException;
import java.util.List;

import test.com.rence.user.model.ReviewVO;

public interface OfficeInfoDAO {

	public OfficeInfoVO select_one_office_info(String backoffice_no);

	public OfficeOperatingTimeVO_date select_one_operating_time(String backoffice_no);
	
	public List<OfficeRoomVO> select_all_room(String backoffice_no);
	
	public List<OfficeQuestionVO> select_all_comment(String backoffice_no);
	
	public OfficeQuestionVO select_one_answer(String mother_no);
	
	public List<OfficeReviewVO> select_all_review(String backoffice_no);
	
	public int check_reserve(OfficeReserveVO vo) throws ParseException;
	
	public String select_one_last_reserve(String user_no);
	
	public PaymentInfoVO select_one_final_payment_info(String reserve_no);
	
	public int reserve_paymentOK(OfficePaymentVO pvo);
	
	public int insert_review(ReviewVO vo);
	
	public int insert_question(QuestionVO2 vo);
}
