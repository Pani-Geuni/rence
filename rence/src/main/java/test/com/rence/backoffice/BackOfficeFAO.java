package test.com.rence.backoffice;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BackOfficeFAO {

	BackOfficeVO backoffice_fileupload(BackOfficeVO vo,MultipartHttpServletRequest mtfRequest);

	BackOfficeVO host_fileupload(BackOfficeVO vo);

}
