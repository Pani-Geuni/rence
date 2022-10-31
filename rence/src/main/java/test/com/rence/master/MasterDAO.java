/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.master;

import java.util.List;

import test.com.rence.backoffice.BackOfficeVO;

public interface MasterDAO {

	public MasterVO master_login(MasterVO mvo);

	public List<BackOfficeVO> backoffice_applyList_selectAll();

	public int backoffice_grant(BackOfficeVO bvo);

	public int backoffice_refuse(BackOfficeVO bvo);

	public List<BackOfficeVO> backoffice_endList_selectAll();

	public int backoffice_revoke(BackOfficeVO bvo);

	public BackOfficeVO master_backoffice_detail_selectOne(BackOfficeVO bvo);

}
