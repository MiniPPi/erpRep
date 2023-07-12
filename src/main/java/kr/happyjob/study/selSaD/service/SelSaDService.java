package kr.happyjob.study.selSaD.service;

import kr.happyjob.study.selSaD.model.SelSaDModel;
import kr.happyjob.study.selSaD.model.SelcectedDayModel;


import java.util.List;
import java.util.Map;

public interface SelSaDService {

    //리스트 조회
    public List<SelSaDModel> saleDayList(Map<String, Object> paramMap) throws Exception;

    //카운트 조회
    public int countSaleDayList(Map<String, Object> paramMap) throws Exception;


    // Selected day list 조회
    public List<SelcectedDayModel> selectedDayList(Map<String, Object> paramMap) throws Exception;

}