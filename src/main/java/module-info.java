module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.controllers;
    opens com.example.demo.controllers to javafx.fxml;
    exports com.example.demo.db;
    opens com.example.demo.db to javafx.fxml;
    exports com.example.demo.logic;
    opens com.example.demo.logic to javafx.fxml;
}