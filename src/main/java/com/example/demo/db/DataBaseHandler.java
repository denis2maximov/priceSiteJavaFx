package com.example.demo.db;

import com.example.demo.logic.Parse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            PreparedStatement preparedStatement;
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

    public List<Parse> getAllLines() {
        String select = "SELECT " + "* " + "FROM " + Const.PARSE_TABLE;
        ObservableList<Parse> parses = FXCollections.observableArrayList();
        List<Parse> parsesOut = new ArrayList<>();
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
                         ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                parses.add(buildeParse(resultSet));
            }
            parsesOut.addAll(parses);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return parsesOut;
    }

    private Parse buildeParse(ResultSet resultSet) throws SQLException {
        return new Parse(
                resultSet.getInt("id"),
                resultSet.getString("data"),
                resultSet.getString("site"),
                resultSet.getString("price")
                 );
    }

    public void cleanDataBase () {
        String delete = "DELETE " + "FROM " + Const.PARSE_TABLE;
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(delete);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
