
package kr.happyjob.study.busPd.controller;
import kr.happyjob.study.busPd.model.BusPdModel;
import kr.happyjob.study.busPd.service.BusPdService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/busPd/")
public class BusPdController {

    @Autowired
    BusPdService busPdService;

    // Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Get class name for logger
    private final String className = this.getClass().toString();


    /**
     * 초기화면
     */
    @RequestMapping("productInfo.do")
    public String productInfo(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                              HttpServletResponse response, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".productInfo");
        logger.info("   - paramMap: " + paramMap);


        logger.info("+ End " + className + ".productInfo");

        return "busPd/productList";
    }
    /**
     * 목록 조회
     */
    @RequestMapping("productList.do")
    public String productList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                              HttpServletResponse response, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".productList");
        logger.info("   - paramMap : " + paramMap);

        int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
        int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
        int pageindex = (pagenum - 1) * pageSize;

        paramMap.put("pageSize", pageSize);
        paramMap.put("pageindex", pageindex);

        // Controller -> Service -> Dao -> SQL
        List<BusPdModel> productSearchList = busPdService.productList(paramMap);
        int totalcnt = busPdService.countProductList(paramMap);

        model.addAttribute("productSearchList", productSearchList);
        model.addAttribute("totalcnt", totalcnt);

        logger.info("+ End " + className + ".productList");

        return "busPd/productListGrd";
    }

    /**
     * 한건 조회
     */
    @RequestMapping("productSelectOne.do")
    @ResponseBody
    public Map<String, Object> productSelectOne(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                                             HttpServletResponse response, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".productSelectOne");
        logger.info("   - paramMap : " + paramMap);

        // Controller  Service  Dao  SQL
        BusPdModel productSearch = busPdService.productSelectOne(paramMap);

        Map<String, Object> returnmap = new HashMap<String, Object>();

        returnmap.put("productSearch", productSearch);

        logger.info("+ End " + className + ".productSelectOne");

        return returnmap;
    }

    /**
     * 생성, 수정, 삭제
     */
    @RequestMapping("productSave.do")
    @ResponseBody
    public Map<String, Object> productSave(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
                                        HttpServletResponse response, HttpSession session) throws Exception {

        logger.info("+ Start " + className + ".productSave");
        logger.info("   - paramMap : " + paramMap);

        String action = (String) paramMap.get("action");

        paramMap.put("loginid", (String) session.getAttribute("loginId"));


        int returncval = 0;

        if("I".equals(action)) {
            returncval = busPdService.productInsert(paramMap);
        } else if("U".equals(action)) {
            returncval = busPdService.productUpdate(paramMap);
        } else if("D".equals(action)) {
            returncval = busPdService.productDelete(paramMap);
        }

        Map<String, Object> returnmap = new HashMap<String, Object>();

        returnmap.put("returncval", returncval);

        logger.info("+ End " + className + ".productSave");

        return returnmap;
    }
}
