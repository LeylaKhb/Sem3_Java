package itis.khabibullina.net.server;

import com.google.gson.*;
import itis.khabibullina.net.client.HttpClientImpl;
import itis.khabibullina.net.dto.ForecastDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String cityName = req.getParameter("city");
        String APIKey = "7158fed5a7566d75dcb1c18bd78573eb";
        Map<String, String> params = new HashMap<>();
        params.put("q", cityName);
        params.put("appid", APIKey);

        HttpClientImpl httpClient = new HttpClientImpl();
        long time = System.currentTimeMillis();
        String forecast = httpClient.get("https://api.openweathermap.org/data/2.5/weather",
                params);
        LOGGER.info("Time of getting forecast: " + String.valueOf( System.currentTimeMillis() - time) + "ms");

        if (!forecast.equals("")) {
            JsonElement forecastJSON = new JsonParser().parse(forecast);
            JsonObject mainInForecast = forecastJSON.getAsJsonObject().get("main").getAsJsonObject();
            JsonObject weatherInForecast = forecastJSON.getAsJsonObject().get("weather").getAsJsonArray()
                    .get(0).getAsJsonObject();

            String temp = String.valueOf(mainInForecast.get("temp").getAsFloat() - 273);
            String humidity = mainInForecast.get("humidity").getAsString();
            String precipitation = weatherInForecast.get("description").getAsString();

            resp.getWriter().write(String.format("Humidity: " + humidity + ", temp: " + temp + ", precipitation: " + precipitation));
        }


//        req.getRequestDispatcher("weather.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
