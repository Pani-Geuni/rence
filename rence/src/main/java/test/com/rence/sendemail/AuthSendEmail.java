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

@Component
public class AuthSendEmail {
	private static final Logger logger = LoggerFactory.getLogger(AuthSendEmail.class);

	@Autowired
	JavaMailSender javaMailSender;

	///////////////////////////////
	//******* 인증 코드 전송 *******//
	//////////////////////////////
	public AuthVO sendEmail(AuthVO vo)  {
		
		//이메일 제목, 내용 설정
		vo.setSubject("[rence] 이메일 인증코드");
		vo.setContent("해당 코드를 인증번호 란에 기입 후, 인증확인을 마쳐주세요.");
		
		//인증코드 생성
		int RANDOM_BOUND = 100000;
		ThreadLocalRandom random = ThreadLocalRandom.current();
		vo.setAuth_code(String.valueOf(random.nextInt(RANDOM_BOUND))); 
		
		try {
			
			//전송
			MimeMessage msg = javaMailSender.createMimeMessage();
			msg.setSubject(vo.getSubject());
			msg.setText(vo.getContent(),"인증 코드 : "+vo.getAuth_code());
			msg.setRecipient(RecipientType.TO, new InternetAddress(vo.getUser_email()));
			
			javaMailSender.send(msg);
		} catch (MessagingException e) {
			// TODO: handle exception
			vo = null;
		}
		return vo;
	}
	
}
