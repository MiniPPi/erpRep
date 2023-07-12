package kr.happyjob.study.accEps.controller;

import java.io.File;
import java.net.URLEncoder;
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

import kr.happyjob.study.accEps.model.AccEpsModel;
import kr.happyjob.study.accEps.service.AccEpsService;


@Controller
@RequestMapping("/accEps/")
public class AccEpsController {
   
   @Autowired
   AccEpsService accEpsService;
   
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   
   
   /**
    * 초기화면
    */
   @RequestMapping("expenseSearch.do")
   public String expenseSearch(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".expenseSearch");
      logger.info("   - paramMap : " + paramMap);
      
      logger.info("+ End " + className + ".expenseSearch");

      return "accEps/expenseSearch";
   }
   
   @RequestMapping("expenseSearchList.do")
   public String expenseSearchList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".expenseSearchList");
      logger.info("   - paramMap : " + paramMap);
      
      int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
      int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
      int pageIndex = (pagenum - 1) * pageSize;
      
      paramMap.put("pageSize", pageSize);
      paramMap.put("pageIndex", pageIndex);
      
      
      List<AccEpsModel> listSearch = accEpsService.expenseSearchList(paramMap);
      int totalcnt = accEpsService.countList(paramMap);
      
      model.addAttribute("listSearch", listSearch);
      model.addAttribute("totalcnt", totalcnt);
      
      
      logger.info("+ End " + className + ".expenseSearchList");

      return "accEps/expenseSeGrd";
   }
       
   @RequestMapping("listSelectOneEps.do")
   @ResponseBody
   public Map<String, Object> listSelectOneEps(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".listSelectOneEps.do");
      logger.info("   - paramMap : " + paramMap);
      
    
      AccEpsModel listSearch = accEpsService.listSelectOneEps(paramMap);
      
      Map<String, Object> returnmap = new HashMap<String, Object>();
      
      returnmap.put("listSearch", listSearch);
      logger.info("   - listSearch : " + listSearch);
      
      logger.info("+ End " + className + ".listSelectOneEps.do");

      return returnmap;
   }  
   
   @RequestMapping("listSaveEps.do")
   @ResponseBody
   public Map<String, Object> listSaveEps(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".listSaveEps");
      logger.info("   - paramMap : " + paramMap);
      
      String action = (String) paramMap.get("action");
//      int expen_price = Integer.parseInt((String) paramMap.get("expen_price"));
//      
//      paramMap.put("expen_price", expen_price);
      paramMap.put("loginID", (String) session.getAttribute("loginID"));
      
      
      int returncval = 0;
      
      if("U".equals(action)) {
    	  returncval = accEpsService.listUpdateEps(paramMap);
      } 
      Map<String, Object> returnmap = new HashMap<String, Object>();
      
      returnmap.put("returncval", returncval);
      
      logger.info("+ End " + className + ".listSaveEps");

      return returnmap;
   }    
   
   
   @RequestMapping("listSaveFileEps.do")
   @ResponseBody
   public Map<String, Object> listSaveFileEps(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".listSaveFileEps");
      logger.info("   - paramMap : " + paramMap);
      
      String action = (String) paramMap.get("action");
      
     paramMap.put("loginID", (String) session.getAttribute("loginId"));
      
      int returncval = 0;
      
      if("U".equals(action)) {
    	  returncval = accEpsService.listUpdateFileEps(paramMap,request);
      }    
      
      Map<String, Object> returnmap = new HashMap<String, Object>();
      
      returnmap.put("returncval", returncval);
      
      logger.info("+ End " + className + ".listSaveFileEps");

      return returnmap;
   }  
   
	@RequestMapping("downloadListFileEps.do")
	public void downloadListFileEps(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
	
		logger.info("+ Start " + className + ".downloadListFileEps");
		logger.info("   - paramMap : " + paramMap);
		
		// 첨부파일 조회
		AccEpsModel listSearch = accEpsService.listSelectOneEps(paramMap);  // file 이름    , 물리경로
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File(listSearch.getPhysic_path()));
		
		response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(listSearch.getFile_name(),"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();

		logger.info("+ End " + className + ".downloadListFileEps");
	}
	   
	   
      
}