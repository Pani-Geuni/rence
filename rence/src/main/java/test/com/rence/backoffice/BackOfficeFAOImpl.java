/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.backoffice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Repository
public class BackOfficeFAOImpl implements BackOfficeFAO {
	private static final Logger logger = LoggerFactory.getLogger(BackOfficeFAOImpl.class);

	@Autowired
	ServletContext context;
//	@Autowired
//	MultipartHttpServletRequest mtfRequest;

	@Override
	public BackOfficeVO backoffice_fileupload(BackOfficeVO vo, MultipartHttpServletRequest mtfRequest) {
		logger.info("{} byte", vo.getMultipartFile_room().getSize());

		if (vo.getMultipartFile_room().getSize() > 0) {
			logger.info("{} byte", vo.getMultipartFile_room().getOriginalFilename());
			List<MultipartFile> imgs = mtfRequest.getFiles("multipartFile_room");
			logger.info("ssssssssssssssssssssssssssssssssssssssssss:::::::::{}",imgs);

			String dir_path = context.getRealPath("resources/upload");
			logger.info(dir_path);
			for (MultipartFile mf : imgs) {

				vo.setBackoffice_image(mf.getOriginalFilename());

				String originFileName = mf.getOriginalFilename(); // 원본 파일 명
				long fileSize = mf.getSize(); // 파일 사이즈

				System.out.println("originFileName : " + originFileName);
				System.out.println("fileSize : " + fileSize);

				String saveFile = dir_path +"/"+ originFileName;
				try {
					mf.transferTo(new File(saveFile));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			

		} else if (vo.getBackoffice_image() == null) {
				vo.setBackoffice_image("img_room_001.jpg");
				String dir_path = context.getRealPath("resources/upload");
				logger.info(dir_path);

				File saveFile = new File(dir_path + "/", vo.getBackoffice_image());
				try {
					vo.getMultipartFile_room().transferTo(saveFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
		return vo;
	}

	@Override
	public BackOfficeVO host_fileupload(BackOfficeVO vo) {
		logger.info("{} byte", vo.getMultipartFile_host().getSize());

		if (vo.getMultipartFile_host().getSize() > 0) {
			logger.info("{} byte", vo.getMultipartFile_host().getOriginalFilename());

			vo.setHost_image(vo.getMultipartFile_host().getOriginalFilename());
		} else {
			if (vo.getHost_image() == null) {
				vo.setHost_image("img_host_001.jpg");
			}
			String dir_path = context.getRealPath("resources/upload");
			logger.info(dir_path);

			File saveFile = new File(dir_path + "/", vo.getHost_image());

//			String formmatName = vo.getBackoffice_image().substring(vo.getBackoffice_image().lastIndexOf(".") + 1);
//			logger.info("formmatName:{}", formmatName);

			try {
				vo.getMultipartFile_host().transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return vo;
	}

}
