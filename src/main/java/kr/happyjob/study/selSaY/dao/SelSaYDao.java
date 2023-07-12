package kr.happyjob.study.selSaY.dao;


import kr.happyjob.study.selSaY.model.SelSaYModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface SelSaYDao {


	//리스트 조회
	public List<SelSaYModel> saleYearList(Map<String, Object> paramMap) throws Exception;

	//제품 카운트 조회
	public int countSaleYearList(Map<String, Object> paramMap) throws Exception;


}
