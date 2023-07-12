package kr.happyjob.study.empMpg.service;

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

import kr.happyjob.study.empMpg.dao.EmpMpgDao;
import kr.happyjob.study.empMpg.model.EmpMpgModel;
import kr.happyjob.study.common.comnUtils.FileUtilCho;



@Service
public class EmpMpgServiceImpl implements EmpMpgService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	EmpMpgDao empMpgDao;
	

	
	/** 목록 조회 */
	public List<EmpMpgModel> empMypageList(Map<String, Object> paramMap) throws Exception {
		
		return empMpgDao.empMypageList(paramMap);
	}
	
	/** 목록 카운트 조회 */
	public int countList(Map<String, Object> paramMap) throws Exception {
				
		return empMpgDao.countList(paramMap);
	}
	
	/** 한건 조회 */
	public EmpMpgModel listSelectOneMpg(Map<String, Object> paramMap) throws Exception {
		
		return empMpgDao.listSelectOneMpg(paramMap);
	}
	

	
	/** 수정 파일 */
	public int listUpdateFileMpg(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
	
		return empMpgDao.listUpdateFileMpg(paramMap);
			
		
	}

	
}
