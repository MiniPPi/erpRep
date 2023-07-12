package kr.happyjob.study.busDlv.dao;

import java.util.List;
import java.util.Map;


import kr.happyjob.study.busDlv.model.DeliveryInfoModel;




public interface BusDlvDao {
	
	//발주내역 조회 리스트
	public List<DeliveryInfoModel> busDlvList(Map<String, Object> paramMap) throws Exception;
	
	//발주내역 조회 카운트
	public int countBusDlvList(Map<String, Object> paramMap) throws Exception;
	
	//반려사유 조회
	public String rejDetail(Map<String, Object> paramMap) throws Exception;
	
	//발주테이블 insert 전 dlv_no 따오기
	public int dlvApplicationNo() throws Exception;
	
	//발주테이블 insert(발주신청)
	public int dlvApplication(Map<String, Object> paramMap) throws Exception;
	
	//결재테이블 insert(발주신청)
	public int approIn(Map<String, Object> paramMap) throws Exception;
	
	//발주테이블 결재번호 update(발주신청)
	public int dlvApproUpdate(Map<String, Object> paramMap) throws Exception;
}