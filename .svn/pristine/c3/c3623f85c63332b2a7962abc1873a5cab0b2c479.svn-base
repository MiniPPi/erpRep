package kr.happyjob.study.empVcs.service;


import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import kr.happyjob.study.empVcs.dao.EmpVcsDao;
import kr.happyjob.study.empVcs.model.VacaSearchModel;



@Service
public class EmpVcsServiceImpl implements EmpVcsService {
	
	@Autowired
	EmpVcsDao empVcsDao;
	
	//휴가신청 리스트
	public List<VacaSearchModel> empVcsList (Map<String, Object> paramMap) throws Exception {
		
		return empVcsDao.empVcsList(paramMap);
	}
	
	//휴가신청 리스트 카운트
	public int countEmpVcsList (Map<String, Object> paramMap) throws Exception{
		return empVcsDao.countEmpVcsList(paramMap);
	}

	public int vacaApplication (Map<String, Object> paramMap) throws Exception{
		return empVcsDao.vacaApplication(paramMap);
	}
	
	//휴가신청 결재올리기
	public int approIn (Map<String, Object> paramMap) throws Exception{
		return empVcsDao.approIn(paramMap);
	}
	
	//휴가신청 결재번호 update
	public int vacaApproUpdate () throws Exception{
			
		return empVcsDao.vacaApproUpdate();
	}
	
	//반려사유 조회
	public String rejDetail(Map<String, Object> paramMap) throws Exception {
		
		return empVcsDao.rejDetail(paramMap);
	}
	
	//사번 유무 체크
	public int loginIDChk(int IDVal) throws Exception {
		return empVcsDao.loginIDChk(IDVal);
	}

}
