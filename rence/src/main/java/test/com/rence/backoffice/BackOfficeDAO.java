/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.backoffice;

import test.com.rence.sendemail.AuthVO;

public interface BackOfficeDAO {

	public BackOfficeVO backoffice_email_check(BackOfficeVO bvo);

	public AuthVO backoffice_auth_insert(AuthVO avo);
	
	public AuthVO backoffice_auth_select(AuthVO avo);
	
	public BackOfficeVO backoffice_insertOK(BackOfficeVO bvo);

	public int backoffice_operating_insert(BackOfficeOperationgTimeVO ovo);

	public AuthVO backoffice_authok_select(BackOfficeVO bvo);

	public BackOfficeVO backoffice_login(BackOfficeVO bvo);

	public BackOfficeVO backoffice_id_email_select(BackOfficeVO bvo);

	public int backoffice_settingOK_pw(BackOfficeVO bvo);

	public BackOfficeVO backoffice_setting_selectOne(BackOfficeVO bvo);

	public BackOfficeVO backoffice_select_pw(BackOfficeVO bvo);

	public int backoffice_setting_delete(BackOfficeVO bvo);


	
}
