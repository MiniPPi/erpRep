package kr.happyjob.study.emp.controller;

import kr.happyjob.study.emp.model.EmpModel;
import kr.happyjob.study.emp.service.EmpService;
import kr.happyjob.study.mngNot.model.NoticeModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/empEpm/")
public class empController {
////
     @Autowired
     EmpService empService;

    private final Logger logger = LogManager.getLogger(this.getClass());
    private final String className = this.getClass().toString();

    @RequestMapping("/empmanagement.do")
    public String emp(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                      HttpServletResponse response, HttpSession session)throws Exception{
        logger.info("+ Start " + className  + ".emp");
        logger.info("   - paramMap : " + paramMap);

        logger.info("+ End " + className + ".notice");

        return "emp/empList";

    }
    
    @RequestMapping("emplist.do")
    public String noticelist(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                             HttpServletResponse response, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".emplist");
        logger.info("   - paramMap : " + paramMap);

        int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
        int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
        int pageindex = (pagenum - 1) * pageSize;

        paramMap.put("pageSize", pageSize);
        paramMap.put("pageindex", pageindex);

        // Controller  Service  Dao  SQL
        List<EmpModel> empSearchList = empService.empList(paramMap);
        int totalcnt = empService.countempList(paramMap);

        model.addAttribute("empSearchList", empSearchList);
        model.addAttribute("totalcnt", totalcnt);


        logger.info("+ End " + className + ".emplist");

        return "emp/emplistgrd";
    }
    
    @RequestMapping("/empSelectOne.do")
    @ResponseBody
    public Map<String, Object> empSelectOne(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                                            HttpServletResponse response, HttpSession session) throws Exception{
        logger.info("+ Start " + className + ".empselectone");
        logger.info("   - paramMapdddddd : " + paramMap);

        EmpModel empSearch = empService.empSelectOne(paramMap);

        Map<String, Object> returnmap = new HashMap<String, Object>();

        returnmap.put("empSearch", empSearch);

        logger.info("+ End " + className + ".empselectone");

        return returnmap;

    }

    @RequestMapping("empSave.do")
    @ResponseBody
    public Map<String, Object> empSave(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                                          HttpServletResponse response, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".empSave");
        logger.info("   - paramMap : " + paramMap);

        String action = (String) paramMap.get("action");

        paramMap.put("loginid", (String) session.getAttribute("loginId"));

        int returncval = 0;

        if("I".equals(action)) {
            logger.info("   - insert : " + paramMap);
            returncval = empService.empInsert(paramMap,request);
            
            String max3 = empService.maxMethod3(paramMap);
            logger.info("   - max2 : " + max3);
            paramMap.put("max3",max3);
             empService.vaceInsert(paramMap);
      
        } else if("U".equals(action)) {
            logger.info("   - update : " + paramMap);
            logger.info("   - updateemp_sexemp_sex : " + paramMap.get("emp_sex"));
            
            logger.info("   - vaceUpdate안녕 : " + paramMap);
            returncval = empService.empUpdate(paramMap,request);
            empService.vaceUpdate(paramMap);
            
            logger.info("   - vaceUpdate안녕안녕 : " + paramMap);
            
        } else if("D".equals(action)) {
            logger.info("   - delete : " + paramMap);
            returncval = empService.empDelete(paramMap);
        }


        Map<String, Object> returnmap = new HashMap<String, Object>();

        returnmap.put("returncval", returncval);

        logger.info("+ End " + className + ".empSave");
        logger.info("+ End " + className + ".empSave");

        return returnmap;
    }

}
