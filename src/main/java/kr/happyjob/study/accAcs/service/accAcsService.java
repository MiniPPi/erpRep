package kr.happyjob.study.accAcs.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import kr.happyjob.study.accAcs.model.accAcsModel;
import kr.happyjob.study.system.model.ComnCodUtilModel;
import kr.happyjob.study.system.model.ComnDtlCodModel;
import kr.happyjob.study.system.model.ComnGrpCodModel;

@Service
public interface accAcsService {

	List<accAcsModel> accountSearchList(Map<String, Object> paramMap);

	int countactlist(Map<String, Object> paramMap);

	accAcsModel accountSearchSelectone(Map<String, Object> paramMap);


	
		
		
		
	
}
