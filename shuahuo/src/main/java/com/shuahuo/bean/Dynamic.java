package com.shuahuo.bean;

public class Dynamic {
    private int dynamic_id, u_id, dynamic_imgnum, dynamic_videonum, dynamic_dianzan_num;
    private String dynamic_text, dynamic_imgname, dynamic_videoname, dynamic_creation_time;

    public Dynamic() {
        super();
    }

    public Dynamic(int dynamic_id, int u_id, int dynamic_imgnum, int dynamic_videonum, int dynamic_dianzan_num, String dynamic_text, String dynamic_imgname, String dynamic_videoname, String dynamic_creation_time) {
        this.dynamic_id = dynamic_id;
        this.u_id = u_id;
        this.dynamic_imgnum = dynamic_imgnum;
        this.dynamic_videonum = dynamic_videonum;
        this.dynamic_dianzan_num = dynamic_dianzan_num;
        this.dynamic_text = dynamic_text;
        this.dynamic_imgname = dynamic_imgname;
        this.dynamic_videoname = dynamic_videoname;
        this.dynamic_creation_time = dynamic_creation_time;
    }

    @Override
    public String toString() {
        return "Dynamic{" +
                "dynamic_id=" + dynamic_id +
                ", u_id=" + u_id +
                ", dynamic_imgnum=" + dynamic_imgnum +
                ", dynamic_videonum=" + dynamic_videonum +
                ", dynamic_dianzan_num=" + dynamic_dianzan_num +
                ", dynamic_text='" + dynamic_text + '\'' +
                ", dynamic_imgname='" + dynamic_imgname + '\'' +
                ", dynamic_videoname='" + dynamic_videoname + '\'' +
                ", dynamic_creation_time='" + dynamic_creation_time + '\'' +
                '}';
    }

    public int getDynamic_dianzan_num() {
        return dynamic_dianzan_num;
    }

    public void setDynamic_dianzan_num(int dynamic_dianzan_num) {
        this.dynamic_dianzan_num = dynamic_dianzan_num;
    }

    public int getDynamic_id() {
        return dynamic_id;
    }

    public void setDynamic_id(int dynamic_id) {
        this.dynamic_id = dynamic_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getDynamic_imgnum() {
        return dynamic_imgnum;
    }

    public void setDynamic_imgnum(int dynamic_imgnum) {
        this.dynamic_imgnum = dynamic_imgnum;
    }

    public int getDynamic_videonum() {
        return dynamic_videonum;
    }

    public void setDynamic_videonum(int dynamic_videonum) {
        this.dynamic_videonum = dynamic_videonum;
    }

    public String getDynamic_text() {
        return dynamic_text;
    }

    public void setDynamic_text(String dynamic_text) {
        this.dynamic_text = dynamic_text;
    }

    public String getDynamic_imgname() {
        return dynamic_imgname;
    }

    public void setDynamic_imgname(String dynamic_imgname) {
        this.dynamic_imgname = dynamic_imgname;
    }

    public String getDynamic_videoname() {
        return dynamic_videoname;
    }

    public void setDynamic_videoname(String dynamic_videoname) {
        this.dynamic_videoname = dynamic_videoname;
    }

    public String getDynamic_creation_time() {
        return dynamic_creation_time;
    }

    public void setDynamic_creation_time(String dynamic_creation_time) {
        this.dynamic_creation_time = dynamic_creation_time;
    }
}

