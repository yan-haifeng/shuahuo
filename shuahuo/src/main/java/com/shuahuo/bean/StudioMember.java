package com.shuahuo.bean;

public class StudioMember {
    int studio_member_id,studio_id;
    String studio_member_name,studio_member_id_card,studio_member_phone_num,studio_member_record,studio_member_head_img;

    public StudioMember() {
        super();
    }

    public StudioMember(int studio_member_id, int studio_id, String studio_member_name, String studio_member_id_card, String studio_member_phone_num, String studio_member_record, String studio_member_head_img) {
        this.studio_member_id = studio_member_id;
        this.studio_id = studio_id;
        this.studio_member_name = studio_member_name;
        this.studio_member_id_card = studio_member_id_card;
        this.studio_member_phone_num = studio_member_phone_num;
        this.studio_member_record = studio_member_record;
        this.studio_member_head_img = studio_member_head_img;
    }

    @Override
    public String toString() {
        return "StudioMember{" +
                "studio_member_id=" + studio_member_id +
                ", studio_id=" + studio_id +
                ", studio_member_name='" + studio_member_name + '\'' +
                ", studio_member_id_card='" + studio_member_id_card + '\'' +
                ", studio_member_phone_num='" + studio_member_phone_num + '\'' +
                ", studio_member_record='" + studio_member_record + '\'' +
                ", studio_member_head_img='" + studio_member_head_img + '\'' +
                '}';
    }

    public int getStudio_member_id() {
        return studio_member_id;
    }

    public void setStudio_member_id(int studio_member_id) {
        this.studio_member_id = studio_member_id;
    }

    public int getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public String getStudio_member_name() {
        return studio_member_name;
    }

    public void setStudio_member_name(String studio_member_name) {
        this.studio_member_name = studio_member_name;
    }

    public String getStudio_member_id_card() {
        return studio_member_id_card;
    }

    public void setStudio_member_id_card(String studio_member_id_card) {
        this.studio_member_id_card = studio_member_id_card;
    }

    public String getStudio_member_phone_num() {
        return studio_member_phone_num;
    }

    public void setStudio_member_phone_num(String studio_member_phone_num) {
        this.studio_member_phone_num = studio_member_phone_num;
    }

    public String getStudio_member_record() {
        return studio_member_record;
    }

    public void setStudio_member_record(String studio_member_record) {
        this.studio_member_record = studio_member_record;
    }

    public String getStudio_member_head_img() {
        return studio_member_head_img;
    }

    public void setStudio_member_head_img(String studio_member_head_img) {
        this.studio_member_head_img = studio_member_head_img;
    }
}
