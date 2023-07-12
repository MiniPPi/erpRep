package kr.happyjob.study.accEpr.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.accEpr.model.AccEprModel;
import kr.happyjob.study.mngNot.model.NoticeModel;

public interface AccEprService {

	/**  목록 조회 */
	public List<AccEprModel> expenseRequireList(Map<String, Object> paramMap) throws Exception;
	
	/** 목록 카운트 조회 */
	public int countList(Map<String, Object> paramMap) throws Exception;
	
	/** 한건 조회 */
	public AccEprModel listSelectOne(Map<String, Object> paramMap) throws Exception;
	
	/** 수정 */
	public int listUpdate(Map<String, Object> paramMap) throws Exception;
	
	/** 등록  */
	public int listInsert(Map<String, Object> paramMap) throws Exception;
	/** 등록 파일 */
	public int listInsertFile(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;
	
	/** 수정 파일 */
	public int listUpdateFile(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;
	
	/** 삭제 */
	public int listDelete(Map<String, Object> paramMap) throws Exception;
	
	/** 삭제  파일*/
	public int listDeleteFile(Map<String, Object> paramMap) throws Exception;





}
