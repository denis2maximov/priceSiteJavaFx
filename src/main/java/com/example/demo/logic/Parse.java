package com.example.demo.logic;

public class Parse {
    public int id;
    public String data;
    public String site;
    public String price;

    public Parse(int id, String data, String site, String price) {
        this.id = id;
        this.data = data;
        this.site = site;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getSite() {
        return site;
    }

     public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Parse{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", site='" + site + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
