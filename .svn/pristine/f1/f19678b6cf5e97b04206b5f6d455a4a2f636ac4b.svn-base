package kr.happyjob.study.empVcp.controller;


import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;


import kr.happyjob.study.empVcp.model.VacaPersonalModel;
import kr.happyjob.study.empVcp.model.VacaPersonalRemainModel;
import kr.happyjob.study.empVcp.service.EmpVcpService;


@Controller
@RequestMapping("/empVcp/")
public class EmpVcpController {
   
   @Autowired
   EmpVcpService empVcpService;
   
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   
   
   /**
    * 초기화면
    */
   @RequestMapping("vacaPersonal.do")
   public String vacaSearch(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".vacaPersonal");
      logger.info("   - paramMap : " + paramMap); //println으로 값이 들어왔는지 확인하는거ㄴ
      
      String loginID = (String)session.getAttribute("loginId");
      model.addAttribute("loginID",loginID);
      
      System.out.println("loginID"+loginID);
      
     
      
      logger.info("+ End " + className + ".vacaPersonal");

      return "empVcp/vacaPersonal";
   }
   
   //휴가신청목록 조회
   @RequestMapping("vacaPersonalList.do")
   public String vacaPersonalList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + "vacaPersonalList");
      logger.info("   - paramMap : " + paramMap);
      
     
      
     
      
      int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
      int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
      int pageindex = (pagenum - 1) * pageSize;
      
      
      paramMap.put("pageSize", pageSize);
      paramMap.put("pageindex", pageindex);
      
      
      // Controller  Service  Dao  SQL
      List<VacaPersonalModel> empVcpSearchList = empVcpService.empVcpList(paramMap);
      int totalcnt = empVcpService.countEmpVcpList(paramMap);
      
      model.addAttribute("empVcpSearchList", empVcpSearchList);
      model.addAttribute("totalcnt", totalcnt);
      
      logger.info("+ End " + className + ".vacaPersonal");

      return "empVcp/vacaPersonalGrd";
   }
   
   
   
   //반려사유 상세조회
   @RequestMapping("vacaRejDetailvcp.do")
   @ResponseBody
   public Map<String, Object> vacaRejDetail(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + "vacaRejDetailvcp");
      logger.info("   - paramMap : " + paramMap);
      
      
     
      String rej = empVcpService.rejDetail(paramMap);
      
      Map<String, Object> reval = new HashMap<>();
      reval.put("rej", rej);
      
      logger.info("+ End " + className + ".vacaInsertvcp");

      return reval;
   }
   
   
   //휴가신청
   @RequestMapping("vacaInsertvcp.do")
   @ResponseBody
   public Map<String, Object> vacaInsert(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + "vacaInsertvcp");
      logger.info("   - paramMap : " + paramMap);
      
      
      int vacaApp = empVcpService.vacaApplication(paramMap);
      int approIn = empVcpService.approIn(paramMap);
      int vacaApproUpdate = empVcpService.vacaApproUpdate();
      
      Map<String, Object> reval = new HashMap<>();
      reval.put("vacaApp", vacaApp);
      reval.put("approIn", approIn);
      reval.put("vacaApproUpdate",vacaApproUpdate);
      
      logger.info("+ End " + className + ".vacaInsertvcp");

      return reval;
   }
   
   
   //잔여연차 확인
   @RequestMapping("vacaRemain.do")
   @ResponseBody
   public List<VacaPersonalRemainModel> vacaRemain(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + "vacaRemain");
      logger.info("   - paramMap : " + paramMap);
      
      List<VacaPersonalRemainModel> vacaRemain = empVcpService.vacaRemain(paramMap);
      
      
      
      
      logger.info("+ End " + className + ".vacaRemain");

      return vacaRemain;
   }
	   
	   
      
}