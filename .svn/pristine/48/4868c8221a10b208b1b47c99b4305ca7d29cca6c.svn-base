package kr.happyjob.study.empApm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.happyjob.study.empApm.model.EmpApmModel;

public interface EmpApmService {

	/** 목록 조회 */
	public List<EmpApmModel> approManagementList(Map<String, Object> paramMap) throws Exception;

	/** 목록 카운트 조회 */
	public int countList(Map<String, Object> paramMap) throws Exception;

	/** 한건 조회 */
	public EmpApmModel listSelectOneApm(Map<String, Object> paramMap) throws Exception;

	/** 휴가 조회 **/
	public EmpApmModel getVacationStatus(Map<String, Object> paramMap) throws Exception;
	
	/* 결재 사항 수정 */
	public Map<String, Object> updateApmStatus(Map<String, Object> paramMap) throws Exception;
	
//	/** 수정 */
//	public int listUpdateApm(Map<String, Object> paramMap) throws Exception;
//	/** 수정 파일 */
//	public int listUpdateFileApm(Map<String, Object> paramMap, HttpServletRequest request) throws Exception;
	public int listUpdateFileBudApm(Map<String, Object> paramMap) throws Exception;
}
