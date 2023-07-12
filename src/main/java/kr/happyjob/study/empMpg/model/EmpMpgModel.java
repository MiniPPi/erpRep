package kr.happyjob.study.empMpg.model;


public class EmpMpgModel {

	

	private String loginID;
	private String name;
	private String password;
	private String emp_hp;
	private String emp_email;
	private String emp_zip;
	private String emp_addr;
	private String emp_dt_addr;
	private int file_no;
    private String file_name;
    private String logic_path;
    private String physic_path;
    private int file_size;
    private String exten;
	
	public EmpMpgModel() {
		super();
	}

	public EmpMpgModel(String loginID, String name, String password, String emp_hp, String emp_email, String emp_zip,
			String emp_addr, String emp_dt_addr, int file_no, String file_name, String logic_path, String physic_path,
			int file_size, String exten) {
		super();
		this.loginID = loginID;
		this.name = name;
		this.password = password;
		this.emp_hp = emp_hp;
		this.emp_email = emp_email;
		this.emp_zip = emp_zip;
		this.emp_addr = emp_addr;
		this.emp_dt_addr = emp_dt_addr;
		this.file_no = file_no;
		this.file_name = file_name;
		this.logic_path = logic_path;
		this.physic_path = physic_path;
		this.file_size = file_size;
		this.exten = exten;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmp_hp() {
		return emp_hp;
	}

	public void setEmp_hp(String emp_hp) {
		this.emp_hp = emp_hp;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getEmp_zip() {
		return emp_zip;
	}

	public void setEmp_zip(String emp_zip) {
		this.emp_zip = emp_zip;
	}

	public String getEmp_addr() {
		return emp_addr;
	}

	public void setEmp_addr(String emp_addr) {
		this.emp_addr = emp_addr;
	}

	public String getEmp_dt_addr() {
		return emp_dt_addr;
	}

	public void setEmp_dt_addr(String emp_dt_addr) {
		this.emp_dt_addr = emp_dt_addr;
	}

	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getLogic_path() {
		return logic_path;
	}

	public void setLogic_path(String logic_path) {
		this.logic_path = logic_path;
	}

	public String getPhysic_path() {
		return physic_path;
	}

	public void setPhysic_path(String physic_path) {
		this.physic_path = physic_path;
	}

	public int getFile_size() {
		return file_size;
	}

	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}

	public String getExten() {
		return exten;
	}

	public void setExten(String exten) {
		this.exten = exten;
	}
	
	
	
	
	
}





