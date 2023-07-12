package kr.happyjob.study.accEpr.service;

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

import kr.happyjob.study.accEpr.dao.AccEprDao;
import kr.happyjob.study.accEpr.model.AccEprModel;

import kr.happyjob.study.common.comnUtils.FileUtilCho;
import kr.happyjob.study.mngNot.model.NoticeModel;


@Service
public class AccEprServiceImpl implements AccEprService {

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	// Get class name for logger
	private final String className = this.getClass().toString();
	
	@Autowired
	AccEprDao accEprDao;
	
	@Value("${fileUpload.rootPath}")
	private String rootPath;    // W:\\FileRepository
	
	@Value("${fileUpload.virtualRootPath}")
	private String virtualrootPath;  // /serverfile
	
	@Value("${fileUpload.noticePath}")
	private String noticePath;   // notice
		
	
	/** 목록 조회 */
	public List<AccEprModel> expenseRequireList(Map<String, Object> paramMap) throws Exception {
		
		return accEprDao.expenseRequireList(paramMap);
	}
	
	/** 목록 카운트 조회 */
	public int countList(Map<String, Object> paramMap) throws Exception {
				
		return accEprDao.countList(paramMap);
	}
	
	/** 한건 조회 */
	public AccEprModel listSelectOne(Map<String, Object> paramMap) throws Exception {
		
		return accEprDao.listSelectOne(paramMap);
	}
	
	
	/** 등록 */
	
	public int listInsert(Map<String, Object> paramMap) throws Exception {		
		accEprDao.listInsert(paramMap);
		return accEprDao.approInsert(paramMap); 
	}
	
	/** 수정 */
	public int listUpdate(Map<String, Object> paramMap) throws Exception {
		paramMap.put("fileprc", "N");
		accEprDao.listUpdate(paramMap);
		return accEprDao.listUpdateAppro(paramMap);
	}
	
	/** 삭제 */
	public int listDelete(Map<String, Object> paramMap) throws Exception {
		return accEprDao.listDelete(paramMap);
	}
	
	/** 등록 파일 */
	public int listInsertFile(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		
		// private String rootPath;    // W:\\FileRepository
		// private String virtualrootPath;  // /serverfile
		// private String noticePath;   // notice
		
		String noticedir = File.separator + noticePath + File.separator;
		FileUtilCho fileup = new FileUtilCho(multipartHttpServletRequest,rootPath, virtualrootPath, noticedir);
		Map filereturn = fileup.uploadFiles();
		
		//map.put("file_nm", file_nm);
        //map.put("file_size", file_Size);
        //map.put("file_loc", file_loc);
        //map.put("vrfile_loc", vrfile_loc);
        //map.put("fileExtension", fileExtension);
		
		String upfile = (String) filereturn.get("file_nm");
		paramMap.put("fileprc", "Y");
		
		if(upfile == "" || upfile == null) {
			paramMap.put("fileexist", "N");
		} else {
			paramMap.put("filereturn", filereturn);
			paramMap.put("fileexist", "Y");
			
			accEprDao.fileinsert(paramMap);
		}
		
		accEprDao.approInsert(paramMap); 
		
		return accEprDao.listInsert(paramMap);
	}
	
	/** 수정 파일 */
	public int listUpdateFile(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
		
		return accEprDao.listUpdateFileAppro(paramMap);		
		
	}
	
	/** 삭제  파일*/
	public int listDeleteFile(Map<String, Object> paramMap) throws Exception {
		
        AccEprModel selectone = accEprDao.listSelectOne(paramMap);
		
		if(selectone.getFile_name() != "" && selectone.getFile_name() != null) {
			File attfile = new File(selectone.getPhysic_path());     
			attfile.delete();
			
			//notice_no			
			// tb_file delete
			accEprDao.deletefileinfo(paramMap);
		} 
		accEprDao.listDelete(paramMap);
		return accEprDao.listDeleteAppro(paramMap);
	}

	
	
}
