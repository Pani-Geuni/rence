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

import test.com.rence.user.UserVO;

@Component
public class UserSendEmail {
	private static final Logger logger = LoggerFactory.getLogger(UserSendEmail.class);

	@Autowired
	JavaMailSender javaMailSender;

	///////////////////////////////
	// ******* 아이디 찾기 *******//
	//////////////////////////////
	public UserVO findId(UserVO uvo, EmailVO evo) {
		// 이메일 제목, 내용 설정
		evo.setSubject("[rence] User 아이디 재설정");
//		evo.setContent("귀하의 아이디는 다음과 같습니다.");

		// 비밀번호 재설정

		try {
			// 전송
			MimeMessage msg = javaMailSender.createMimeMessage();
			msg.setSubject(evo.getSubject());
			msg.setText("아이디 : " + uvo.getUser_id());
			msg.setRecipient(RecipientType.TO, new InternetAddress(uvo.getUser_email()));

			javaMailSender.send(msg);
		} catch (MessagingException e) {
			uvo = null;
		}
		return uvo;
	}

}// end class
