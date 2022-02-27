package com.emlakburada.dao;

import com.emlakburada.entity.Advert;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdvertRepository extends  JdbcConnectionRepository{
    private static final String INSERT_ADVERT = "INSERT INTO ADVERT (ID, ADVERTNO, TITLE, PRICE, TIME) VALUES (?,?,?,?);";
    private static final String SELECT_ALL_ADVERT = "SELECT * FROM ADVERT";
    private static final String FIND_ADVERT = "SELECT * FROM ADVERT WHERE id = ?";

    public void save(Advert advert) {

        Connection connection = connect();

        if (connection != null) {

            PreparedStatement prepareStatement = null;
            try {

                prepareStatement = connection.prepareStatement(INSERT_ADVERT);
                prepareStatement.setInt(1, advert.id);
                prepareStatement.setInt(2, (advert.advertNo));
                prepareStatement.setString(3, advert.title);
                prepareStatement.setInt(4, advert.price);
                prepareStatement.setInt(4, advert.time);


                int executeUpdate = prepareStatement.executeUpdate();

                System.out.println("result: " + executeUpdate);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                    prepareStatement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Connection oluşturululamadı!");
        }

    }

    public List<Advert> findAll() {

        List<Advert> advertList = new ArrayList<Advert>();

        Connection connection = connect();

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_ADVERT);

            ResultSet result = prepareStatement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int advertNo = result.getInt("advertNo");
                String title = result.getString("title");
                int price = result.getInt("price");
                int time = result.getInt("time");

                advertList.add(prepareAdvert(id, advertNo, title, price,time));

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return advertList;

    }

    private Advert prepareAdvert(int id, int advertNo,  String title,  int price,int time) {
        Advert advert = new Advert();

        advert.id = id;
        advert.advertNo = advertNo;
        advert.title = title;
        advert.price = price;
        advert.time=time;

        return advert;
    }

    public Advert findOne(int id) {

        Advert advert = null;

        Connection connection = connect();

        try {
            PreparedStatement prepareStatement = connection.prepareStatement(FIND_ADVERT);
            prepareStatement.setInt(1, id);

            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {

                int advertNo = result.getInt("advertNo");
                String title = result.getString("title");
                int price = result.getInt("price");
                int time = result.getInt("time");

                advert = prepareAdvert(id,advertNo, title, price,time);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return advert ;

    }

}

