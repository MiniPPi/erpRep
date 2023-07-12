package kr.happyjob.study.calDay.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.happyjob.study.calDay.dao.CalDayDao;
import kr.happyjob.study.calDay.model.CalDayModel;

@Service
public class CalDayServiceImpl implements CalDayService {

	@Autowired
	CalDayDao calDayDao;

	@Override
	public List<CalDayModel> dateCheckList(Map<String, Object> paramMap) {
		return calDayDao.dateCheckList(paramMap);
	}

	@Override
	public List<CalDayModel> dateCheckDList(Map<String, Object> paramMap) {
		return calDayDao.dateCheckDList(paramMap);
	}

}