package kr.happyjob.study.accEps.service;

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

import kr.happyjob.study.accEps.dao.AccEpsDao;
import kr.happyjob.study.accEps.model.AccEpsModel;
import kr.happyjob.study.common.comnUtils.FileUtilCho;



@Service
public class AccEpsServiceImpl implements AccEpsService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	AccEpsDao accEpsDao;
	
	@Value("${fileUpload.rootPath}")
	private String rootPath;    // W:\\FileRepository
	
	@Value("${fileUpload.virtualRootPath}")
	private String virtualrootPath;  // /serverfile
	
	@Value("${fileUpload.noticePath}")
	private String noticePath;   // notice
		
	
	/** 목록 조회 */
	public List<AccEpsModel> expenseSearchList(Map<String, Object> paramMap) throws Exception {
		
		return accEpsDao.expenseSearchList(paramMap);
	}
	
	/** 목록 카운트 조회 */
	public int countList(Map<String, Object> paramMap) throws Exception {
				
		return accEpsDao.countList(paramMap);
	}
	
	/** 한건 조회 */
	public AccEpsModel listSelectOneEps(Map<String, Object> paramMap) throws Exception {
		
		return accEpsDao.listSelectOneEps(paramMap);
	}
	
	
	/** 수정 */
	public int listUpdateEps(Map<String, Object> paramMap) throws Exception {
		paramMap.put("fileprc", "N");
		accEpsDao.listUpdateEps(paramMap);
		return accEpsDao.listUpdateApproEps(paramMap);
	}
	
	
	
	/** 수정 파일 */
	public int listUpdateFileEps(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		accEpsDao.listUpdateFileApproEps(paramMap);	
		return accEpsDao.listUpdateFileBudEps(paramMap);
			
		
	}
	

	
	
}
