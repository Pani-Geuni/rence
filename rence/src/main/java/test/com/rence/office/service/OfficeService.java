package test.com.rence.office.service;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.office.model.OfficeCommentsVO;
import test.com.rence.office.model.OfficeInfoDAO;
import test.com.rence.office.model.OfficeInfoVO;
import test.com.rence.office.model.OfficeOperatingTimeVO_date;
import test.com.rence.office.model.OfficePaymentVO;
import test.com.rence.office.model.OfficeQuestionVO;
import test.com.rence.office.model.OfficeReserveVO;
import test.com.rence.office.model.OfficeReviewVO;
import test.com.rence.office.model.OfficeRoomVO;
import test.com.rence.office.model.PaymentInfoVO;
import test.com.rence.user.model.QuestionVO;

@Service
public class OfficeService {
	
	private static final Logger logger = LoggerFactory.getLogger(OfficeService.class);
	
	@Autowired
	OfficeInfoDAO dao;
	
	public OfficeService() {
		logger.info("OfficeService()...");
	}
	
	public OfficeInfoVO select_one_office_info(String backoffice_no) {
		logger.info("select_one_office_info()...");
		OfficeInfoVO vo = dao.select_one_office_info(backoffice_no);
		
		return vo; 
	}
	
	public OfficeOperatingTimeVO_date select_one_operating_time(String backoffice_no) {
		logger.info("select_one_operating_time()...");
		
		OfficeOperatingTimeVO_date vo = dao.select_one_operating_time(backoffice_no);
		
		return vo;
	}
	
	public List<OfficeRoomVO> select_all_room(String backoffice_no) {
		logger.info("select_all_room()...");
		
		List<OfficeRoomVO> vos = dao.select_all_room(backoffice_no);
		
		return vos;
	}
	
	public List<OfficeQuestionVO> select_all_comment(String backoffice_no) {
		logger.info("select_all_comment()...");
		
		List<OfficeQuestionVO> vos = dao.select_all_comment(backoffice_no);
		
		return vos;
	}
	
	public OfficeQuestionVO select_one_answer(String mother_no) {
		OfficeQuestionVO vo = dao.select_one_answer(mother_no);
		
		return vo;
	}
	
	public List<OfficeReviewVO> select_all_review(String backoffice_no) {
		logger.info("select_all_review()...");
		
		List<OfficeReviewVO> vos = dao.select_all_review(backoffice_no);
		
		return vos;
	}
	
	public int check_reserve(OfficeReserveVO vo) throws ParseException {
		logger.info("check_reserve()...");
		
		int result = dao.check_reserve(vo);
		
		return result;
	}
	
	public String select_one_last_reserve(String user_no) {
		logger.info("select_one_last_reserve");
		
		String reserve_no = dao.select_one_last_reserve(user_no);
		
		return reserve_no;
	}
	
	public PaymentInfoVO select_one_final_payment_info(String reserve_no) {
		logger.info("select_one_final_payment_info");
		
		PaymentInfoVO vo = dao.select_one_final_payment_info(reserve_no);
		
		return vo;
	}
	
	public int reserve_paymentOK(OfficePaymentVO pvo) {
		logger.info("reserve_paymentOK");
		
		int result = dao.reserve_paymentOK(pvo);
		
		return result; 
	}
}
