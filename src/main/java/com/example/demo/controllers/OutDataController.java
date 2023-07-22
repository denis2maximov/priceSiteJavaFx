package com.example.demo.controllers;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.db.DataBaseHandler;
import com.example.demo.logic.Parse;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class OutDataController implements Initializable {
    private static javafx.collections.FXCollections FXCollections;
    private static final ObservableList<Parse> parseObservableListData
            = javafx.collections.FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane OutDta;

    @FXML
    private TableColumn<Parse, String> TableColumData;

    @FXML
    private TableColumn<Parse, Integer> TableColumId;

    @FXML
    private TableColumn<Parse, String> TableColumSite;

    @FXML
    private TableColumn<Parse, String> TableDataPrice;

    @FXML
    private TableView<Parse> TableView;


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
       initData();
       TableColumId.setCellValueFactory(new PropertyValueFactory<>("id"));
       TableColumData.setCellValueFactory(new PropertyValueFactory<>("data"));
       TableColumSite.setCellValueFactory(new PropertyValueFactory<>("site"));
       TableDataPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
       TableView.setItems(parseObservableListData);
    }

    private void initData() {
        DataBaseHandler out = new DataBaseHandler();
        var parses = out.getAllLines();
        for (Parse parse : parses){
            parseObservableListData.add(new Parse(
                   parse.getId(),
                   parse.getData(),
                   parse.getSite(),
                   parse.getPrice()
            )
    );
}
      }
}



