package ru.rbc.kskabort;
import java.util.Scanner;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;

public class Converter {

    public static void main(String[] args) {
        parser("https://www.cbr.ru/currency_base/daily/");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите значение первой валюты к рублю:");
        double k1 = in.nextDouble();
        System.out.println("Введите значение второй валюты к рублю:");
        double k2 = in.nextDouble();
        System.out.println("Введите количество, которое нобходимо вычислить:");
        double k3 = in.nextDouble();
        double RES = ((1/k1) / (1/k2))*k3;
        System.out.println("Результат вычислений = " + RES);
    }

    private static void parser(String URL){
// Parse HTML String using JSoup library
/*        String HTMLSTring = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>JSoup Example</title>"
                + "</head>"
                + "<body>"
                + "<table><tr><td><h1>HelloWorld</h1></tr>"
                + "</table>"
                + "</body>"
                + "</html>";

        Document html = Jsoup.parse(HTMLSTring);
        String title = html.title();
        String h1 = html.body().getElementsByTag("h1").text();

        System.out.println("Input HTML String to JSoup :" + HTMLSTring);
        System.out.println("After parsing, Title : " + title);
        System.out.println("Afte parsing, Heading : " + h1);*/

        // JSoup Example 2 - Reading HTML page from URL
        String title = "";
        Document doc = null;
        try {
            doc = Jsoup.connect(URL).get();
            title = doc.title();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements tbody = doc.body().getElementsByTag("tbody");
        tbody.forms();
        System.out.println("Jsoup Can read HTML page from URL, title : " + tbody);

        // JSoup Example 3 - Parsing an HTML file in Java
        /*//Document htmlFile = Jsoup.parse("login.html", "ISO-8859-1"); // wrong
        Document htmlFile = null;
        try {
            htmlFile = Jsoup.parse(new File("login.html"), "ISO-8859-1");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // right
        title = htmlFile.title();
        Element div = htmlFile.getElementById("login");
        String cssClass = div.className(); // getting class form HTML element

        System.out.println("Jsoup can also parse HTML file directly");
        System.out.println("title : " + title);
        System.out.println("class of div tag : " + cssClass);*/
    }
}
