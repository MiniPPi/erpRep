package kr.happyjob.study.empSas.controller;


import java.util.Map;

import javax.servlet.http.Cookie;
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




import kr.happyjob.study.empSas.model.SalSerarchModel;
import kr.happyjob.study.empSas.service.EmpSasService;

@Controller
@RequestMapping("/empSas/")
public class EmpSasController {
   
   @Autowired
   EmpSasService empSasService;
   
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   
   
   /**
    * 초기화면
    */
   @RequestMapping("salSerarch.do")
   public String salSearch(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".salSearch");
      logger.info("   - paramMap : " + paramMap); //println으로 값이 들어왔는지 확인하는거ㄴ
      
      String loginID = (String)session.getAttribute("loginId");
      model.addAttribute("loginID",loginID);
      
      logger.info("+ End " + className + ".salSearch");

      return "empSas/salSerarch";
   }
   
   //개인 급여 내역서 조회
   @RequestMapping("salSerarchList1.do")
   public String salManagementList1(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + "salManagementList1");
      logger.info("   - paramMap : " + paramMap);
      
      
      
      // Controller  Service  Dao  SQL
      SalSerarchModel empSasSearchList1 = empSasService.empSasList1(paramMap);
      int totalcount = empSasService.empSasCount(paramMap);
      
      model.addAttribute("empSasSearchList1", empSasSearchList1);
      model.addAttribute("totalcount", totalcount);
      
      
      logger.info("+ End " + className + ".salManagementList1");

      return "empSas/salSerarchGrd1";
   }
   
   @RequestMapping("salSerarchList2.do")
   public String salManagementList2(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + "salManagementList2");
      logger.info("   - paramMap : " + paramMap);
      
      
      
      // Controller  Service  Dao  SQL
      SalSerarchModel empSasSearchList2 = empSasService.empSasList2(paramMap);
      int totalcount = empSasService.empSasCount(paramMap);
      
      model.addAttribute("empSasSearchList2", empSasSearchList2);
      model.addAttribute("totalcount", totalcount);
      
      
      logger.info("+ End " + className + ".salManagementList2");

      return "empSas/salSerarchGrd2";
   }
   
}