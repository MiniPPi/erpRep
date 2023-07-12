package kr.happyjob.study.empSas.service;


import java.util.Map;




import kr.happyjob.study.empSas.model.SalSerarchModel;


public interface EmpSasService {

	//급여목록 리스트 조회
	public SalSerarchModel empSasList1(Map<String, Object> paramMap) throws Exception;
	
	//급여목록 리스트 조회
	public SalSerarchModel empSasList2(Map<String, Object> paramMap) throws Exception;
	
	//급여목록 유무
	public int empSasCount(Map<String, Object> paramMap) throws Exception;
	
	
}
