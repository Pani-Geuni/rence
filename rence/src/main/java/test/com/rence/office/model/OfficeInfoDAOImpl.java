package test.com.rence.office.model;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OfficeInfoDAOImpl implements OfficeInfoDAO {

	private static final Logger logger = LoggerFactory.getLogger(OfficeInfoDAOImpl.class);
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public OfficeInfoVO select_one_office_info(String backoffice_no) {
	
		OfficeInfoVO vo = sqlSession.selectOne("SQL_SELECT_ONE_OFFICE_INFO", backoffice_no);
		
		return vo;
	}

}
