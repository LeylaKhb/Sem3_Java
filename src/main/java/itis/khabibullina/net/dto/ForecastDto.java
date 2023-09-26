package itis.khabibullina.net.dto;

public class ForecastDto {
    private String humidity;
    private String temp;
    private String precipitation;
    private String cityName;

    public ForecastDto(String humidity, String temp, String precipitation, String cityName) {
        this.humidity = humidity;
        this.temp = temp;
        this.precipitation = precipitation;
        this.cityName = cityName;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTemp() {
        return temp;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public String getCityName() {
        return cityName;
    }
}
