package com.shuahuo.bean;

public class Studio {
    int studio_id;
    String studio_name,studio_logo,studio_img,studio_introduction,studio_begoodat,studio_othertypes,studio_uuid;

    public Studio() {
        super();
    }

    public Studio(int studio_id, String studio_name, String studio_logo, String studio_img, String studio_introduction, String studio_begoodat, String studio_othertypes, String studio_uuid) {
        this.studio_id = studio_id;
        this.studio_name = studio_name;
        this.studio_logo = studio_logo;
        this.studio_img = studio_img;
        this.studio_introduction = studio_introduction;
        this.studio_begoodat = studio_begoodat;
        this.studio_othertypes = studio_othertypes;
        this.studio_uuid = studio_uuid;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "studio_id=" + studio_id +
                ", studio_name='" + studio_name + '\'' +
                ", studio_logo='" + studio_logo + '\'' +
                ", studio_img='" + studio_img + '\'' +
                ", studio_introduction='" + studio_introduction + '\'' +
                ", studio_begoodat='" + studio_begoodat + '\'' +
                ", studio_othertypes='" + studio_othertypes + '\'' +
                ", studio_uuid='" + studio_uuid + '\'' +
                '}';
    }

    public int getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public String getStudio_name() {
        return studio_name;
    }

    public void setStudio_name(String studio_name) {
        this.studio_name = studio_name;
    }

    public String getStudio_logo() {
        return studio_logo;
    }

    public void setStudio_logo(String studio_logo) {
        this.studio_logo = studio_logo;
    }

    public String getStudio_img() {
        return studio_img;
    }

    public void setStudio_img(String studio_img) {
        this.studio_img = studio_img;
    }

    public String getStudio_introduction() {
        return studio_introduction;
    }

    public void setStudio_introduction(String studio_introduction) {
        this.studio_introduction = studio_introduction;
    }

    public String getStudio_begoodat() {
        return studio_begoodat;
    }

    public void setStudio_begoodat(String studio_begoodat) {
        this.studio_begoodat = studio_begoodat;
    }

    public String getStudio_othertypes() {
        return studio_othertypes;
    }

    public void setStudio_othertypes(String studio_othertypes) {
        this.studio_othertypes = studio_othertypes;
    }

    public String getStudio_uuid() {
        return studio_uuid;
    }

    public void setStudio_uuid(String studio_uuid) {
        this.studio_uuid = studio_uuid;
    }
}
