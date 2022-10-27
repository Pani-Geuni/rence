package test.com.rence.backoffice;

import test.com.rence.sendemail.AuthVO;

public interface BackOfficeDAO {

	public int backoffice_auth_insert(AuthVO vo);
	
	public int backoffice_insertOK(BackOfficeVO bvo);

	public int backoffice_operating_insert(BackOfficeOperationgTimeVO ovo);

	public AuthVO backoffice_auth_select(BackOfficeVO vo);

	public BackOfficeVO backoffice_login(BackOfficeVO vo);

	public BackOfficeVO backoffice_id_email_select(BackOfficeVO vo);

	public int backoffice_pw_findOK(BackOfficeVO vo);

	public BackOfficeVO backoffice_setting_selectOne(BackOfficeVO vo);

	public int backoffice_setting_pw(BackOfficeVO vo);

	public int backoffice_setting_delete(BackOfficeVO vo);
	
}
