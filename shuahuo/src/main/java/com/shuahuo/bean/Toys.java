package com.shuahuo.bean;

public class Toys {
    int toys_id;
    String toys_name;

    public Toys(int toys_id, String toys_name) {
        this.toys_id = toys_id;
        this.toys_name = toys_name;
    }

    public Toys() {
        super();
    }

    @Override
    public String toString() {
        return "Toys{" +
                "toys_id=" + toys_id +
                ", toys_name='" + toys_name + '\'' +
                '}';
    }

    public int getToys_id() {
        return toys_id;
    }

    public void setToys_id(int toys_id) {
        this.toys_id = toys_id;
    }

    public String getToys_name() {
        return toys_name;
    }

    public void setToys_name(String toys_name) {
        this.toys_name = toys_name;
    }
}
