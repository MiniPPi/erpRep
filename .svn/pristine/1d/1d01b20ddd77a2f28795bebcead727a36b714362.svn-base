package kr.happyjob.study.accEpr.controller;

import java.io.File;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.accEpr.model.AccEprModel;
import kr.happyjob.study.accEpr.service.AccEprService;
import kr.happyjob.study.mngNot.model.NoticeModel;

@Controller
@RequestMapping("/accEpr/")
public class AccEprController {
   
   @Autowired
   AccEprService accEprService;
   
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   
   
   /**
    * 초기화면
    */
   @RequestMapping("expenseRequire.do")
   public String ExpenseRequire(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".expenseRequire");
      logger.info("   - paramMap : " + paramMap);
      
      logger.info("+ End " + className + ".expenseRequire");

      return "accEpr/expenseRequireList";
   }
   
   @RequestMapping("expenseRequireList.do")
   public String expenseRequireList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".expenseRequireList");
      logger.info("   - paramMap : " + paramMap);
      
     
      
      int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
      int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
      int pageIndex = (pagenum - 1) * pageSize;
     
      
      
      paramMap.put("pageSize", pageSize);
      paramMap.put("pageIndex", pageIndex);

      
      String currentLoginID = (String) session.getAttribute("loginId");
      String currentuserType = (String) session.getAttribute("userType");
      
      paramMap.put("currentLoginID", currentLoginID);
      paramMap.put("currentuserType", currentuserType);
      
      
      List<AccEprModel> listSearch = accEprService.expenseRequireList(paramMap);
      int totalcnt = accEprService.countList(paramMap);
      
      model.addAttribute("listSearch", listSearch);
      model.addAttribute("totalcnt", totalcnt);
      
      
      logger.info("+ End " + className + ".expenseRequireList");

      return "accEpr/expenseReListGrd";
   }
       
   @RequestMapping("listSelectOne.do")
   @ResponseBody
   public Map<String, Object> listSelectOne(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".listSelectOne.do");
      logger.info("   - paramMap : " + paramMap);
      
    
      AccEprModel listSearch = accEprService.listSelectOne(paramMap);
      
      Map<String, Object> returnmap = new HashMap<String, Object>();
      
      returnmap.put("listSearch", listSearch);
      logger.info("   - listSearch : " + listSearch);
      
     
      logger.info("+ End " + className + ".listSelectOne.do");
      
      return returnmap;
   }  
   
 
   @RequestMapping("listSaveFile.do")
   @ResponseBody
   public Map<String, Object> listSaveFile(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".listSaveFile");
      logger.info("   - paramMap : " + paramMap);
      
      String action = (String) paramMap.get("action");
      
     paramMap.put("loginID", (String) session.getAttribute("loginId"));
      
      int returncval = 0;
      
      if("I".equals(action)) {
    	  returncval = accEprService.listInsertFile(paramMap,request);
      } else if("U".equals(action)) {
    	  returncval = accEprService.listUpdateFile(paramMap,request);
      } else if("D".equals(action)) {
    	  returncval = accEprService.listDeleteFile(paramMap);
      }      
      
      Map<String, Object> returnmap = new HashMap<String, Object>();
      
      returnmap.put("returncval", returncval);
      
      logger.info("+ End " + className + ".listSaveFile");

      return returnmap;
   }  
   
	@RequestMapping("downloadListFile.do")
	public void downloadListFile(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
	
		logger.info("+ Start " + className + ".downloadListFile");
		logger.info("   - paramMap : " + paramMap);
		
		// 첨부파일 조회
		AccEprModel listSearch = accEprService.listSelectOne(paramMap);  // file 이름    , 물리경로
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File(listSearch.getPhysic_path()));
		
		response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(listSearch.getFile_name(),"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();

		logger.info("+ End " + className + ".downloadListFile");
	}
	   
	   
      
}