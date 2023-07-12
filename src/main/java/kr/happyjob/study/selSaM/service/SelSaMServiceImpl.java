package kr.happyjob.study.selSaM.service;


import kr.happyjob.study.selSaM.dao.SelSaMDao;
import kr.happyjob.study.selSaM.model.SelSaMModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SelSaMServiceImpl implements SelSaMService {


    @Autowired
    SelSaMDao selSaMDao;

    //제품 목록 리스트 조회
    public List<SelSaMModel> saleMonthList(Map<String, Object> paramMap) throws Exception {

        return selSaMDao.saleMonthList(paramMap);
    }

    //제품 목록 카운트 조회
    public int countSaleMonthList(Map<String, Object> paramMap) throws Exception {

        return selSaMDao.countSaleMonthList(paramMap);
    }

}