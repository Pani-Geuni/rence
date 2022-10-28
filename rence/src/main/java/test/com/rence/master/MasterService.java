/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.master;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterService {
	private static final Logger logger = LoggerFactory.getLogger(MasterService.class);

	@Autowired
	MasterDAO dao;

	public MasterVO master_login(MasterVO mvo) {
		// TODO Auto-generated method stub
		return null;
	}
}
