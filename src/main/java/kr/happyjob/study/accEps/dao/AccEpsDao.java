package kr.happyjob.study.accEps.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.accEps.model.AccEpsModel;


public interface AccEpsDao {

	/**  목록 조회 */
	public List<AccEpsModel> expenseSearchList(Map<String, Object> paramMap) throws Exception;
	
	/** 목록 카운트 조회 */
	public int countList(Map<String, Object> paramMap) throws Exception;
	
	/** 한건 조회 */
	public AccEpsModel listSelectOneEps(Map<String, Object> paramMap) throws Exception;
	
	/** 수정 */
	public int listUpdateEps(Map<String, Object> paramMap) throws Exception;
	public int listUpdateApproEps(Map<String, Object> paramMap) throws Exception;
	
	/** 수정 파일 */
	public int listUpdateFileEps(Map<String, Object> paramMap) throws Exception;
	public int listUpdateFileApproEps(Map<String, Object> paramMap) throws Exception;
	public int listUpdateFileBudEps(Map<String, Object> paramMap) throws Exception;
	
	
	/** 파일 등록 */
	public int fileinsertEps(Map<String, Object> paramMap) throws Exception;
	
	
}
