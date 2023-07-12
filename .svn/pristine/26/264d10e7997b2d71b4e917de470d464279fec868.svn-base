package kr.happyjob.study.busDlv.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.busDlv.dao.BusDlvDao;
import kr.happyjob.study.busDlv.model.DeliveryInfoModel;








@Service
public class BusDlvServiceImpl implements BusDlvService {
	
	@Autowired
	BusDlvDao busDlvDao;
	
	//발주내역 조회 리스트
	public List<DeliveryInfoModel> busDlvList(Map<String, Object> paramMap) throws Exception {
		return busDlvDao.busDlvList(paramMap);
	}
	
	//발주내역 조회 카운트
	public int countBusDlvList(Map<String, Object> paramMap) throws Exception {
		return busDlvDao.countBusDlvList(paramMap);
	}
	
	//반려사유 조회
	public String rejDetail(Map<String, Object> paramMap) throws Exception {
		
		return busDlvDao.rejDetail(paramMap);
	}
	
	//발주내역 insert
	public Map<String,Object> dlvApp(Map<String, Object> paramMap) throws Exception {
		
		int dlv_no = busDlvDao.dlvApplicationNo();
		paramMap.put("dlv_no", dlv_no);
		int dlvApplication = busDlvDao.dlvApplication(paramMap);
		int approIn = busDlvDao.approIn(paramMap);
		int dlvApproUpdate = busDlvDao.dlvApproUpdate(paramMap);
		
		Map<String,Object> reval = new HashMap<String, Object>();
		reval.put("dlvApplication", dlvApplication);
		reval.put("approIn", approIn);
		reval.put("dlvApproUpdate", dlvApproUpdate);
		
		return reval;
	}
	
}
