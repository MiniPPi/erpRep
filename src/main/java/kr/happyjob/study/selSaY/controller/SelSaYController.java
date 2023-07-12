package kr.happyjob.study.selSaY.controller;

import kr.happyjob.study.selSaY.model.SelSaYModel;
import kr.happyjob.study.selSaY.model.SelSaYModel;
import kr.happyjob.study.selSaY.service.SelSaYService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/selSaY/")
public class SelSaYController {
   
   @Autowired
   SelSaYService selSaYService;
   
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   
   
   /**
    * 초기화면
    */
   @RequestMapping("saleYear.do")
   public String saleYear(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".saleYear");
      logger.info("   - paramMap : " + paramMap);
      
      logger.info("+ End " + className + ".saleYear");

      return "selSaY/saleYearList";
      
   }
   /**
    * 목록 조회
    */
   @RequestMapping("saleYearList.do")
   public String saleYearList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                             HttpServletResponse response, HttpSession session) throws Exception {

      logger.info("+ Start " + className + ".saleYearList");
      logger.info("   - paramMap : " + paramMap);

      int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
      int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
      int pageindex = (pagenum - 1) * pageSize;

      paramMap.put("pageSize", pageSize);
      paramMap.put("pageindex", pageindex);

      // Controller -> Service -> Dao -> SQL
      List<SelSaYModel> saleYearSearchList = selSaYService.saleYearList(paramMap);
      int totalcnt = selSaYService.countSaleYearList(paramMap);

      model.addAttribute("saleYearSearchList", saleYearSearchList);
      model.addAttribute("totalcnt", totalcnt);

      logger.info("+ End " + className + ".saleYearList");

      return "selSaY/saleYearListGrd";
   }

   @RequestMapping("selectedYearChart.do")
   @ResponseBody
   public List<SelSaYModel> selectedYearChart(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                                               HttpServletResponse response, HttpSession session) throws Exception {
      logger.info("+ Start " + className + ".selectedYearChart");
      logger.info("   - paramMap : " + paramMap);

      // Controller -> Service -> Dao -> SQL
      List<SelSaYModel> selectedYearChart = selSaYService.saleYearList(paramMap);


      logger.info("+ End " + className + ".selectedYearChart");

      return selectedYearChart;
   }






}
   
   
   

	   
	   
      
