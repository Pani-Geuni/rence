package test.com.rence.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
