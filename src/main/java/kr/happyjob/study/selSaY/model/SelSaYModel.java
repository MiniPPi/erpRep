package kr.happyjob.study.selSaY.model;

import java.util.Date;

public class SelSaYModel {

    private int order_no; // 주문번호
    private Date order_date; // 주문일자
    private int product_no; // 제품번호
    private int splr_no; // 납품기업번호
    private String splr_name; // 납품기업명
    private String product_name; // 품명

    private String pro_cd; // 제품 분류코드

    private String pro_name; // 제품 분류

    private String product_serial; // 모델명
    private int product_unit_price; // 납품단가
    private int product_price; // 판매가

    private int order_dt_amt; // 수량

    private int order_tot_price; // 총액

    private int order_year; // 주문년도

    private long order_year_dt_amt; // 주문년도별 총 주문량
    private long order_year_tot_price; // 주문년도별 총 가격
    private long order_year_tot_product_price; // 주문년도별 제품 총 가격
    private long order_year_tot_product_unit_price; // 주문년도별 단위 제품 총 가격
    private long tot_profit; // 총 이익
    private long sal_after_total; // 총 지급액

    public long getOrder_year_dt_amt() {
        return this.order_year_dt_amt;
    }

    public void setOrder_year_dt_amt(final long order_year_dt_amt) {
        this.order_year_dt_amt = order_year_dt_amt;
    }

    public long getOrder_year_tot_price() {
        return this.order_year_tot_price;
    }

    public void setOrder_year_tot_price(final long order_year_tot_price) {
        this.order_year_tot_price = order_year_tot_price;
    }

    public long getOrder_year_tot_product_price() {
        return this.order_year_tot_product_price;
    }

    public void setOrder_year_tot_product_price(final long order_year_tot_product_price) {
        this.order_year_tot_product_price = order_year_tot_product_price;
    }

    public long getOrder_year_tot_product_unit_price() {
        return this.order_year_tot_product_unit_price;
    }


    public long getTot_profit() {
        return this.tot_profit;
    }

    public void setTot_profit(final long tot_profit) {
        this.tot_profit = tot_profit;
    }

    public long getSal_after_total() {
        return this.sal_after_total;
    }

    public void setSal_after_total(final long sal_after_total) {
        this.sal_after_total = sal_after_total;
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
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

    public int getOrder_year() {
        return order_year;
    }

    public void setOrder_year(int order_year) {
        this.order_year = order_year;
    }

    private int sale_year;
    private long total_sales_volume;
    private long expense_total;
    private long year_total_profit;
    private double percent_year;

    public int getSale_year() {
        return sale_year;
    }

    public void setSale_year(int sale_year) {
        this.sale_year = sale_year;
    }

    public long getTotal_sales_volume() {
        return total_sales_volume;
    }

    public void setTotal_sales_volume(long total_sales_volume) {
        this.total_sales_volume = total_sales_volume;
    }


    public void setOrder_year_tot_product_unit_price(long order_year_tot_product_unit_price) {
        this.order_year_tot_product_unit_price = order_year_tot_product_unit_price;
    }

    public long getExpense_total() {
        return expense_total;
    }

    public void setExpense_total(long expense_total) {
        this.expense_total = expense_total;
    }

    public long getYear_total_profit() {
        return year_total_profit;
    }

    public void setYear_total_profit(long year_total_profit) {
        this.year_total_profit = year_total_profit;
    }

    public double getPercent_year() {
        return percent_year;
    }

    public void setPercent_year(double percent_year) {
        this.percent_year = percent_year;
    }
}
