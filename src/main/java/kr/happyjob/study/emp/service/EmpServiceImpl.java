package kr.happyjob.study.emp.service;
import kr.happyjob.study.common.comnUtils.FileUtilCho;
//www
import kr.happyjob.study.emp.dao.EmpDao;
import kr.happyjob.study.emp.model.EmpModel;
import kr.happyjob.study.mngNot.model.NoticeModel;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
@Service
////
public class EmpServiceImpl implements EmpService{

    @Autowired
    EmpDao empDao;

    private final Logger logger = LogManager.getLogger(this.getClass());
    private final String className = this.getClass().toString();


    @Value("${sal_kuk_rate}")
    private Double sal_kuk_rate;
    @Value("${sal_kun_rate}")
    private Double sal_kun_rate;
    @Value("${sal_ko_rate}")
    private Double sal_ko_rate;
    @Value("${sal_san_rate}")
    private Double sal_san_rate;

    
	@Value("${fileUpload.rootPath}")
	private String rootPath;    // W:\\FileRepository
	
	@Value("${fileUpload.virtualRootPath}")
	private String virtualrootPath;  // /serverfile
	
	@Value("${fileUpload.noticePath}")
	private String noticePath;   // notice
	
	
    
    @Override
    public String maxMethod3(Map<String, Object> paramMap) {
        return empDao.maxMethod3(paramMap);
    }



    @Override
    public List<EmpModel> empList(Map<String, Object> paramMap) throws Exception {
        return empDao.empList(paramMap);
    }

    @Override
    public int countempList(Map<String, Object> paramMap) throws Exception {
        return empDao.countempList(paramMap);
    }

    @Override
    public EmpModel empSelectOne(Map<String, Object> paramMap) throws Exception {
        return empDao.empSelectOne(paramMap);
    }

 @Override
    public int empInsert(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {

	 MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
	 String noticedir = File.separator + noticePath + File.separator;
	 FileUtilCho fileup = new FileUtilCho(multipartHttpServletRequest,rootPath, virtualrootPath, noticedir);
	 Map filereturn = fileup.uploadFiles();
	 
	 String upfile = (String) filereturn.get("file_nm");
	 paramMap.put("fileprc", "Y");
	 
		if(upfile == "" || upfile == null) {
			paramMap.put("fileexist", "N");
		} else {

			paramMap.put("filereturn", filereturn);
			paramMap.put("fileexist", "Y");

			empDao.fileinsert(paramMap);
		}
	 
     int emp_yr_sal=0;

     String levelCd = (String) paramMap.get("level_cd");
     String[] level_cdArray= {"10","20","30","40","50","60","70","80","90"};
     int[] emp_yr_salArray  = {30000000,35000000,40000000,45000000,50000000,55000000,60000000,65000000,70000000};
     for (int i=0; i<level_cdArray.length; i++) {
         if(level_cdArray[i].equals(levelCd)) {
             emp_yr_sal = emp_yr_salArray[i];
             break;
         }
     }

       // double emp_yr_salD = (double) emp_yr_sal ;
        double sal_pre =emp_yr_sal/12.0;
        double sal_kuk = sal_pre * sal_kuk_rate;
        double sal_kun = sal_pre * sal_kun_rate;
        double sal_ko = sal_pre * sal_ko_rate;
        double sal_san = sal_pre * sal_san_rate;
        double sal_after = sal_pre - sal_kuk - sal_kun - sal_ko - sal_san;

        paramMap.put("emp_yr_sal", emp_yr_sal);
        paramMap.put("sal_pre", sal_pre);
        paramMap.put("sal_kuk", sal_kuk);
        paramMap.put("sal_kun", sal_kun);
        paramMap.put("sal_ko", sal_ko);
        paramMap.put("sal_san", sal_san);
        paramMap.put("sal_after", sal_after);

        logger.info("+ jjhhhhhhhEnd " + paramMap + ".emplist");

        return empDao.empInsert(paramMap);
    }

 
    @Override
    public int empUpdate(Map<String, Object> paramMap, HttpServletRequest request) throws Exception {
       
    	int emp_yr_sal=0;

        String levelCd = (String) paramMap.get("level_cd");
        String[] level_cdArray= {"10","20","30","40","50","60","70","80","90"};
        int[] emp_yr_salArray  = {30000000,35000000,40000000,45000000,50000000,55000000,60000000,65000000,70000000};
        for (int i=0; i<level_cdArray.length; i++) {
            if(level_cdArray[i].equals(levelCd)) {
                emp_yr_sal = emp_yr_salArray[i];
                break;
            }
        }

        // double emp_yr_salD = (double) emp_yr_sal ;
        double sal_pre =emp_yr_sal/12.0;
        double sal_kuk = sal_pre * sal_kuk_rate;
        double sal_kun = sal_pre * sal_kun_rate;
        double sal_ko = sal_pre * sal_ko_rate;
        double sal_san = sal_pre * sal_san_rate;
        double sal_after = sal_pre - sal_kuk - sal_kun - sal_ko - sal_san;

        paramMap.put("emp_yr_sal", emp_yr_sal);
        paramMap.put("sal_pre", sal_pre);
        paramMap.put("sal_kuk", sal_kuk);
        paramMap.put("sal_kun", sal_kun);
        paramMap.put("sal_ko", sal_ko);
        paramMap.put("sal_san", sal_san);
        paramMap.put("sal_after", sal_after);
        
        EmpModel selectone = empDao.empSelectOne(paramMap);
        
		if(selectone.getFile_name() != "" && selectone.getFile_name() != null) {
			File attfile = new File(selectone.getPhysic_path());  
			attfile.delete();
			
			empDao.deletefileinfo(paramMap);
		} 
				
		
    	MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
    	
    	String noticedir = File.separator + noticePath + File.separator;
    	FileUtilCho fileup = new FileUtilCho(multipartHttpServletRequest,rootPath, virtualrootPath, noticedir);
    	Map filereturn = fileup.uploadFiles();
    	
    	String upfile = (String) filereturn.get("file_nm");
    	paramMap.put("fileprc", "Y");
    	
		
		if(upfile == "" || upfile == null) {
			paramMap.put("fileexist", "N");
		} else {
			paramMap.put("filereturn", filereturn);
			paramMap.put("fileexist", "Y");
			
			empDao.fileinsert(paramMap);
		}
        
        return empDao.empUpdate(paramMap);
    }//업데이트 종료

    
    @Override
    public int empDelete(Map<String, Object> paramMap) throws Exception {
        
    	EmpModel selectone = empDao.empSelectOne(paramMap);
		
		if(selectone.getFile_name() != "" && selectone.getFile_name() != null) {
			File attfile = new File(selectone.getPhysic_path());     
			attfile.delete();
			
			empDao.deletefileinfo(paramMap);
		} //딜리트 종료
    	
    	return empDao.empDelete(paramMap);
    }
    
    

    @Override
    public int vaceInsert(Map<String, Object> paramMap) throws Exception {
        int dt_va_tot=0;
        int dt_vaca_rest = 0;


        String levelCd = (String) paramMap.get("level_cd");
        String[] level_cdArray= {"10","20","30","40","50","60","70","80","90"};
        int[] dt_va_totArray  = {12,13,14,15,16,17,18,19,20,21};
        for (int i=0; i<level_cdArray.length; i++) {
            if(level_cdArray[i].equals(levelCd)) {
                dt_va_tot = dt_va_totArray[i];
                break;
            }
        }
        dt_vaca_rest = dt_va_tot;
        paramMap.put("dt_va_tot", dt_va_tot);
        paramMap.put("dt_vaca_rest", dt_vaca_rest);
        return empDao.vaceInsert(paramMap);
    }
    
    
    

    @Override
    public int vaceUpdate(Map<String, Object> paramMap) throws Exception {
        int dt_va_tot=0;
        int dt_vaca_rest = 0;


        String levelCd = (String) paramMap.get("level_cd");
        String[] level_cdArray= {"10","20","30","40","50","60","70","80","90"};
        int[] dt_va_totArray  = {12,13,14,15,16,17,18,19,20,21};
        for (int i=0; i<level_cdArray.length; i++) {
            if(level_cdArray[i].equals(levelCd)) {
                dt_va_tot = dt_va_totArray[i];
                break;
            }
        }
        dt_vaca_rest = dt_va_tot;
        paramMap.put("dt_va_tot", dt_va_tot);
        paramMap.put("dt_vaca_rest", dt_vaca_rest);
        
        return empDao.vaceUpdate(paramMap);
    }


}
