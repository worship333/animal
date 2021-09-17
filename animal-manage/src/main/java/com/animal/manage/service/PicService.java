package com.animal.manage.service;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PicService {
	/**
	 * 文件上传
	 * @param file
	 * @return
	 */
	Map<String,Object> upload(MultipartFile file) throws IOException;
}
