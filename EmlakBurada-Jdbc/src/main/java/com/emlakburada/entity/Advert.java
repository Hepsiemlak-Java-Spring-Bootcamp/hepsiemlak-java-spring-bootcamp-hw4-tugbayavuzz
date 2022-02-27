package com.emlakburada.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Advert {

    public int id;
    public int advertNo;
    public String title;
    public int price;
    public int time;

    public Advert() {
    }

    public Advert(int id, int advertNo, String title, int price, int time) {

        this.id = id;
        this.advertNo = advertNo;
        this.title = title;
        this.price = price;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Advert{" +
                "id=" + id +
                ", advertNo=" + advertNo +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", time=" + time +
                '}';
    }
}
