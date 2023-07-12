package kr.happyjob.study.busPd.service;

import kr.happyjob.study.busPd.dao.BusPdDao;

import kr.happyjob.study.busPd.model.BusPdModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BusPdServiceImpl implements BusPdService {

    @Autowired
    BusPdDao busPdDao;

    //제품 목록 리스트 조회
    public List<BusPdModel> productList(Map<String, Object> paramMap) throws Exception {

        return busPdDao.productList(paramMap);
    }


    //제품 목록 카운트 조회
    public int countProductList(Map<String, Object> paramMap) throws Exception {

        return busPdDao.countProductList(paramMap);
    }

    //한건 조회
    public BusPdModel productSelectOne(Map<String, Object> paramMap) throws Exception {

        return busPdDao.productSelectOne(paramMap);
    }

    //등록
    public int productInsert(Map<String, Object> paramMap) throws Exception {
        return busPdDao.productInsert(paramMap);
    }

    //수정
    public int productUpdate(Map<String, Object> paramMap) throws Exception {
        return busPdDao.productUpdate(paramMap);
    }

    //삭제
    public int productDelete(Map<String, Object> paramMap) throws Exception {
        return busPdDao.productDelete(paramMap);
    }
}
