package kr.happyjob.study.empSam.dao;

import java.util.List;
import java.util.Map;



import kr.happyjob.study.empSam.model.SalManagementModel;





public interface EmpSamDao {

	//급여목록 리스트 조회
	public List<SalManagementModel> empSamList(Map<String, Object> paramMap) throws Exception;
	
	//급여목록 카운트 조회
	public int countEmpSamList(Map<String, Object> paramMap) throws Exception;	
	
	//개별지급
	public int salPayOne(Map<String, Object> paramMap) throws Exception;
	
	//일괄지급
	public int salPayAll(Map<String, Object> paramMap) throws Exception;
	
	//급여계산 전 확인
	public List<Integer> calSalChk() throws Exception;
	
	//급여계산
	public int calSal(String st) throws Exception;
	
}