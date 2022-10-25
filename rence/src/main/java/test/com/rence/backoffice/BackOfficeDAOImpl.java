package test.com.rence.backoffice;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BackOfficeDAOImpl implements BackOfficeDAO {
	private static final Logger logger = LoggerFactory.getLogger(BackOfficeDAOImpl.class);

	@Autowired
	SqlSession sqlSession;
}
