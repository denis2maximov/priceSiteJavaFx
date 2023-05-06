package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;



public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    }
}