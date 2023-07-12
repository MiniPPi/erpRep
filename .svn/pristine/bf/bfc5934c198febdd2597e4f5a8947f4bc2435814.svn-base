package kr.happyjob.study.empApm.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.empApm.model.EmpApmModel;


public interface EmpApmDao {

	/**  목록 조회 */
	public List<EmpApmModel> approManagementList(Map<String, Object> paramMap) throws Exception;
	
	/** 목록 카운트 조회 */
	public int countList(Map<String, Object> paramMap) throws Exception;
	
	/** 한건 조회 */
	public EmpApmModel listSelectOneApm(Map<String, Object> paramMap) throws Exception;
	
	/** 휴가 상태 조회 **/
	public EmpApmModel getVacationStatus(Map<String, Object> paramMap) throws Exception;
	
	/** 결재 상태 수정 */
	public int updateApmStatus(Map<String, Object> paramMap) throws Exception;
	
	/** 수정 파일 */
	public int listUpdateFileApm(Map<String, Object> paramMap) throws Exception;
	public int listUpdateFileApproApm(Map<String, Object> paramMap) throws Exception;
	public int listUpdateFileBudApm(Map<String, Object> paramMap) throws Exception;
	public int DVEupdate(Map<String, Object> paramMap) throws Exception;
	public String dveSelecte(Map<String, Object> paramMap) throws Exception;
	public int vacaDays(Map<String, Object> paramMap) throws Exception;
	public int vacaUpdate(Map<String, Object> paramMap) throws Exception;
	
	/** 파일 등록 */
	public int fileinsertApm(Map<String, Object> paramMap) throws Exception;
	
	
	
	
}
