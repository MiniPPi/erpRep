package kr.happyjob.study.busPd.dao;


import kr.happyjob.study.busPd.model.BusPdModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public interface BusPdDao {

	//제품 리스트 조회
	public List<BusPdModel> productList(Map<String, Object> paramMap) throws Exception;

	//제품 카운트 조회
	public int countProductList(Map<String, Object> paramMap) throws Exception;

	//한건 조회
	public BusPdModel productSelectOne(Map<String, Object> paramMap) throws Exception;

	//등록
	public int productInsert(Map<String, Object> paramMap) throws Exception;

	//수정
	public int productUpdate(Map<String, Object> paramMap) throws Exception;

	//삭제
	public int productDelete(Map<String, Object> paramMap) throws Exception;

}
