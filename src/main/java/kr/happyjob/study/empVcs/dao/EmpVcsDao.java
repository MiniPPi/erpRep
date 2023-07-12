package kr.happyjob.study.empVcs.dao;

import java.util.List;
import java.util.Map;



import kr.happyjob.study.empVcs.model.VacaSearchModel;


public interface EmpVcsDao {
	//휴가신청 리스트
	public List<VacaSearchModel> empVcsList (Map<String, Object> paramMap) throws Exception;
	
	//휴가신청 리스트 카운트
	public int countEmpVcsList (Map<String, Object> paramMap) throws Exception;

	//휴가신청 insert
	public int vacaApplication (Map<String, Object> paramMap) throws Exception;
	
	//휴가신청 결재올리기
	public int approIn (Map<String, Object> paramMap) throws Exception;
	
	//휴가신청 결재번호 update
	public int vacaApproUpdate () throws Exception;
	
	//반려사유 조회
	public String rejDetail(Map<String, Object> paramMap) throws Exception;
	
	//사번 유무 체크
	public int loginIDChk(int IDVal) throws Exception;
}