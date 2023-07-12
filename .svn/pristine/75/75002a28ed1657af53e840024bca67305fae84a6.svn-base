package kr.happyjob.study.selSaM.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.happyjob.study.selSaM.model.SelSaMModel;
import kr.happyjob.study.selSaM.service.SelSaMService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/selSaM/")
public class SelSaMController {
   
   @Autowired
   SelSaMService selSaMService;
   
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   
   
   /**
    * 초기화면
    */
   @RequestMapping("saleMonth.do")
   public String saleMonth(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".saleMonth");
      logger.info("   - paramMap : " + paramMap);
      
      logger.info("+ End " + className + ".saleMonth");

      return "selSaM/saleMonthList";
      
   }
   /**
    * 목록 조회
    */
   @RequestMapping("saleMonthList.do")
   public String saleMonthList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                             HttpServletResponse response, HttpSession session) throws Exception {

      logger.info("+ Start " + className + ".saleMonthList");
      logger.info("   - paramMap : " + paramMap);

      int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
      int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
      int pageindex = (pagenum - 1) * pageSize;

      paramMap.put("pageSize", pageSize);
      paramMap.put("pageIndex", pageindex);

      // Controller -> Service -> Dao -> SQL
      List<SelSaMModel> saleMonthSearchList = selSaMService.saleMonthList(paramMap);

      int totalcnt = selSaMService.countSaleMonthList(paramMap);
      String orderMonth = (String)paramMap.get("order_month");
      System.out.println("orderMonth" + orderMonth + "d");
      if(orderMonth == null || orderMonth.equals("")) {

      }else {
         for(int i=0; i<saleMonthSearchList.size(); i++) {
            if (saleMonthSearchList.get(i).getOrder_month().equals(orderMonth)) {
               break;
            }else {
               totalcnt = 0;
            }
            System.out.println("orderMonth" + saleMonthSearchList.get(i).getOrder_month() );
         }
      }



      model.addAttribute("saleMonthSearchList", saleMonthSearchList);
      model.addAttribute("totalcnt", totalcnt);

      logger.info("+ End " + className + ".saleMonthList");

      return "selSaM/saleMonthListGrd";
   }

   @RequestMapping("selectedMonthChart.do")
   @ResponseBody
   public List<SelSaMModel> selectedMonthChart(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                                               HttpServletResponse response, HttpSession session) throws Exception {
      logger.info("+ Start " + className + ".selectedMonthChart");
      logger.info("   - paramMap : " + paramMap);

      // Controller -> Service -> Dao -> SQL
      List<SelSaMModel> selectedMonthChart = selSaMService.saleMonthList(paramMap);


      logger.info("+ End " + className + ".selectedMonthChart");

      return selectedMonthChart;
   }




}
   
   
   

	   
	   
      
