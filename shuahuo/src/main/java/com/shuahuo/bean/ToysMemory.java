package com.shuahuo.bean;

public class ToysMemory {
    int toys_memory_id,toys_id;
    String toys_memory_title,toys_memory_img_one,toys_memory_img_two,toys_memory_img_context;

    public ToysMemory() {
        super();
    }

    public ToysMemory(int toys_memory_id, int toys_id, String toys_memory_title, String toys_memory_img_one, String toys_memory_img_two, String toys_memory_img_context) {
        this.toys_memory_id = toys_memory_id;
        this.toys_id = toys_id;
        this.toys_memory_title = toys_memory_title;
        this.toys_memory_img_one = toys_memory_img_one;
        this.toys_memory_img_two = toys_memory_img_two;
        this.toys_memory_img_context = toys_memory_img_context;
    }

    @Override
    public String toString() {
        return "ToysMemory{" +
                "toys_memory_id=" + toys_memory_id +
                ", toys_id=" + toys_id +
                ", toys_memory_title='" + toys_memory_title + '\'' +
                ", toys_memory_img_one='" + toys_memory_img_one + '\'' +
                ", toys_memory_img_two='" + toys_memory_img_two + '\'' +
                ", toys_memory_img_context='" + toys_memory_img_context + '\'' +
                '}';
    }

    public int getToys_memory_id() {
        return toys_memory_id;
    }

    public void setToys_memory_id(int toys_memory_id) {
        this.toys_memory_id = toys_memory_id;
    }

    public int getToys_id() {
        return toys_id;
    }

    public void setToys_id(int toys_id) {
        this.toys_id = toys_id;
    }

    public String getToys_memory_title() {
        return toys_memory_title;
    }

    public void setToys_memory_title(String toys_memory_title) {
        this.toys_memory_title = toys_memory_title;
    }

    public String getToys_memory_img_one() {
        return toys_memory_img_one;
    }

    public void setToys_memory_img_one(String toys_memory_img_one) {
        this.toys_memory_img_one = toys_memory_img_one;
    }

    public String getToys_memory_img_two() {
        return toys_memory_img_two;
    }

    public void setToys_memory_img_two(String toys_memory_img_two) {
        this.toys_memory_img_two = toys_memory_img_two;
    }

    public String getToys_memory_img_context() {
        return toys_memory_img_context;
    }

    public void setToys_memory_img_context(String toys_memory_img_context) {
        this.toys_memory_img_context = toys_memory_img_context;
    }
}
