package kr.happyjob.study.selSaD.dao;

import kr.happyjob.study.selSaD.model.SelSaDModel;
import kr.happyjob.study.selSaD.model.SelcectedDayModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface SelSaDDao {
    // 리스트 조회
    List<SelSaDModel> saleDayList(Map<String, Object> paramMap) throws Exception;

    // 카운트 조회
    int countSaleDayList(Map<String, Object> paramMap) throws Exception;

    // 선택된 날짜 리스트 조회
    List<SelcectedDayModel> selectedDayList(Map<String, Object> paramMap) throws Exception;
}
