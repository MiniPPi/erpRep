package kr.happyjob.study.empVcp.service;

import java.util.List;
import java.util.Map;



import kr.happyjob.study.empVcp.model.VacaPersonalModel;
import kr.happyjob.study.empVcp.model.VacaPersonalRemainModel;

public interface EmpVcpService {

	//휴가신청 리스트
	public List<VacaPersonalModel> empVcpList (Map<String, Object> paramMap) throws Exception;
	
	//휴가신청 리스트 카운트
	public int countEmpVcpList (Map<String, Object> paramMap) throws Exception;

	//휴가신청 insert
	public int vacaApplication (Map<String, Object> paramMap) throws Exception;
	
	//휴가신청 결재올리기
	public int approIn (Map<String, Object> paramMap) throws Exception;
	
	//휴가신청 결재번호 update
	public int vacaApproUpdate () throws Exception;
	
	//반려사유 조회
	public String rejDetail(Map<String, Object> paramMap) throws Exception;
	
	//잔여연차 조회
	public List<VacaPersonalRemainModel> vacaRemain(Map<String, Object> paramMap) throws Exception;
}
