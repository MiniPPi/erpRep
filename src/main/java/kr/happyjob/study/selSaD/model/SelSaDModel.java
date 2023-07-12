package kr.happyjob.study.selSaD.model;

import java.math.BigDecimal;
import java.util.Date;

public class SelSaDModel {
    private int order_no;//주문번호
    private String order_date;//주문일자
    private int product_no;//제품번호
    private int splr_no;//납품기업번호
    private String splr_name;//납품기업명
    private String product_name;//품명
    private String clnt_name;//고객기업명
    private BigDecimal total_order_price;

    public BigDecimal getTotal_order_price() {
        return total_order_price;
    }

    public void setTotal_order_price(BigDecimal total_order_price) {
        this.total_order_price = total_order_price;
    }
    private String pro_cd;//제품 분류코드

    private String pro_name;//제품 분류

    private String product_serial;//모델명
    private int product_unit_price;//납품단가
    private int product_price;//판매가

    private int order_dt_amt;//수량

    private int order_tot_price;//총액






    public String getClnt_name() {
        return this.clnt_name;
    }

    public void setClnt_name(final String clnt_name) {
        this.clnt_name = clnt_name;
    }


    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public int getProduct_no() {
        return product_no;
    }

    public void setProduct_no(int product_no) {
        this.product_no = product_no;
    }

    public int getSplr_no() {
        return splr_no;
    }

    public void setSplr_no(int splr_no) {
        this.splr_no = splr_no;
    }

    public String getSplr_name() {
        return splr_name;
    }

    public void setSplr_name(String splr_name) {
        this.splr_name = splr_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getPro_cd() {
        return pro_cd;
    }

    public void setPro_cd(String pro_cd) {
        this.pro_cd = pro_cd;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getProduct_serial() {
        return product_serial;
    }

    public void setProduct_serial(String product_serial) {
        this.product_serial = product_serial;
    }

    public int getProduct_unit_price() {
        return product_unit_price;
    }

    public void setProduct_unit_price(int product_unit_price) {
        this.product_unit_price = product_unit_price;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getOrder_dt_amt() {
        return order_dt_amt;
    }

    public void setOrder_dt_amt(int order_dt_amt) {
        this.order_dt_amt = order_dt_amt;
    }

    public int getOrder_tot_price() {
        return order_tot_price;
    }

    public void setOrder_tot_price(int order_tot_price) {
        this.order_tot_price = order_tot_price;
    }
}
