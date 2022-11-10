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
	
	public BackOfficeVO backoffice_insertOK(BackOfficeVO bvo);

	public int backoffice_operating_insert(BackOfficeOperatingTimeVO_datetype ovo2);

	public AuthVO backoffice_authok_select(String backoffice_email, String auth_code);

	public BackOfficeVO backoffice_login(BackOfficeVO bvo);

	public BackOfficeVO backoffice_id_email_select(BackOfficeVO bvo);

	public int backoffice_settingOK_pw(BackOfficeVO bvo);

	public int backoffice_auth_delete(AuthVO avo2);

	public int backoffice_resetOK_pw(BackOfficeVO bvo2);


	
}
