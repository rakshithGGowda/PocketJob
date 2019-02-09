package com.example.rakshithg.googlesignin;

public class Blog
{
private String cname;

    public String getCname() {
        return cname;
    }

    public String getAddress() {
        return address;
    }

    public String getSal() {
        return sal;
    }

    public String getImage() {
        return image;
    }

    private String address;
    private String sal;

    public Blog(String cname, String address, String image ,String sal) {
        this.cname = cname;
        this.address = address;
        this.image = image;
        this.sal = sal;
    }

    private String image;

    public Blog()
    {

    }

}

