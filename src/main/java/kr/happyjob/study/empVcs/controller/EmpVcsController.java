package kr.happyjob.study.empVcs.controller;

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


import kr.happyjob.study.empVcs.model.VacaSearchModel;
import kr.happyjob.study.empVcs.service.EmpVcsService;

@Controller
@RequestMapping("/empVcs/")
public class EmpVcsController {
   
   @Autowired
   EmpVcsService empVcsService;
   
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   
   
   /**
    * 초기화면
    */
   @RequestMapping("vacaSearch.do")
   public String vacaSearch(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".vacaSearch");
      logger.info("   - paramMap : " + paramMap); //println으로 값이 들어왔는지 확인하는거ㄴ
      
      logger.info("+ End " + className + ".vacaSearch");

      return "empVcs/vacaSearch";
   }
   
   //휴가신청목록 조회
   @RequestMapping("vacaSearchList.do")
   public String vacaSearchList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + "vacaSearchList");
      logger.info("   - paramMap : " + paramMap);
      
      int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
      int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
      int pageindex = (pagenum - 1) * pageSize;
      
      paramMap.put("pageSize", pageSize);
      paramMap.put("pageindex", pageindex);
      
      // Controller  Service  Dao  SQL
      List<VacaSearchModel> empVcsSearchList = empVcsService.empVcsList(paramMap);
      int totalcnt = empVcsService.countEmpVcsList(paramMap);
      
      model.addAttribute("empVcsSearchList", empVcsSearchList);
      model.addAttribute("totalcnt", totalcnt);
      System.out.println("empVcsSearchList"+ empVcsSearchList);
      
      logger.info("+ End " + className + ".vacaSearch");

      return "empVcs/vacaSearchGrd";
   }
   
   
   
   //반려사유 상세조회
   @RequestMapping("vacaRejDetail.do")
   @ResponseBody
   public Map<String, Object> vacaRejDetail(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + "vacaRejDetail");
      logger.info("   - paramMap : " + paramMap);
      
      
     
      String rej = empVcsService.rejDetail(paramMap);
      
      Map<String, Object> reval = new HashMap<>();
      reval.put("rej", rej);
      
      logger.info("+ End " + className + ".vacaInsert");

      return reval;
   }
   
   
   //사번 유무 체크
   @RequestMapping("loginIDChk.do")
   @ResponseBody
   public Map<String, Object> loginIDChk(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + "loginIDChk");
      logger.info("   - paramMap : " + paramMap);
      
      int ID = Integer.parseInt((String)paramMap.get("IDVal"));
      
      ID = empVcsService.loginIDChk(ID);
      
      Map<String, Object> reval = new HashMap<>();
      reval.put("ID", ID);
      
      logger.info("+ End " + className + ".loginIDChk");

      return reval;
   }
       
   
	   
	   
      
}