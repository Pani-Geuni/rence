/**
	 * @author 강경석
	 *  이미지 업로드 서비스
	 */


package test.com.rence.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.user.model.UserFAO;
import test.com.rence.user.model.UserVO;
@Service
public class UserFileuploadService {
	private static final Logger logger = LoggerFactory.getLogger(UserFileuploadService.class);

@Autowired
UserFAO fao;
	
public UserVO FileuploadOK(UserVO uvo) {
	logger.info("FileuploadOK()");
	return fao.FileuploadOK(uvo);
}	
			

}//end class
