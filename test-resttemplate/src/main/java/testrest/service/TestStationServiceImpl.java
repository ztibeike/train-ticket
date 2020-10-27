package testrest.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class TestStationServiceImpl implements TestStationService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    @LoadBalanced
    private RestTemplate loadBalanced;

    private String baseUrl = "http://ts-zuul-station";

    @Override
    public String testhello(HttpHeaders headers) {
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> exchange = loadBalanced.exchange(
                baseUrl + "/api/v1/stationservice/station/hello",
                HttpMethod.GET,
                entity,
                String.class
        );
        return exchange.getBody();
    }

    @Override
    public String testhello2(HttpHeaders headers) {
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> exchange = restTemplate.exchange(
                "http://zuul:30001/api/v1/stationservice/station/hello",
                HttpMethod.GET,
                entity,
                String.class
        );
        return exchange.getBody();
    }


}
