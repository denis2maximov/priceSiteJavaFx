module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}