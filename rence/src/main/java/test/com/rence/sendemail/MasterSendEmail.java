/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.sendemail;

import java.util.concurrent.ThreadLocalRandom;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import test.com.rence.backoffice.BackOfficeVO;

@Component
public class MasterSendEmail {
	private static final Logger logger = LoggerFactory.getLogger(MasterSendEmail.class);

	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	AES256Util aes;

	//////////////////////////////////////////////////
	// ******* (가입 승인) 비밀번호 초기화 링크 전송 *******//
	/////////////////////////////////////////////////
	

	///////////////////////////////
	// ******* (가입 거절) *******//
	//////////////////////////////
	
	
	///////////////////////////////
	// ******* (탈퇴 완료) *******//
	//////////////////////////////
	
	


}
