package com.example.demo.db;

import java.io.PrintStream;
import java.sql.*;

public class DataBaseHandler extends ConfigDB {
    Connection dbConnection;

    public Connection getDbConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String connectionString = "jdbc:postgresql://" + hostBD + ":" + portBD + "/" + nameBD;
        dbConnection = DriverManager.getConnection(connectionString, userBD, passwordBD);
        return dbConnection;
    }

    public void signDataParse(String data, String site, String price) {
        String insert = "INSERT INTO " + Const.PARSE_TABLE + "(" + Const.PARSE_DATA + ","
                + Const.PARSE_SITE + "," + Const.PARSE_PRICE + ")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = getDbConnection().prepareStatement(insert);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            preparedStatement.setString(1, data);
            preparedStatement.setString(2, site);
            preparedStatement.setString(3, price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllLines() {
        String select = "SELECT " + "* " + "FROM " + Const.PARSE_TABLE;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
          //  preparedStatement.setInt(1, maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                Integer id = resultSet.getInt("id");
                String data = resultSet.getString("data");
                String site = resultSet.getString("site");
                String price = resultSet.getString("price");

                System.out.println(id + " " + data + " " + site + " " + price);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void cleanDataBase () {
        String delete = "DELETE " + "FROM " + Const.PARSE_TABLE;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(delete);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
