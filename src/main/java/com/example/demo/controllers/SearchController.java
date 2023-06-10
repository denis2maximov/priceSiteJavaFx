package com.example.demo.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.db.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SearchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button buttonDeliteAll;

    @FXML
    private URL location;

    @FXML
    private Button buttonGoStartSearch;

    @FXML
    void initialize() {
      buttonGoStartSearch.setOnAction(event -> {
          DataBaseHandler dataBaseHandler = new DataBaseHandler();
          dataBaseHandler.getAllLines();

      });

      buttonDeliteAll.setOnAction(event -> {
         DataBaseHandler dataBaseHandler = new DataBaseHandler();
        dataBaseHandler.cleanDataBase();
      });
    }

}
