package kr.happyjob.study.busDlv.controller;


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

import kr.happyjob.study.busDlv.model.DeliveryInfoModel;
import kr.happyjob.study.busDlv.service.BusDlvService;



@Controller
@RequestMapping("/busDlv/")
public class BusDlvController {
   
   @Autowired
   BusDlvService busDlvService;
   
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   
   
   /**
    * 초기화면
    */
   @RequestMapping("deliveryInfo.do")
   public String vacaSearch(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".deliveryInfo");
      logger.info("   - paramMap : " + paramMap);
      
      String loginID = (String)session.getAttribute("loginId");
      model.addAttribute("loginID",loginID);
      

      logger.info("+ End " + className + ".deliveryInfo");

      return "busDlv/deliveryInfo";
   }
   
   //발주목록 리스트
   @RequestMapping("deliveryInfoList.do")
   public String salManagementList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + "deliveryInfoList");
      logger.info("   - paramMap : " + paramMap);
      
      int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
      int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
      int pageindex = (pagenum - 1) * pageSize;
      
      paramMap.put("pageSize", pageSize);
      paramMap.put("pageindex", pageindex);
      
      // Controller  Service  Dao  SQL
      List<DeliveryInfoModel> busDlvList = busDlvService.busDlvList(paramMap);
      int totalcnt = busDlvService.countBusDlvList(paramMap);
      
      model.addAttribute("busDlvList", busDlvList);
      model.addAttribute("totalcnt", totalcnt);
      
      
      logger.info("+ End " + className + ".deliveryInfoList" + totalcnt);

      return "busDlv/deliveryInfoGrd";
   }
   
   //반려사유 상세조회
   @RequestMapping("dlvRejDetail.do")
   @ResponseBody
   public Map<String, Object> dlvRejDetail(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + "dlvRejDetail");
      logger.info("   - paramMap : " + paramMap);
      
      
     
      String rej = busDlvService.rejDetail(paramMap);
      
      Map<String, Object> reval = new HashMap<>();
      reval.put("rej", rej);
      
      logger.info("+ End " + className + ".dlvRejDetail" );

      return reval;
   }
   
   //발주신청
   @RequestMapping("dlvInsert.do")
   @ResponseBody
   public Map<String, Object> vacaInsert(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + "dlvInsert");
      logger.info("   - paramMap : " + paramMap);
      
      
      
      
      
      logger.info("+ End " + className + ".dlvInsert");

      return busDlvService.dlvApp(paramMap);
   }
	   
	   
      
}