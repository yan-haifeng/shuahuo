package com.shuahuo.bean;

public class Comment {
    int comment_id,dynamic_id,u_id;
    String comment_text,comment_creation_time;

    public Comment() {
        super();
    }

    public Comment(int comment_id, int dynamic_id, int u_id, String comment_text, String comment_creation_time) {
        this.comment_id = comment_id;
        this.dynamic_id = dynamic_id;
        this.u_id = u_id;
        this.comment_text = comment_text;
        this.comment_creation_time = comment_creation_time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", dynamic_id=" + dynamic_id +
                ", u_id=" + u_id +
                ", comment_text='" + comment_text + '\'' +
                ", comment_creation_time='" + comment_creation_time + '\'' +
                '}';
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
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

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public String getComment_creation_time() {
        return comment_creation_time;
    }

    public void setComment_creation_time(String comment_creation_time) {
        this.comment_creation_time = comment_creation_time;
    }
}
