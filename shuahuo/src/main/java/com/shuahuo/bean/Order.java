package com.shuahuo.bean;

public class Order {
    int order_id, user_id, toys_id, studio_id, order_statu;
    String order_requirements, order_price, order_transaction_mode, order_img;

    public Order() {
        super();
    }

    public Order(int order_id, int user_id, int toys_id, int studio_id, int order_statu, String order_requirements, String order_price, String order_transaction_mode, String order_img) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.toys_id = toys_id;
        this.studio_id = studio_id;
        this.order_statu = order_statu;
        this.order_requirements = order_requirements;
        this.order_price = order_price;
        this.order_transaction_mode = order_transaction_mode;
        this.order_img = order_img;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", toys_id=" + toys_id +
                ", studio_id=" + studio_id +
                ", order_statu=" + order_statu +
                ", order_requirements='" + order_requirements + '\'' +
                ", order_price='" + order_price + '\'' +
                ", order_transaction_mode='" + order_transaction_mode + '\'' +
                ", order_img='" + order_img + '\'' +
                '}';
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getToys_id() {
        return toys_id;
    }

    public void setToys_id(int toys_id) {
        this.toys_id = toys_id;
    }

    public int getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public int getOrder_statu() {
        return order_statu;
    }

    public void setOrder_statu(int order_statu) {
        this.order_statu = order_statu;
    }

    public String getOrder_requirements() {
        return order_requirements;
    }

    public void setOrder_requirements(String order_requirements) {
        this.order_requirements = order_requirements;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getOrder_transaction_mode() {
        return order_transaction_mode;
    }

    public void setOrder_transaction_mode(String order_transaction_mode) {
        this.order_transaction_mode = order_transaction_mode;
    }

    public String getOrder_img() {
        return order_img;
    }

    public void setOrder_img(String order_img) {
        this.order_img = order_img;
    }
}