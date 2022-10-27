package test.com.user;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserFAOimpl implements UserFAO {
	private static final Logger logger = LoggerFactory.getLogger(UserFAOimpl.class);
	@Autowired
	SqlSession sqlsession;
	@Autowired
	ServletContext context;

	@Override
	public UserVO FileuploadOK(UserVO vo) {
		if ((vo.getMultipartFile().getSize() > 0)) {
			logger.info("{} byte", vo.getMultipartFile().getOriginalFilename());
			vo.setUser_image(vo.getMultipartFile().getOriginalFilename());
			String dir_path = context.getRealPath("resources/upload");
			logger.info(dir_path);

			File saveFile = new File(dir_path + "/", vo.getUser_image());

			String formatName = vo.getUser_image().substring(vo.getUser_image().lastIndexOf(".") + 1); // ���� ���˵�����
																										// ex)png,jpg
			logger.info("formatName: {}", formatName);

			try {
				vo.getMultipartFile().transferTo(saveFile); //원본이미지 저장.

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // 파일이 넘어왔을때만 처리하는 분기.

		else {
			if (vo.getUser_image() == null) {
				vo.setUser_image("img_0001.png");
			}

		}
		return vo;
	}

}// end class
