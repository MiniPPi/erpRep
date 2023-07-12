package kr.happyjob.study.empSas.service;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import kr.happyjob.study.empSas.dao.EmpSasDao;
import kr.happyjob.study.empSas.model.SalSerarchModel;



@Service
public class EmpSasServiceImpl implements EmpSasService {
	
	@Autowired
	EmpSasDao empSasDao;
	
	
	//급여목록 리스트 조회
	public SalSerarchModel empSasList1(Map<String, Object> paramMap) throws Exception{
		
		return empSasDao.empSasList1(paramMap);
	}
	//급여목록 리스트 조회
	public SalSerarchModel empSasList2(Map<String, Object> paramMap) throws Exception{
		
		return empSasDao.empSasList2(paramMap);
	}
	
	//급여목록 유무
	public int empSasCount(Map<String, Object> paramMap) throws Exception {
		
		return empSasDao.empSasCount(paramMap);
	}
	
	
	
}
