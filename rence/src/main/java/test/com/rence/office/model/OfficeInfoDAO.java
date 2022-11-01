package test.com.rence.office.model;

import java.util.List;

public interface OfficeInfoDAO {

	public OfficeInfoVO select_one_office_info(String backoffice_no);

	public OfficeOperatingTimeVO_date select_one_operating_time(String backoffice_no);
	
}
