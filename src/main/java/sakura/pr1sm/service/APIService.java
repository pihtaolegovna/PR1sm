package sakura.pr1sm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class APIService {

    private final RestTemplate restTemplate;

    public APIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Double getExchangeRate(String currency) {
        String apiUrl = "https://open.er-api.com/v6/latest/USD" + currency;

        Map<String, Object> response = restTemplate.getForObject(apiUrl, Map.class);
        System.out.println(response);

        if (response != null && response.containsKey("rates")) {
            Map<String, Object> rates = (Map<String, Object>) response.get("rates");
            Object rate = rates.get(currency);

            if (rate instanceof Number) {
                return ((Number) rate).doubleValue();
            }
        }

        return null;
    }
}