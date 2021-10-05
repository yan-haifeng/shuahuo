package com.shuahuo.bean;

public class ToysExhibition {
    int toys_exhibition_id,toys_id;
    String toys_img_exhibition_one,toys_img_exhibition_two,toys_img_exhibition_three,toys_img_exhibition_four,toys_img_exhibition_five,toys_img_exhibition_url;

    public ToysExhibition() {
        super();
    }

    public ToysExhibition(int toys_exhibition_id, int toys_id, String toys_img_exhibition_one, String toys_img_exhibition_two, String toys_img_exhibition_three, String toys_img_exhibition_four, String toys_img_exhibition_five, String toys_img_exhibition_url) {
        this.toys_exhibition_id = toys_exhibition_id;
        this.toys_id = toys_id;
        this.toys_img_exhibition_one = toys_img_exhibition_one;
        this.toys_img_exhibition_two = toys_img_exhibition_two;
        this.toys_img_exhibition_three = toys_img_exhibition_three;
        this.toys_img_exhibition_four = toys_img_exhibition_four;
        this.toys_img_exhibition_five = toys_img_exhibition_five;
        this.toys_img_exhibition_url = toys_img_exhibition_url;
    }

    @Override
    public String toString() {
        return "ToysExhibition{" +
                "toys_exhibition_id=" + toys_exhibition_id +
                ", toys_id=" + toys_id +
                ", toys_img_exhibition_one='" + toys_img_exhibition_one + '\'' +
                ", toys_img_exhibition_two='" + toys_img_exhibition_two + '\'' +
                ", toys_img_exhibition_three='" + toys_img_exhibition_three + '\'' +
                ", toys_img_exhibition_four='" + toys_img_exhibition_four + '\'' +
                ", toys_img_exhibition_five='" + toys_img_exhibition_five + '\'' +
                ", toys_img_exhibition_url='" + toys_img_exhibition_url + '\'' +
                '}';
    }

    public int getToys_exhibition_id() {
        return toys_exhibition_id;
    }

    public void setToys_exhibition_id(int toys_exhibition_id) {
        this.toys_exhibition_id = toys_exhibition_id;
    }

    public int getToys_id() {
        return toys_id;
    }

    public void setToys_id(int toys_id) {
        this.toys_id = toys_id;
    }

    public String getToys_img_exhibition_one() {
        return toys_img_exhibition_one;
    }

    public void setToys_img_exhibition_one(String toys_img_exhibition_one) {
        this.toys_img_exhibition_one = toys_img_exhibition_one;
    }

    public String getToys_img_exhibition_two() {
        return toys_img_exhibition_two;
    }

    public void setToys_img_exhibition_two(String toys_img_exhibition_two) {
        this.toys_img_exhibition_two = toys_img_exhibition_two;
    }

    public String getToys_img_exhibition_three() {
        return toys_img_exhibition_three;
    }

    public void setToys_img_exhibition_three(String toys_img_exhibition_three) {
        this.toys_img_exhibition_three = toys_img_exhibition_three;
    }

    public String getToys_img_exhibition_four() {
        return toys_img_exhibition_four;
    }

    public void setToys_img_exhibition_four(String toys_img_exhibition_four) {
        this.toys_img_exhibition_four = toys_img_exhibition_four;
    }

    public String getToys_img_exhibition_five() {
        return toys_img_exhibition_five;
    }

    public void setToys_img_exhibition_five(String toys_img_exhibition_five) {
        this.toys_img_exhibition_five = toys_img_exhibition_five;
    }

    public String getToys_img_exhibition_url() {
        return toys_img_exhibition_url;
    }

    public void setToys_img_exhibition_url(String toys_img_exhibition_url) {
        this.toys_img_exhibition_url = toys_img_exhibition_url;
    }
}
