package kr.happyjob.study.selSaY.service;


import kr.happyjob.study.selSaY.dao.SelSaYDao;
import kr.happyjob.study.selSaY.model.SelSaYModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SelSaYServiceImpl implements SelSaYService {


    @Autowired
    SelSaYDao selSaYDao;

    //제품 목록 리스트 조회
    public List<SelSaYModel> saleYearList(Map<String, Object> paramMap) throws Exception {

        return selSaYDao.saleYearList(paramMap);
    }

    //제품 목록 카운트 조회
    public int countSaleYearList(Map<String, Object> paramMap) throws Exception {

        return selSaYDao.countSaleYearList(paramMap);
    }

}