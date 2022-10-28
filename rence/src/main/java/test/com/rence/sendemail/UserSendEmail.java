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

	@Autowired
	AES256Util aes;

	// ******* 이메일 인증 *******//
	public AuthVO sendEmail(AuthVO vo, EmailVO evo) {

		// 이메일 제목, 내용 설정
		evo.setSubject("[rence] 이메일 인증코드");
		evo.setContent("해당 코드를 인증번호 란에 기입 후, 인증확인을 마쳐주세요.");

		// 인증코드 생성
		int RANDOM_BOUND = 100000;
		ThreadLocalRandom random = ThreadLocalRandom.current();
		vo.setAuth_code(String.valueOf(random.nextInt(RANDOM_BOUND, RANDOM_BOUND * 10)));

		try {

			// 전송
			MimeMessage msg = javaMailSender.createMimeMessage();
			msg.setSubject(evo.getSubject());
			msg.setText("인증 코드 : " + vo.getAuth_code());
			msg.setRecipient(RecipientType.TO, new InternetAddress(vo.getUser_email()));

			javaMailSender.send(msg);
		} catch (MessagingException e) {
			vo = null;
		}
		return vo;
	}

	// ******* 아이디 찾기 *******//

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

	// ******* 비밀번호 찾기 *******//
	public UserVO findPw(UserVO uvo, EmailVO evo) {

		String originText = uvo.getUser_id();

		// 아이디를 암호화
		String encText = aes.encryptAES("0123456789abcdefghij0123456789ab", originText, true);
		logger.info("encText (encodeBase64URLSafeString) : " + encText);

		// 이메일 제목, 내용 설정
		evo.setSubject("[rence] 비밀번호 재설정");
//		evo.setContent("아래의 링크에 접속하여 비밀번호를 재설정 해주시길 바랍니다."); //아직 무슨기능인지 몰라 일단은 주석처리

		// 비밀번호 재설정

		try {
			// 전송
			MimeMessage msg = javaMailSender.createMimeMessage();
			msg.setSubject(evo.getSubject());
			msg.setText("아래의 링크에 접속하여 비밀번호를 재설정 해주시길 바랍니다." + "                       " + "비밀번호 재설정 링크 : "
					+ "http://localhost:8090/rence/user_pw_upddate?user_id=" + encText);
			msg.setRecipient(RecipientType.TO, new InternetAddress(uvo.getUser_email()));

			javaMailSender.send(msg);
		} catch (MessagingException e) {
			uvo = null;
		}
		return uvo;
	}

}// end class
