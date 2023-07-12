package kr.happyjob.study.empApm.controller;

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

import kr.happyjob.study.empApm.model.EmpApmModel;
import kr.happyjob.study.empApm.service.EmpApmService;

@Controller
@RequestMapping("/empApm/")
public class EmpApmController {

	@Autowired
	EmpApmService empApmService;

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	/**
	 * 초기화면
	 */
	@RequestMapping("approManagement.do")
	public String approManagement(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".approManagement");
		logger.info("   - approManagement.do ParamMap :: " + paramMap);
		logger.info("+ End " + className + ".approManagement");

		return "empApm/approManagement";
	}

	@RequestMapping("approManagementList.do")
	public String approManagementList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".approManagementList");
		logger.info("   - approManagementList.do ParamMap :: " + paramMap);

		int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
		int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
		int pageindex = (pagenum - 1) * pageSize;

		paramMap.put("pageSize", pageSize);
		paramMap.put("pageindex", pageindex);

		List<EmpApmModel> listSearch = empApmService.approManagementList(paramMap);

		for (EmpApmModel item : listSearch) {
			logger.info("[approManagementList.do] item : " + item.toString());
		}

		int totalcnt = empApmService.countList(paramMap);
		logger.info("[approManagementList.do] totalcnt :: " + totalcnt);

		model.addAttribute("listSearch", listSearch); // listSearch 라는 이름으로
														// 반환합니다.
		model.addAttribute("totalcnt", totalcnt);

		logger.info("+ End " + className + ".approManagementList");

		return "empApm/approManagementGrd";
	}

	@RequestMapping("listSelectOneApm.do")
	@ResponseBody
	public Map<String, Object> listSelectOneApm(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".listSelectOneApm.do");
		logger.info("   - paramMap : " + paramMap);

	
		EmpApmModel listSearch = null;
		logger.info("  type  : " + paramMap.get("type"));
		if ("휴가".equals(paramMap.get("type"))) {
			listSearch = empApmService.getVacationStatus(paramMap);
		} else {
			listSearch = empApmService.listSelectOneApm(paramMap);
		}
		Map<String, Object> returnmap = new HashMap<String, Object>();
		
		returnmap.put("listSearch", listSearch);
		logger.info("   - listSearch : " + listSearch.toString());

		logger.info("+ End " + className + ".listSelectOneApm.do");

		return returnmap;
	}

	@RequestMapping("updateApmStatus.do")
	@ResponseBody
	public Map<String, Object> updateApmStatus(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".updateApmStatus");
		logger.info("   - paramMap : " + paramMap);

		String action = (String) paramMap.get("action");
		logger.info("getAttribute loginID "  + session.getAttribute("loginId"));
		paramMap.put("loginID", (String) session.getAttribute("loginId"));


		Map<String, Object> returncval =  new HashMap<>()	;

		if ("U".equals(action)) {
			returncval = empApmService.updateApmStatus(paramMap);
		}
		
		paramMap.put("acnt_sbject_cd", 2222);
		paramMap.put("acnt_dt_sbject_cd", 2000);
		
		empApmService.listUpdateFileBudApm(paramMap);
		
		
		logger.info("+ End " + className + ".updateApmStatus");
		return returncval;
	}

//	@RequestMapping("listSaveApm.do")
//	@ResponseBody
//	public Map<String, Object> listSaveApm(Model model, @RequestParam Map<String, Object> paramMap,
//			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
//
//		logger.info("+ Start " + className + ".listSaveApm");
//		logger.info("   - paramMap : " + paramMap);
//
//		String action = (String) paramMap.get("action");
//		// int expen_price = Integer.parseInt((String)
//		// paramMap.get("expen_price"));
//		//
//		// paramMap.put("expen_price", expen_price);
//		paramMap.put("loginID", (String) session.getAttribute("loginID"));
//
//		int returncval = 0;
//
//		if ("U".equals(action)) {
//			returncval = empApmService.updateApmStatus(paramMap);
//		}
//		Map<String, Object> returnmap = new HashMap<String, Object>();
//
//		returnmap.put("returncval", returncval);
//
//		logger.info("+ End " + className + ".listSaveApm");
//
//		return returnmap;
//	}

	// @RequestMapping("listSaveFileApm.do")
	// @ResponseBody
	// public Map<String, Object> listSaveFileApm(Model model, @RequestParam
	// Map<String, Object> paramMap, HttpServletRequest request,
	// HttpServletResponse response, HttpSession session) throws Exception {
	//
	// logger.info("+ Start " + className + ".listSaveFileApm");
	// logger.info(" - paramMap : " + paramMap);
	//
	// String action = (String) paramMap.get("action");
	//
	// paramMap.put("loginID", (String) session.getAttribute("loginId"));
	//
	// int returncval = 0;
	//
	// if("U".equals(action)) {
	// returncval = empApmService.listUpdateFileApm(paramMap,request);
	// }
	//
	// Map<String, Object> returnmap = new HashMap<String, Object>();
	//
	// returnmap.put("returncval", returncval);
	//
	// logger.info("+ End " + className + ".listSaveFileApm");
	//
	// return returnmap;
	// }
	

}