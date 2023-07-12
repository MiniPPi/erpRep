package kr.happyjob.study.selSaD.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.happyjob.study.selSaD.model.SelSaDModel;
import kr.happyjob.study.selSaD.model.SelcectedDayModel;
import kr.happyjob.study.selSaD.service.SelSaDService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/selSaD/")
public class SelSaDController {

    @Autowired
    SelSaDService selSaDService;

    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Get class name for logger
    private final String className = this.getClass().toString();


    /**
     * 초기화면
     */
    @RequestMapping("saleDay.do")
    public String saleDay(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                          HttpServletResponse response, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".saleDay");
        logger.info("   - paramMap : " + paramMap);

        logger.info("+ End " + className + ".saleDay");

        return "selSaD/saleDayList";

    }
//
    /**
     * 목록 조회
     */
    @RequestMapping("saleDayList.do")
    public String saleDayList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                              HttpServletResponse response, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".saleDayList");
        logger.info("   - paramMap : " + paramMap);

        int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
        int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
        int pageindex = (pagenum - 1) * pageSize;

        paramMap.put("pageSize", pageSize);
        paramMap.put("pageindex", pageindex);

        // Controller -> Service -> Dao -> SQL
        List<SelSaDModel> saleDaySearchList = selSaDService.saleDayList(paramMap);
        model.addAttribute("saleDaySearchList", saleDaySearchList);
        int totalcnt = selSaDService.countSaleDayList(paramMap);
        model.addAttribute("totalcnt", totalcnt);


        logger.info("+ End " + className + ".saleDayList");

        return "selSaD/saleDayListGrd";
    }
    /**
     * 선택된 날짜 목록 조회
     */
    @RequestMapping("selectedDayList.do")
    public String selectedDayList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                                                   HttpServletResponse response, HttpSession session) throws Exception {
        logger.info("+ Start " + className + ".selectedDayList");
        logger.info("   - paramMap : " + paramMap);

        // Controller -> Service -> Dao -> SQL
        List<SelcectedDayModel> selectedDaySearchList = selSaDService.selectedDayList(paramMap);
        model.addAttribute("selectedDaySearchList",selectedDaySearchList);

        logger.info("+ End " + className + ".selectedDayList");

        return "selSaD/selectedDayListGrd";
    }
    @RequestMapping("selectedDayChart.do")
    @ResponseBody
    public List<SelcectedDayModel> selectedDayChart(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                                  HttpServletResponse response, HttpSession session) throws Exception {
        logger.info("+ Start " + className + ".selectedDayChart");
        logger.info("   - paramMap : " + paramMap);

        // Controller -> Service -> Dao -> SQL
        List<SelcectedDayModel> selectedDayChart = selSaDService.selectedDayList(paramMap);


        logger.info("+ End " + className + ".selectedDayChart");

        return selectedDayChart;
    }



}







