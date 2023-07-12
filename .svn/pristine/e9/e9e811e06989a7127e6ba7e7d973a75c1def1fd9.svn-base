package kr.happyjob.study.empMpg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.empMpg.model.EmpMpgModel;
import kr.happyjob.study.empMpg.service.EmpMpgService;




@Controller
@RequestMapping("/empMpg/")
public class EmpMpgController {
   
   @Autowired
   EmpMpgService empMpgService;
   
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   
   
   /**
    * 초기화면
    */
   @RequestMapping("empMypage.do")
   public String empMypage(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".empMypage");
      logger.info("   - paramMap : " + paramMap);
      
      model.addAttribute("usertype",  (String) session.getAttribute("userType"));
      model.addAttribute("cloginId",  (String) session.getAttribute("loginId"));
      
      logger.info("+ End " + className + ".empMypage");

      return "empMpg/empMypage";
   }
   
   @RequestMapping("empMypageList.do")
   public String empMypageList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".empMypageList");
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
      
      List<EmpMpgModel> listSearch = empMpgService.empMypageList(paramMap);
      int totalcnt = empMpgService.countList(paramMap);
      
      model.addAttribute("listSearch", listSearch);
      model.addAttribute("totalcnt", totalcnt);
      
      
      logger.info("+ End " + className + ".empMypageList");

      return "empMpg/empMypageGrd";
   }
       
   @RequestMapping("listSelectOneMpg.do")
   @ResponseBody
   public Map<String, Object> listSelectOneMpg(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".listSelectOneMpg.do");
      logger.info("   - paramMap : " + paramMap);
      
    
      EmpMpgModel listSearch = empMpgService.listSelectOneMpg(paramMap);
      
      Map<String, Object> returnmap = new HashMap<String, Object>();
      
      returnmap.put("listSearch", listSearch);
      logger.info("   - listSearch : " + listSearch);
      
      logger.info("+ End " + className + ".listSelectOneMpg.do");

      return returnmap;
   }  
   
   
   
   @RequestMapping("listSaveFileMpg.do")
   @ResponseBody
   public Map<String, Object> listSaveFileMpg(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".listSaveFileMpg");
      logger.info("   - paramMap : " + paramMap);
      
      String action = (String) paramMap.get("action");
      String currentLoginID = (String) session.getAttribute("loginId");
      String currentuserType = (String) session.getAttribute("userType");
      
      paramMap.put("currentLoginID", currentLoginID);
      paramMap.put("currentuserType", currentuserType);
     /* paramMap.put("loginID", (String) session.getAttribute("loginId"));*/
      
      int returncval = 0;
      
      if("U".equals(action)) {
    	  returncval = empMpgService.listUpdateFileMpg(paramMap,request);
      }    
      
      Map<String, Object> returnmap = new HashMap<String, Object>();
      
      returnmap.put("returncval", returncval);
      
      logger.info("+ End " + className + ".listSaveFileMpg");

      return returnmap;
   }  
   
  
   
	   
      
}