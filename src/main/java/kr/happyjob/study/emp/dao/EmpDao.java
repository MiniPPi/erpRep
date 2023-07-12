package kr.happyjob.study.emp.dao;
////
import kr.happyjob.study.emp.model.EmpModel;

import kr.happyjob.study.mngNot.model.NoticeModel;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public interface EmpDao {
	
    public List<EmpModel> empList(Map<String, Object> paramMap) throws Exception;

    public int countempList(Map<String, Object> paramMap) throws Exception;

    public EmpModel empSelectOne(Map<String, Object> paramMap) throws Exception;

    public int empInsert(Map<String, Object> paramMap) throws Exception;

    public int empUpdate(Map<String, Object> paramMap) throws Exception;

    public int empDelete(Map<String, Object> paramMap) throws Exception;

    public int vaceInsert(Map<String, Object> paramMap) throws Exception;

    public int vaceUpdate(Map<String, Object> paramMap) throws Exception;

    String maxMethod3(Map<String, Object> paramMap);

	public void fileinsert(Map<String, Object> paramMap);

	public void deletefileinfo(Map<String, Object> paramMap);
}
