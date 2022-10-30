package test.com.rence.backoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackOfficeFileService {

	@Autowired
	BackOfficeFAO fao;

	public BackOfficeVO backoffice_image_upload(BackOfficeVO vo) {
		// TODO Auto-generated method stub
		return fao.backoffice_fileupload(vo);
	}

	public BackOfficeVO host_image_upload(BackOfficeVO vo) {
		// TODO Auto-generated method stub
		return fao.host_fileupload(vo);
	}
	
	
}
