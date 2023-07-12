package kr.happyjob.study.calDay.dao;

import java.util.List;
import java.util.Map;

import kr.happyjob.study.calDay.model.CalDayModel;

public interface CalDayDao {

	public List<CalDayModel> dateCheckList(Map<String, Object> paramMap);

	public List<CalDayModel> dateCheckDList(Map<String, Object> paramMap);

}
