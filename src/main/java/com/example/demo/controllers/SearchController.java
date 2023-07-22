package com.example.demo.controllers;

import com.example.demo.db.DataBaseHandler;
import com.example.demo.logic.Parse;
import com.example.demo.view.OutData;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    @FXML
    private TableColumn<Parse, String> TableColumData;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button buttonDeleteAll;

    @FXML
    private URL location;

    @FXML
    private Button buttonGoStartSearch;

    @FXML
    private Button buttonGoStartSearchOutFile;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            buttonGoStartSearch.setOnAction(event -> {
                buttonGoStartSearch.getScene().getWindow().hide();
                  OutData outData  = new OutData();
                    outData.start();
            });

            buttonDeleteAll.setOnAction(event -> {
                DataBaseHandler dataBaseHandler = new DataBaseHandler();
                dataBaseHandler.cleanDataBase();
            });

            buttonGoStartSearchOutFile.setOnAction(event -> {
                DataBaseHandler dataBaseHandler = new DataBaseHandler();
                List<Parse> list = new ArrayList<>(dataBaseHandler.getAllLines());
                try (BufferedWriter out = new BufferedWriter(
                        new FileWriter("data/outdated.txt", Charset.defaultCharset()))) {
                    for (Parse parse : list) {
                        out.write(Integer.toString(parse.getId()));
                        out.write(" ");
                        out.write(parse.getData());
                        out.write(" ");
                        out.write(parse.getSite());
                        out.write(" ");
                        out.write(parse.getPrice());
                        out.write("\n");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
