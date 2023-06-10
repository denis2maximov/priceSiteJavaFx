package com.example.demo.logic;

import com.example.demo.db.DataBaseHandler;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.time.format.DateTimeFormatter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.jsoup.Jsoup.parse;

public class ParseConfig {

    public static void pageParseDiapus() throws IOException, ClassNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = LocalDateTime.now().format(formatter);
        String url = "https://diapuls.ru/product/test-poloski-ime-dc-50/";
        Document page = parse(new URL(url), 3000);
        Element doc = page.select("span.price").first();
        String price = Arrays.stream(doc.text().split(" "))
                .findFirst()
                .map(x -> x + " руб.")
                .get();
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        dataBaseHandler.signDataParse(formatDateTime,
              "diapuls.ru", price);
    }

    public static void pageParseTestpoloska() throws IOException, ClassNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = LocalDateTime.now().format(formatter);
        String url = "https://www.test-poloska.ru/catalog/teststripes/imedc50.html";
        Document page = parse(new URL(url), 3000);
        Element price = page.select("tbody").get(10);
        Elements priceTS = price.getElementsByAttribute("nowrap");
        String rsl =  Arrays.stream(priceTS.text()
                        .split(" "))
                .skip(1)
                .reduce((x, y) -> x + " " + y)
                .stream()
                .findFirst()
                .get();
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        dataBaseHandler.signDataParse(formatDateTime,
                "test-poloska.ru", rsl);
    }

    public static void pageParseMedMag() throws IOException, ClassNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = LocalDateTime.now().format(formatter);
        String url = "https://www.medmag.ru/index.php?productID=792&from=ya";
        Document page = parse(new URL(url), 3000);
        Element price = page.select("font.price").first();
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        assert price != null;
        dataBaseHandler.signDataParse(formatDateTime,
                "medmag.ru", price.text());
    }
}
