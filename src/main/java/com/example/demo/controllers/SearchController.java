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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    @FXML
    private TableColumn<Parse, String> TableColumData;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button buttonDeliteAll;

    @FXML
    private URL location;

    @FXML
    private Button buttonGoStartSearch;

    @FXML
    private Button buttonGoStartSearchOutFile;

    @FXML
//    void initialize() {
//        buttonGoStartSearch.setOnAction(event -> {
//            buttonGoStartSearch.getScene().getWindow().hide();
//
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/com/example/demo/outDB.fxml"));
//            try {
//                loader.load();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
//
//            });
//
//      buttonDeliteAll.setOnAction(event -> {
//          DataBaseHandler dataBaseHandler = new DataBaseHandler();
//          dataBaseHandler.cleanDataBase();
//      });
//
//      buttonGoStartSearchOutFile.setOnAction(event -> {
//          DataBaseHandler dataBaseHandler = new DataBaseHandler();
//          List<Parse> list = new ArrayList<>(dataBaseHandler.getAllLines());
//          try (BufferedWriter out = new BufferedWriter(
//                  new FileWriter("data/outdated.txt"))){
//              for (Parse parse : list) {
//                  out.write(parse.getId());
//                  out.write(" ");
//                  out.write(parse.getData());
//                  out.write(" ");
//                  out.write(parse.getSite());
//                  out.write(" ");
//                  out.write(parse.getPrice());
//                  out.write("\n");
//                  }
//              } catch (IOException e) {
//              throw new RuntimeException(e);
//          }
//      });
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        {
            buttonGoStartSearch.setOnAction(event -> {
                buttonGoStartSearch.getScene().getWindow().hide();

//                FXMLLoader loader = new FXMLLoader();
//                loader.setLocation(getClass().getResource("/com/example/demo/outDB.fxml"));
//                try {
//                    loader.load();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                Parent root = loader.getRoot();
//                Stage stage = new Stage();
//                stage.setScene(new Scene(root));
//                stage.showAndWait();
                  OutData outData  = new OutData();
                try {
                    outData.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            buttonDeliteAll.setOnAction(event -> {
                DataBaseHandler dataBaseHandler = new DataBaseHandler();
                dataBaseHandler.cleanDataBase();
            });

            buttonGoStartSearchOutFile.setOnAction(event -> {
                DataBaseHandler dataBaseHandler = new DataBaseHandler();
                List<Parse> list = new ArrayList<>(dataBaseHandler.getAllLines());
                try (BufferedWriter out = new BufferedWriter(
                        new FileWriter("data/outdated.txt"))) {
                    for (Parse parse : list) {
                        out.write(parse.getId());
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
}
