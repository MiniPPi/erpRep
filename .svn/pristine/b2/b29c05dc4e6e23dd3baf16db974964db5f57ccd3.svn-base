package kr.happyjob.study.accAcs.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.happyjob.study.accAcs.dao.accAcsDao;
import kr.happyjob.study.accAcs.model.accAcsModel;
import kr.happyjob.study.common.comnUtils.FileUtilCho;


@Service
public class accAcsServiceImpl implements accAcsService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	accAcsDao AccAcsDao;
	
	@Value("${fileUpload.rootPath}")
	private String rootPath;    // W:\\FileRepository
	
	@Value("${fileUpload.virtualRootPath}")
	private String virtualrootPath;  // /serverfile
	
	@Value("${fileUpload.noticePath}")
	private String noticePath;   // notice
		
	
	@Override
	public List<accAcsModel> accountSearchList(Map<String, Object> paramMap) {
		return AccAcsDao.accountSearchList(paramMap);
	}
	
	@Override
	public int countactlist(Map<String, Object> paramMap) {
		return AccAcsDao.countactlist(paramMap);
	}
	
	@Override
	public accAcsModel accountSearchSelectone(Map<String, Object> paramMap) {
		return AccAcsDao.accountSearchSelectone(paramMap);
	}
}
