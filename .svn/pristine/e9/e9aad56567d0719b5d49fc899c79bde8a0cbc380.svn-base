package kr.happyjob.study.accAcm.controller;

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

import kr.happyjob.study.accAcm.model.accAcmModel;
import kr.happyjob.study.accAcm.service.accAcmService;
import kr.happyjob.study.accAcs.model.accAcsModel;
import kr.happyjob.study.common.comnUtils.ComnCodUtil;
import kr.happyjob.study.mngNot.model.NoticeModel;
import kr.happyjob.study.mngNot.service.MngNotService;
import kr.happyjob.study.system.model.ComnDtlCodModel;

@Controller
@RequestMapping("/accAcm/")
public class accAcmController {
   
   @Autowired
   accAcmService AccAcmService;
   
   // Set logger
   private final Logger logger = LogManager.getLogger(this.getClass());

   // Get class name for logger
   private final String className = this.getClass().toString();
   
   
   
   /**
    * 초기화면
    */
   @RequestMapping("accManagement.do")
   public String accManagement(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".accAcm");
      logger.info("   - paramMap : " + paramMap);
      
      logger.info("+ End " + className + ".accAcm");

      
      
      
      return "accAcm/accAcmList";
   }

   /**
    * 검색
    */
   @RequestMapping("accManagementList.do")
   public String accManagementList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
		   HttpServletResponse response, HttpSession session) throws Exception {
	   
	   logger.info("+ Start " + className + ".accAcm");
	   logger.info("   - paramMap12312322 : " + paramMap);
	   
	   
	   System.out.println("랄랄랄라" + paramMap);
	    
	   logger.info("+ End " + className + ".accAcm");
	   
       int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
       int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
       int pageindex = (pagenum - 1) * pageSize;
       
       paramMap.put("pageSize", pageSize);
       paramMap.put("pageindex", pageindex);
       
       
       List<accAcmModel> accAcmSearchList = AccAcmService.accAcmSearchList(paramMap);
       
       int totalcnt = AccAcmService.countactlist(paramMap);

       model.addAttribute("accAcmSearchList", accAcmSearchList);
       model.addAttribute("totalcnt", totalcnt);
       
       logger.info("+ End " + className + ".accountSearchList");

       return "accAcm/accAcmListGrd";
       
	   
   }
   
   @RequestMapping("bigInsert.do")
   @ResponseBody
   public Map<String, Object> bigInsert(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
         HttpServletResponse response, HttpSession session) throws Exception {
      
      logger.info("+ Start " + className + ".bigInsert");
      logger.info("   - paramMap : " + paramMap);
      
      String action = (String) paramMap.get("action");
      
      paramMap.put("loginid", (String) session.getAttribute("loginId"));
      
      int returncval = 0;
      //초기화
      if("I".equals(action)) {
    	  returncval = AccAcmService.bigInsert(paramMap);
      }
//      } else if("U".equals(action)) {
//    	  returncval = mngNotService.noticeupdate(paramMap);
//      } else if("D".equals(action)) {
//    	  returncval = mngNotService.noticedelete(paramMap);
//      }      
      
      
      
      Map<String, Object> returnmap = new HashMap<String, Object>();

      returnmap.put("returncval", returncval);
      
      logger.info("+ End " + className + ".noticesave");

      return returnmap;
   } 
   
	/**
	 * 공통 상세 코드 목록 조회
	 */
	@RequestMapping("accAcmSList.do")
	public String accAcmSList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".accAcmSList");
		logger.info("   - paramMap5554 : " + paramMap);
		
		
		int currentPage = Integer.parseInt((String)paramMap.get("currentPage"));	// 현재 페이지 번호
		int pageSize = Integer.parseInt((String)paramMap.get("pageSize"));			// 페이지 사이즈
		int pageIndex = (currentPage-1)*pageSize;												// 페이지 시작 row 번호
		

		paramMap.put("pageIndex", pageIndex);
		paramMap.put("pageSize", pageSize);
		
		// 공통 상세코드 목록 조회
		List<accAcmModel> accAcmDtModel = AccAcmService.accAcmSListSearch(paramMap);
		model.addAttribute("accAcmDtModel", accAcmDtModel);
		
		// 공통 상세코드 목록 카운트 조회
		int totalCount = AccAcmService.countSList(paramMap);
		model.addAttribute("totalCount", totalCount);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPageComnDtlCod",currentPage);
		
		logger.info("+ End " + className + ".accAcmModel");

		logger.info("   - paramMap5554888 : " + paramMap);
		return "/accAcm/accAcmListDGrd";
	}	
   
	
	   @RequestMapping("smallInsert.do")
	   @ResponseBody
	   public Map<String, Object> smallInsert(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".smallInsert");
	      logger.info("   - paramMap : " + paramMap);
	      
	      String action = (String) paramMap.get("action");
	      //Ajax에서 설정했던 action값을 가져와서 변수에 대입
	      
	      paramMap.put("loginid", (String) session.getAttribute("loginId"));
	      
	      int returncval = 0;
	      //초기화
	      if("I".equals(action)) {
	    	  returncval = AccAcmService.smallInsert(paramMap);
	      }
//	      } else if("U".equals(action)) {
//	    	  returncval = mngNotService.noticeupdate(paramMap);
//	      } else if("D".equals(action)) {
//	    	  returncval = mngNotService.noticedelete(paramMap);
//	      }      
	      
	      Map<String, Object> returnmap = new HashMap<String, Object>();

	      returnmap.put("returncval", returncval);
	      
	      logger.info("+ End " + className + ".noticesave");

	      return returnmap;
	   } 
	
	   
	   //계정 대분류 코드 중복 확인
	   @RequestMapping("LCdDupChk.do")
	   @ResponseBody
	   public int LCdDupChk(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		   
		   
		   int result = AccAcmService.LCdDupChked(paramMap);

		   logger.info("+ paramMap값 체크 " + paramMap);
		   logger.info("+ result값 체크 " + result);
		   
		   
		   return result;
		   
	   }
	   //계정 대분류 이름 중복 확인
	   @RequestMapping("LNmDupChk.do")
	   @ResponseBody
	   public int LNmDupChk(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			   HttpServletResponse response, HttpSession session) throws Exception {
		   
		   
		   int result = AccAcmService.LNmDupChked(paramMap);
		   
		   logger.info("+ paramMap값 체크NM " + paramMap);
		   logger.info("+ result값 체크NM " + result);
		   
		   
		   return result;
		   
	   }
	   
	   //계정 대분류 코드 중복 확인
	   @RequestMapping("SCdDupChk.do")
	   @ResponseBody
	   public int SCdDupChk(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			   HttpServletResponse response, HttpSession session) throws Exception {
		   
		   
		   int result = AccAcmService.SCdDupChk(paramMap);
		   
		   logger.info("+ paramMapSD값 체크 " + paramMap);
		   logger.info("+ result값SD 체크 " + result);
		   
		   return result;
		   
	   }
	   
	   
	   
	   
	   
	   
      
}