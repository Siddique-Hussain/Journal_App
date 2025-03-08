package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.constants.Placeholders;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    //hard coded
    //private static final String apiKey = "f59877c85c7700b42e9f6c241f855310";
    @Value("${weather.api.key}")
    private String apiKey;
    //private static final String API = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AppCache appCache;
    public WeatherResponse getWeather(String city)
    {
        String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).
                replace(Placeholders.CITY, city).replace(Placeholders.API_KEY, apiKey);

        // RETURN for  POST REQUEST
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("key", "Value");
//        User user = User.builder().userName("sid").password("sid").build();
//        HttpEntity<String> httpEntity =new HttpEntity<>(user);
//        ResponseEntity<WeatherResponse> response=   restTemplate.exchange(finalAPI,
//                HttpMethod.POST,httpEntity,WeatherResponse.class);


        ResponseEntity<WeatherResponse> response=   restTemplate.exchange(finalAPI,
                HttpMethod.GET,null,WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;

    }
}
