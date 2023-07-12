package kr.happyjob.study.busDlv.model;

public class DeliveryInfoModel {
	
	public int getDlv_no() {
		return dlv_no;
	}
	public void setDlv_no(int dlv_no) {
		this.dlv_no = dlv_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getSplr_name() {
		return splr_name;
	}
	public void setSplr_name(String splr_name) {
		this.splr_name = splr_name;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public int getDlv_amt() {
		return dlv_amt;
	}
	public void setDlv_amt(int dlv_amt) {
		this.dlv_amt = dlv_amt;
	}
	public String getDlv_date() {
		return dlv_date;
	}
	public void setDlv_date(String dlv_date) {
		this.dlv_date = dlv_date;
	}
	public String getDlv_state() {
		return dlv_state;
	}
	public void setDlv_state(String dlv_state) {
		this.dlv_state = dlv_state;
	}
	public int getAppro_no() {
		return appro_no;
	}
	public void setAppro_no(int appro_no) {
		this.appro_no = appro_no;
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
	public String getDlv_rej() {
		return dlv_rej;
	}
	public void setDlv_rej(String dlv_rej) {
		this.dlv_rej = dlv_rej;
	}
	
	private int dlv_no;
	private String product_name;
	private String splr_name;
	private String loginID;
	private int dlv_amt;
	private String dlv_date;
	private String dlv_state;
	private int appro_no;
	private String appro_bos;
	private String appro_yn;
	private String dlv_rej;
}
