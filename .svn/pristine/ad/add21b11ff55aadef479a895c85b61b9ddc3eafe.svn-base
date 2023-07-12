package kr.happyjob.study.empSam.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.happyjob.study.empSam.dao.EmpSamDao;
import kr.happyjob.study.empSam.model.SalManagementModel;



@Service
public class EmpSamServiceImpl implements EmpSamService {
	
	@Autowired
	EmpSamDao empSamDao;
	
	//급여목록 리스트 조회
	public List<SalManagementModel> empSamList(Map<String, Object> paramMap) throws Exception {
		
		return empSamDao.empSamList(paramMap);
	}
		
	//급여목록 카운트 조회
	public int countEmpSamList(Map<String, Object> paramMap) throws Exception{
		
		return empSamDao.countEmpSamList(paramMap);
	}
	
	//개별지급
	public int salPayOne(Map<String, Object> paramMap) throws Exception {
		return empSamDao.salPayOne(paramMap);
	}
		
	//일괄지급
	public int salPayAll(Map<String, Object> paramMap) throws Exception {
		return empSamDao.salPayAll(paramMap);
	}
	
	//급여계산 전 확인
	//급여계산전 확인
	public List<Integer> calSalChk() throws Exception {
		return empSamDao.calSalChk();
	}
	
	//급여계산
	public int calSal(String st) throws Exception {
		return empSamDao.calSal(st);
	}
	
}
