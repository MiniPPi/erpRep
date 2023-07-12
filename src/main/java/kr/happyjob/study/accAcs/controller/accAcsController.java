package kr.happyjob.study.accAcs.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
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

import kr.happyjob.study.accAcs.model.accAcsModel;
import kr.happyjob.study.accAcs.service.accAcsService;
import kr.happyjob.study.common.comnUtils.ComnCodUtil;
import kr.happyjob.study.mngNot.model.NoticeModel;
import kr.happyjob.study.mngNot.service.MngNotService;
import kr.happyjob.study.system.model.comcombo;

@Controller
@RequestMapping("/accAcs/")
public class accAcsController {
   
   @Autowired
   accAcsService AccAcsService;
   
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   
   
   /**
    * 초기화면
    */
   @RequestMapping("accountSearch.do")
   public String accountSearch(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".accAcs");
      logger.info("   - paramMap : " + paramMap);
      
      logger.info("+ End " + className + ".accAcs");

      return "accAcs/accountSearchList";
      
   }
       

   /**
    * 검색
    */
   @RequestMapping("accountSearchList.do")
   public String accountSearchList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
		   HttpServletResponse response, HttpSession session) throws Exception {
	   
	   logger.info("+ Start " + className + ".accAcs");
	   logger.info("   - paramMap12312322 : " + paramMap);
	   
	   
	   System.out.println("랄랄랄라" + paramMap);
	    
	   logger.info("+ End " + className + ".accAcs");
	   
       int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
       int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
       int pageindex = (pagenum - 1) * pageSize;
       
       paramMap.put("pageSize", pageSize);
       paramMap.put("pageindex", pageindex);
       
       
       
       List<accAcsModel> accountSearchList = AccAcsService.accountSearchList(paramMap);
       
       int totalcnt = AccAcsService.countactlist(paramMap);

       
       model.addAttribute("accountSearchList", accountSearchList);
       model.addAttribute("totalcnt", totalcnt);
       
       
       
       logger.info("+ - paramMap2222222222222 " + accountSearchList);
       
       logger.info("+ End " + className + ".accountSearchList");

       return "accAcs/accountSearchListGrd";
       
	   
   }
   
   
   
   @RequestMapping("accountSearchSelectone.do")
   @ResponseBody
   public Map<String, Object> accountSearchSelectone(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".accountSearcheselectone");
      logger.info("   - paramMap : " + paramMap);
      
      // Controller  Service  Dao  SQL
      accAcsModel accountSearchSelectone= AccAcsService.accountSearchSelectone(paramMap);
      
      Map<String, Object> returnmap = new HashMap<String, Object>();

      returnmap.put("accountSearchSelectone", accountSearchSelectone);
      
      logger.info("+ End " + className + ".accountSearchSelectone");

      return returnmap;
   }  
   
	   
	   
      
}