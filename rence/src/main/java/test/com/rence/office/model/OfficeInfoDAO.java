package test.com.rence.office.model;

import java.util.List;

public interface OfficeInfoDAO {

	public OfficeInfoVO select_one_office_info(String backoffice_no);

	public OfficeOperatingTimeVO_date select_one_operating_time(String backoffice_no);
	
	public List<OfficeRoomVO> select_all_room(String backoffice_no);
	
	public List<OfficeReviewVO> select_all_review(String backoffice_no);
}
