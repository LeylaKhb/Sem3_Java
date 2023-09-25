package itis.khabibullina.net.server;

import com.google.gson.*;
import itis.khabibullina.net.client.HttpClientImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "weatherServlet", urlPatterns = "/weather")

public class WeatherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String cityName = String.valueOf(httpSession.getAttribute("cityName"));
        String APIKey = "7158fed5a7566d75dcb1c18bd78573eb";
        Map<String, String> params = new HashMap<>();
        params.put("q", cityName);
        params.put("appid", APIKey);

        HttpClientImpl httpClient = new HttpClientImpl();
        String forecast = httpClient.get("https://api.openweathermap.org/data/2.5/weather",
                params);

        if (!forecast.equals("")) {
            JsonElement forecastJSON = new JsonParser().parse(forecast);
            JsonObject mainInForecast = forecastJSON.getAsJsonObject().get("main").getAsJsonObject();
            JsonObject weatherInForecast = forecastJSON.getAsJsonObject().get("weather").getAsJsonArray()
                    .get(0).getAsJsonObject();

            Float temp = mainInForecast.get("temp").getAsFloat();
            String humidity = mainInForecast.get("humidity").getAsString();
            String precipitation = weatherInForecast.get("description").getAsString();

            req.setAttribute("temp", temp - 273);
            req.setAttribute("humidity", humidity);
            req.setAttribute("precipitation", precipitation);
            req.setAttribute("cityName", cityName);
        }
        req.getRequestDispatcher("weather.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
