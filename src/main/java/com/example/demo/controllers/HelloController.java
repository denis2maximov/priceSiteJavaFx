package com.example.demo.controllers;

import com.example.demo.logic.ParseConfig;
import com.example.demo.view.SearchView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonGoSearch;

    @FXML
    private Button buttonStartParse;
    @FXML
    void initialize() {
        buttonStartParse.setOnAction(event -> {
            try {
                ParseConfig.pageParseDiapuls();
                ParseConfig.pageParseTestpoloska();
                ParseConfig.pageParseMedMag();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        });
        buttonGoSearch.setOnAction(event -> {
            buttonGoSearch.getScene().getWindow().hide();
            SearchView searchView = new SearchView();
            searchView.start();

        });
    }

    }
