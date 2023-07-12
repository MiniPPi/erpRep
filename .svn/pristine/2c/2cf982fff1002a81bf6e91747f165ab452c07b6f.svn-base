package kr.happyjob.study.selSaD.service;


import kr.happyjob.study.selSaD.dao.SelSaDDao;
import kr.happyjob.study.selSaD.model.SelSaDModel;
import kr.happyjob.study.selSaD.model.SelcectedDayModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SelSaDServiceImpl implements SelSaDService {


    @Autowired
    SelSaDDao selSaDDao;

    //제품 목록 리스트 조회
    public List<SelSaDModel> saleDayList(Map<String, Object> paramMap) throws Exception {

        return selSaDDao.saleDayList(paramMap);
    }

    //제품 목록 카운트 조회
    public int countSaleDayList(Map<String, Object> paramMap) throws Exception {

        return selSaDDao.countSaleDayList(paramMap);
    }
    // Selected day list 조회
    public List<SelcectedDayModel> selectedDayList(Map<String, Object> paramMap) throws Exception {
        return selSaDDao.selectedDayList(paramMap);
    }

}