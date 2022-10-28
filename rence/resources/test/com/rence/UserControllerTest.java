package test.com.rence.user;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


@RunWith(SpringJUnit4ClassRunner.class)
//하단 코드 없으면 @Autowired 못읽음
@ContextConfiguration(locations = {
   "file:C:\\Users\\82104\\Documents\\golfzon_notebook\\rence-project\\rence\\rence\\src\\main\\webapp\\WEB-INF\\spring\\appServlet\\servlet-context.xml" })

public class UserControllerTest {
	
	@Autowired
	UserSerivice service;
	
	

	@Test
	public void testHome() {
		fail("Not yet implemented");
	}

	@Test
	public void testUser_loginOK() {
		fail("Not yet implemented");
	}

	@Test
	public void testUser_logout() {
		fail("Not yet implemented");
	}

	@Test
	public void testUser_find_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testUser_find_pw() {
		UserVO uvo = new UserVO();
		uvo.setUser_id(null);
		uvo.setUser_email(null);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "1");
		
		assertEquals(map, service.user_id_email_select(uvo));
		 // 아이디 이메일 체크
	}

	@Test
	public void testUser_pw_upddateOK() {
		fail("Not yet implemented");
	}

	@Test
	public void testUser_img_updateOK() {
		fail("Not yet implemented");
	}

	@Test
	public void testUser_secedeOK() {
		fail("Not yet implemented");
	}

}
