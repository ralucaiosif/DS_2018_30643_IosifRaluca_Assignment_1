package business.servlets;

import business.BL.CityBL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class LocalTimeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        String cityName = request.getParameter("city");
        CityBL cityBL = new CityBL();
        List<Double> coord = cityBL.getCityCoordinates(cityName);
        String url = "http://new.earthtools.org/timezone/" + coord.get(0) + "/" + coord.get(1);
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));  //stream to resource
        String str;
        String responsestring = "";
        while ((str = in.readLine()) != null)   //reading data
            responsestring += str+"\n";//process the response and save it in some string or so
        in.close();  //closing stream
        System.out.println(responsestring);

        int localtimePositionStart = responsestring.indexOf("<localtime>");
        int localtimePositionEnd = responsestring.indexOf("</localtime>");
        String localTime = responsestring.substring(localtimePositionStart + 11, localtimePositionEnd);


        PrintWriter out = response.getWriter();
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                localTime +
                "<body>\n" +
                "</body>\n" +
                "</html>\n"

        );
    }
}
