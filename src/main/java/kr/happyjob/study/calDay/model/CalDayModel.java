package kr.happyjob.study.calDay.model;

public class CalDayModel {

	public String getEmp_sdate() {
		return emp_sdate;
	}

	public void setEmp_sdate(String emp_sdate) {
		this.emp_sdate = emp_sdate;
	}

	public String getEmp_edate() {
		return emp_edate;
	}

	public void setEmp_edate(String emp_edate) {
		this.emp_edate = emp_edate;
	}

	public String getDept_cd() {
		return dept_cd;
	}

	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}

	public String getDetail_code() {
		return detail_code;
	}

	public void setDetail_code(String detail_code) {
		this.detail_code = detail_code;
	}

	public String getDetail_name() {
		return detail_name;
	}

	public void setDetail_name(String detail_name) {
		this.detail_name = detail_name;
	}

	public int getVaca_no() {
		return vaca_no;
	}

	public void setVaca_no(int vaca_no) {
		this.vaca_no = vaca_no;
	}

	public String getAppro_bos() {
		return appro_bos;
	}

	public void setAppro_bos(String appro_bos) {
		this.appro_bos = appro_bos;
	}

	public String getAppro_yn() {
		return appro_yn;
	}

	public void setAppro_yn(String appro_yn) {
		this.appro_yn = appro_yn;
	}

	public String getVaca_req_date() {
		return vaca_req_date;
	}

	public void setVaca_req_date(String vaca_req_date) {
		this.vaca_req_date = vaca_req_date;
	}

	public String getVaca_reason() {
		return vaca_reason;
	}

	public void setVaca_reason(String vaca_reason) {
		this.vaca_reason = vaca_reason;
	}

	public String getVaca_sdate() {
		return vaca_sdate;
	}

	public void setVaca_sdate(String vaca_sdate) {
		this.vaca_sdate = vaca_sdate;
	}

	public String getVaca_edate() {
		return vaca_edate;
	}

	public void setVaca_edate(String vaca_edate) {
		this.vaca_edate = vaca_edate;
	}

	public String getVaca_rej() {
		return vaca_rej;
	}

	public void setVaca_rej(String vaca_rej) {
		this.vaca_rej = vaca_rej;
	}

	public int getVaca_yn_cnt() {
		return vaca_yn_cnt;
	}

	public void setVaca_yn_cnt(int vaca_yn_cnt) {
		this.vaca_yn_cnt = vaca_yn_cnt;
	}

	// tb_userinfo에서 가져오는 정보들
	private String emp_sdate; // 입사일
	private String emp_edate; // 퇴사일
	private String dept_cd; // 부서코드 -> tb_dept table에서 가져오는 정보 join해서 부서명 가져와야함.
	/*
	 * private int total_an; //총연차 -> tb_ta_mgt table과 연관된 정보 private int
	 * use_an; //사용연차 -> tb_ta_mgt table과 연관된 정보 private int left_an; //남은연차 ->
	 * tb_ta_mgt table과 연관된 정보
	 */

	// tb_detail_code 상세코드
	private String detail_code; // 직급코드 -> 공통코드table
	private String detail_name; // 부서명

	// tb_vaca_req 휴가신청
	private int vaca_no; // 신청번호
	private String appro_bos; // 승인자
	private String appro_yn; // 승연여부
	private String vaca_req_date; // 신청일자
	private String vaca_reason; // 근태사유
	private String vaca_sdate; // 시작일자
	private String vaca_edate; // 종료일자
	private String vaca_rej; // 반려사유
	
	private int vaca_yn_cnt; // 캘린더에서 승인 여부에 따라 건 수 가져올 때 필요한 변수
	
	//tb_group_code
	private String group_code;

	public String getGroup_code() {
		return group_code;
	}

	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	//tb_userinfo
	private String loginID;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	private String name;
	private String dept_name;
	public String getLevel_name() {
		return level_name;
	}

	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}

	private String level_name;
	public String getAppro_type_cd() {
		return appro_type_cd;
	}

	public void setAppro_type_cd(String appro_type_cd) {
		this.appro_type_cd = appro_type_cd;
	}

	private String appro_type_cd;
}
