/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.backoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class BackOfficeFileService {

	@Autowired
	BackOfficeFAO fao;

	public BackOfficeVO backoffice_image_upload(BackOfficeVO vo,MultipartHttpServletRequest mtfRequest) {
		// TODO Auto-generated method stub
		return fao.backoffice_fileupload(vo,mtfRequest);
	}

	public BackOfficeVO host_image_upload(BackOfficeVO vo) {
		// TODO Auto-generated method stub
		return fao.host_fileupload(vo);
	}
	
	
}
