package kr.happyjob.study.empApm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.empApm.dao.EmpApmDao;
import kr.happyjob.study.empApm.model.EmpApmModel;

@Service
public class EmpApmServiceImpl implements EmpApmService {

	 // Set logger
	 private final Logger logger = LogManager.getLogger(this.getClass());
	
	 // Get class name for logger
	 private final String className = this.getClass().toString();

	@Autowired
	EmpApmDao empApmDao;

	/** 목록 조회 */
	public List<EmpApmModel> approManagementList(Map<String, Object> paramMap) throws Exception {
		return empApmDao.approManagementList(paramMap);
	}

	/** 목록 카운트 조회 */
	public int countList(Map<String, Object> paramMap) throws Exception {

		return empApmDao.countList(paramMap);
	}

	/** 한건 조회 */
	public EmpApmModel listSelectOneApm(Map<String, Object> paramMap) throws Exception {

		return empApmDao.listSelectOneApm(paramMap);
	}

	@Override
	public EmpApmModel getVacationStatus(Map<String, Object> paramMap) throws Exception {
		return empApmDao.getVacationStatus(paramMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kr.happyjob.study.empApm.service.EmpApmService#updateApmStatus(java.util.Map) 
	 * 1. 결재 상태 업데이트 (updateApmStatus) 
	 * 2. 휴가/발주 일경우 각각 테이블의 결재상태 업데이트(DVEupdate) 
	 * 3. 휴가 일 경우 잔여일수 계산하고, 업데이트
	 * 4. dv, vu, approStatus 에 각 행의 실행 결과를 담아서 반환
	 */
	public Map<String, Object> updateApmStatus(Map<String, Object> paramMap) throws Exception {
		// 결재 상태 업데이트
		int approStatus = empApmDao.updateApmStatus(paramMap);
		// 여기서 결재 실패하면 뒤로 빠꾸쳐야하는게 맞는데 그게 없네요?

		// appro_no 로 appro_type_cd 가져오기
		String dveSelect = empApmDao.dveSelecte(paramMap);
		paramMap.put("appro_type_cd", dveSelect);

		int dv = empApmDao.DVEupdate(paramMap);

		String ynCheck = (String) paramMap.get("appro_yn");
		String approCd = (String) paramMap.get("appro_type_cd");
		int vu = 0;
 
		if ("Y".equals(ynCheck) && "V".equals(approCd)) {
			int days = empApmDao.vacaDays(paramMap);
			paramMap.put("days", days);
			logger.info("vacation update service :: " + paramMap);
			vu = empApmDao.vacaUpdate(paramMap);
		}

		Map<String, Object> p = new HashMap<>();
		p.put("dv", dv);
		p.put("approStatus", approStatus);
		p.put("vu", vu);
		return p;
	}

	public int listUpdateFileBudApm(Map<String, Object> paramMap) throws Exception {

		return empApmDao.listUpdateFileBudApm(paramMap);
	}
	/*
	 * @Override public EmpApmModel getVacationStatus(Map<String, Object>
	 * paramMap) throws Exception { return
	 * empApmDao.getVacationStatus(paramMap); }
	 */

}
