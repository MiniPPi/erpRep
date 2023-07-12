package kr.happyjob.study.calDay.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.happyjob.study.calDay.model.CalDayModel;
import kr.happyjob.study.calDay.service.CalDayService;

import org.json.JSONArray;
import org.json.JSONObject;

@Controller
@RequestMapping("/calDay/")
public class CalDayController {

	@Autowired
	CalDayService calDayService;

	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());

	// Get class name for logger
	private final String className = this.getClass().toString();

	/* 달력메인페이지조회 */
	@RequestMapping("datecheck.do")
	public String datecheck(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {

		logger.info("+ Start " + className + ".calDay");
		logger.info("   - paramMap : " + paramMap);

		logger.info("+ End " + className + ".calDay");

		return "calDay/calen";

	}

	/* 근태현황조회 */
	@RequestMapping(value = "dateCheckList.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String dateCheckList(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		logger.info("+ Start " + className + ".dateCheckList");
		logger.info("   - paramMap : " + paramMap);
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();

		List<CalDayModel> dateCheckList = calDayService.dateCheckList(paramMap);
		logger.info("   - dateCheckDList : " + dateCheckList);

		for (CalDayModel dto : dateCheckList) {
			// JSONObject json = new JSONObject();

			Map<String, Object> calendarDayMap = new HashMap<String, Object>();
			calendarDayMap.put("appro_yn", dto.getAppro_yn());
			calendarDayMap.put("vaca_req_date", dto.getVaca_req_date());
			calendarDayMap.put("name", dto.getDetail_name());
			calendarDayMap.put("vaca_yn_cnt", dto.getVaca_yn_cnt());
			// calDayModel.put("appro_yn_cnt", dto.getAppro_yn());
			array.put(calendarDayMap);
		}

		object.put("dateCheckList", array);
		/*logger.info("+ End " + className + ".dateCheckList");*/
		return object.toString();
	}

	/* 근태현황조회 */
	@RequestMapping(value = "dateCheckDList.do")
	@ResponseBody
	public Map<String, Object> dateCheckDList(Model model, @RequestParam Map<String, Object> paramMap,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		logger.info("+ Start " + className + ".dateCheckList");
		logger.info("   - paramMap : " + paramMap);
		

		List<CalDayModel> dateCheckDList = calDayService.dateCheckDList(paramMap);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("dateCheckDList", dateCheckDList);
		logger.info("   - paramMap : " + Arrays.toString(dateCheckDList.toArray()));
		logger.info("   - paramMap : " + dateCheckDList);
		
		return resultMap;
	}

}