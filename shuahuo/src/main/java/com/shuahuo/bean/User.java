package com.shuahuo.bean;

public class User {


    int id,sex,age,qqnum,correlation_for_handicraft,studio_id;
    String username,password,phonenum,e_mail,name,province,city,county,occupation,personality_label,headimg_name;

    public User() {
        super();
    }

    public User(int id, int sex, int age, int qqnum, int correlation_for_handicraft, int studio_id, String username, String password, String phonenum, String e_mail, String name, String province, String city, String county, String occupation, String personality_label, String headimg_name) {
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.qqnum = qqnum;
        this.correlation_for_handicraft = correlation_for_handicraft;
        this.studio_id = studio_id;
        this.username = username;
        this.password = password;
        this.phonenum = phonenum;
        this.e_mail = e_mail;
        this.name = name;
        this.province = province;
        this.city = city;
        this.county = county;
        this.occupation = occupation;
        this.personality_label = personality_label;
        this.headimg_name = headimg_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sex=" + sex +
                ", age=" + age +
                ", qqnum=" + qqnum +
                ", correlation_for_handicraft=" + correlation_for_handicraft +
                ", studio_id=" + studio_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", occupation='" + occupation + '\'' +
                ", personality_label='" + personality_label + '\'' +
                ", headimg_name='" + headimg_name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getQqnum() {
        return qqnum;
    }

    public void setQqnum(int qqnum) {
        this.qqnum = qqnum;
    }

    public int getCorrelation_for_handicraft() {
        return correlation_for_handicraft;
    }

    public void setCorrelation_for_handicraft(int correlation_for_handicraft) {
        this.correlation_for_handicraft = correlation_for_handicraft;
    }

    public int getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(int studio_id) {
        this.studio_id = studio_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPersonality_label() {
        return personality_label;
    }

    public void setPersonality_label(String personality_label) {
        this.personality_label = personality_label;
    }

    public String getHeadimg_name() {
        return headimg_name;
    }

    public void setHeadimg_name(String headimg_name) {
        this.headimg_name = headimg_name;
    }
}
