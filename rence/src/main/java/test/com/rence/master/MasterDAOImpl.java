/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.master;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MasterDAOImpl implements MasterDAO {
	private static final Logger logger = LoggerFactory.getLogger(MasterDAOImpl.class);

	@Autowired
	SqlSession sqlSession;
}
