package kr.happyjob.study.busDlv.service;

import java.util.List;
import java.util.Map;


import kr.happyjob.study.busDlv.model.DeliveryInfoModel;



public interface BusDlvService {
	//발주내역 조회 리스트
	public List<DeliveryInfoModel> busDlvList(Map<String, Object> paramMap) throws Exception;
	
	//발주내역 조회 카운트
	public int countBusDlvList(Map<String, Object> paramMap) throws Exception;
	
	//반려사유 조회
	public String rejDetail(Map<String, Object> paramMap) throws Exception;
	
	//발주내역 insert
	public Map<String,Object> dlvApp(Map<String, Object> paramMap) throws Exception;
}
