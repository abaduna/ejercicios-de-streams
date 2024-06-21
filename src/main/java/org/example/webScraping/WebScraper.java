package org.example.webScraping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class WebScraper {
    public static void main(String[] args) {
       String url ="https://www.nytimes.com/";
       String html = cargarweb(url);

        List<String> noticias = obtenerTitulares(html);
        noticias.forEach(noticia ->{
            System.out.println(noticia);
        });
    }

    private static List<String> obtenerTitulares(String html) {
        List<String> titulares = new ArrayList<>();
        /*
        * <p class="indicate-hover css-ug7vhz">Putin Shows He Can Antagonize the U.S. Far Afield From Ukraine</p>
        *
        *  */
        String[] splitH3Aux = html.split("<p class=\"indicate-hover");
        for (String noticia:splitH3Aux){
           String[] splith3Final = noticia.split("</p>");
           String titularSucio = splith3Final[0];
            String[] titularSucioString = titularSucio.split(">");
            String titular = titularSucioString[1];
            if (titular.length() > 28) {
                titulares.add(titular);
            }

        }

        return  titulares;
    }

    private static String cargarweb(String urlStr) {
        String Html;
        try {
            Html = "";
            URL url = new URL(urlStr);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            BufferedReader buffer = new BufferedReader(reader);
            String linae;
            do {
                linae = buffer.readLine();
                if (linae != null) {
                    Html += linae;
                }
            } while (linae != null);
            buffer.close();
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        return Html;
    }
}
