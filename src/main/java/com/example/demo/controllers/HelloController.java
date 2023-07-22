package com.example.demo.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.logic.ParseConfig;
import com.example.demo.view.SearchView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


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
                ParseConfig.pageParseDiapus();
                ParseConfig.pageParseTestpoloska();
                ParseConfig.pageParseMedMag();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        });
        buttonGoSearch.setOnAction(event -> {
            buttonGoSearch.getScene().getWindow().hide();

//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/com/example/demo/search.fxml"));
//            try {
//                loader.load();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
            SearchView searchView = new SearchView();
            searchView.start();

        });
    }

    }
