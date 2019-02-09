package com.example.rakshithg.googlesignin;

public class companyinfo {
    public companyinfo() {

    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getImg1() {
        return image;
    }

    public void setImg1(String img1) {
        this.image = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public String getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public companyinfo(String address) {
        this.address = address;

    }

    public void setImg3(String img3) {

        this.img3 = img3;
    }

    String cname,desc,sal,image,img2,img3,address;

    public companyinfo(String cname, String desc, String sal, String img1, String img2, String img3) {
        this.cname = cname;
        this.desc = desc;
        this.sal = sal;
        this.image = img1;
        this.img2 = img2;
        this.img3 = img3;
    }
}
