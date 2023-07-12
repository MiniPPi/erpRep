package kr.happyjob.study.accEps.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.accEps.model.AccEpsModel;


public interface AccEpsService {

	/**  목록 조회 */
	public List<AccEpsModel> expenseSearchList(Map<String, Object> paramMap) throws Exception;
	
	/** 목록 카운트 조회 */
	public int countList(Map<String, Object> paramMap) throws Exception;
	
	/** 한건 조회 */
	public AccEpsModel listSelectOneEps(Map<String, Object> paramMap) throws Exception;
	
	/** 수정 */
	public int listUpdateEps(Map<String, Object> paramMap) throws Exception;
	
	/** 수정 파일 */
	public int listUpdateFileEps(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;
	
	
	
}
