package kr.happyjob.study.selSaD.model;

public class SelcectedDayModel {

    private String order_date;
    private int total_order_dt_amt;
    private long total_order_tot_price;
    private long total_product_unit_price;
    private long net_profit;


    public String getOrder_date() {
        return this.order_date;
    }

    public void setOrder_date(final String order_date) {
        this.order_date = order_date;
    }

    public int getTotal_order_dt_amt() {
        return this.total_order_dt_amt;
    }

    public void setTotal_order_dt_amt(final int total_order_dt_amt) {
        this.total_order_dt_amt = total_order_dt_amt;
    }

    public long getTotal_order_tot_price() {
        return this.total_order_tot_price;
    }

    public void setTotal_order_tot_price(final long total_order_tot_price) {
        this.total_order_tot_price = total_order_tot_price;
    }

    public long getTotal_product_unit_price() {
        return this.total_product_unit_price;
    }

    public void setTotal_product_unit_price(final long total_product_unit_price) {
        this.total_product_unit_price = total_product_unit_price;
    }

    public long getNet_profit() {
        return this.net_profit;
    }

    public void setNet_profit(final long net_profit) {
        this.net_profit = net_profit;
    }

    public SelcectedDayModel() {
    }
}