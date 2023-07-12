package kr.happyjob.study.accEpr.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.accEpr.model.AccEprModel;
import kr.happyjob.study.mngNot.model.NoticeModel;

public interface AccEprDao {

	/**  목록 조회 */
	public List<AccEprModel> expenseRequireList(Map<String, Object> paramMap) throws Exception;
	
	/** 목록 카운트 조회 */
	public int countList(Map<String, Object> paramMap) throws Exception;
	
	/** 한건 조회 */
	public AccEprModel listSelectOne(Map<String, Object> paramMap) throws Exception;
	
	/** 등록 */
	public int listInsert(Map<String, Object> paramMap) throws Exception;
	public int approInsert(Map<String, Object> paramMap) throws Exception;
	
	
	/** 수정 */
	public int listUpdate(Map<String, Object> paramMap) throws Exception;
	public int listUpdateAppro(Map<String, Object> paramMap) throws Exception;
	
	/** 삭제 */
	public int listDelete(Map<String, Object> paramMap) throws Exception;
	public int listDeleteAppro(Map<String, Object> paramMap) throws Exception;
	
	/** 등록 파일 */
	public int listInsertFile(Map<String, Object> paramMap) throws Exception;
	
	/** 수정 파일 */
	public int listUpdateFile(Map<String, Object> paramMap) throws Exception;
	public int listUpdateFileAppro(Map<String, Object> paramMap) throws Exception;
	
	/** 삭제  파일*/
	public int listDeleteFile(Map<String, Object> paramMap) throws Exception;
	
	/** 파일 등록 */
	public int fileinsert(Map<String, Object> paramMap) throws Exception;
	
	/** 파일 정보 삭제 */
	public int deletefileinfo(Map<String, Object> paramMap) throws Exception;
	
}
