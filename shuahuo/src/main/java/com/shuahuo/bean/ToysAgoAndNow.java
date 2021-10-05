package com.shuahuo.bean;

public class ToysAgoAndNow {
    int toys_agoandnow_id,toys_id;
    String toys_agoandnow_title,toys_agoandnow_img_one,toys_agoandnow_img_two,toys_agoandnow_img_context;

    public ToysAgoAndNow() {
        super();
    }

    public ToysAgoAndNow(int toys_agoandnow_id, int toys_id, String toys_agoandnow_title, String toys_agoandnow_img_one, String toys_agoandnow_img_two, String toys_agoandnow_img_context) {
        this.toys_agoandnow_id = toys_agoandnow_id;
        this.toys_id = toys_id;
        this.toys_agoandnow_title = toys_agoandnow_title;
        this.toys_agoandnow_img_one = toys_agoandnow_img_one;
        this.toys_agoandnow_img_two = toys_agoandnow_img_two;
        this.toys_agoandnow_img_context = toys_agoandnow_img_context;
    }

    @Override
    public String toString() {
        return "ToysAgoAndNow{" +
                "toys_agoandnow_id=" + toys_agoandnow_id +
                ", toys_id=" + toys_id +
                ", toys_agoandnow_title='" + toys_agoandnow_title + '\'' +
                ", toys_agoandnow_img_one='" + toys_agoandnow_img_one + '\'' +
                ", toys_agoandnow_img_two='" + toys_agoandnow_img_two + '\'' +
                ", toys_agoandnow_img_context='" + toys_agoandnow_img_context + '\'' +
                '}';
    }

    public int getToys_agoandnow_id() {
        return toys_agoandnow_id;
    }

    public void setToys_agoandnow_id(int toys_agoandnow_id) {
        this.toys_agoandnow_id = toys_agoandnow_id;
    }

    public int getToys_id() {
        return toys_id;
    }

    public void setToys_id(int toys_id) {
        this.toys_id = toys_id;
    }

    public String getToys_agoandnow_title() {
        return toys_agoandnow_title;
    }

    public void setToys_agoandnow_title(String toys_agoandnow_title) {
        this.toys_agoandnow_title = toys_agoandnow_title;
    }

    public String getToys_agoandnow_img_one() {
        return toys_agoandnow_img_one;
    }

    public void setToys_agoandnow_img_one(String toys_agoandnow_img_one) {
        this.toys_agoandnow_img_one = toys_agoandnow_img_one;
    }

    public String getToys_agoandnow_img_two() {
        return toys_agoandnow_img_two;
    }

    public void setToys_agoandnow_img_two(String toys_agoandnow_img_two) {
        this.toys_agoandnow_img_two = toys_agoandnow_img_two;
    }

    public String getToys_agoandnow_img_context() {
        return toys_agoandnow_img_context;
    }

    public void setToys_agoandnow_img_context(String toys_agoandnow_img_context) {
        this.toys_agoandnow_img_context = toys_agoandnow_img_context;
    }
}
