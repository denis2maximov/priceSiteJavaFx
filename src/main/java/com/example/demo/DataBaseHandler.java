package com.example.demo;

import java.sql.*;
import java.time.LocalDateTime;

public class DataBaseHandler extends ConfigDB{
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
}
