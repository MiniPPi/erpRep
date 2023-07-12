package kr.happyjob.study.accAcm.service;

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

import kr.happyjob.study.accAcm.dao.accAcmDao;
import kr.happyjob.study.accAcm.model.accAcmModel;
import kr.happyjob.study.accAcs.model.accAcsModel;
import kr.happyjob.study.common.comnUtils.FileUtilCho;
import kr.happyjob.study.mngNot.dao.MngNotDao;
import kr.happyjob.study.mngNot.model.NoticeModel;


@Service
public class accAcmServiceImpl implements accAcmService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	accAcmDao AccAcmDao;
	
	@Value("${fileUpload.rootPath}")
	private String rootPath;    // W:\\FileRepository
	
	@Value("${fileUpload.virtualRootPath}")
	private String virtualrootPath;  // /serverfile
	
	@Value("${fileUpload.noticePath}")
	private String noticePath;   // notice
	
	@Override
	public List<accAcmModel> accAcmSearchList(Map<String, Object> paramMap) {
		return AccAcmDao.accAcmSearchList(paramMap);
	}
	
	@Override
	public int countactlist(Map<String, Object> paramMap) {
		return AccAcmDao.countactlist(paramMap);
	}
	
	
	@Override
	public int bigInsert(Map<String, Object> paramMap) {
		
		System.out.println("제발" +paramMap );
		return AccAcmDao.bigInsert(paramMap);
	}
	

	@Override
	public List<accAcmModel> accAcmSListSearch(Map<String, Object> paramMap) {
		return AccAcmDao.accAcmSListSearch(paramMap);
	}
	
	@Override
	public int countSList(Map<String, Object> paramMap) {
		return AccAcmDao.countSList(paramMap);
	}
	
	@Override
	public int smallInsert(Map<String, Object> paramMap) {
		return AccAcmDao.smallInsert(paramMap);
	}
	
	@Override
	public int LCdDupChked(Map<String, Object> paramMap) {
		return AccAcmDao.LCdDupChked(paramMap);
	}
	
	@Override
	public int LNmDupChked(Map<String, Object> paramMap) {
		return AccAcmDao.LNmDupChked(paramMap);
	}
	
	@Override
	public int SCdDupChk(Map<String, Object> paramMap) {
		return AccAcmDao.SCdDupChk(paramMap);
	}

	
}	
