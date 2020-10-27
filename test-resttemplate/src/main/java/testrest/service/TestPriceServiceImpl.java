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
public class TestPriceServiceImpl implements TestPriceService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    @LoadBalanced
    private RestTemplate loadBalanced;

    private String baseUrl = "http://ts-zuul-price";

    @Override
    public String testhello(HttpHeaders headers) {
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> exchange = loadBalanced.exchange(
                baseUrl + "/api/v1/priceservice/prices/hello",
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
                "http://zuul:30003/api/v1/priceservice/prices/hello",
                HttpMethod.GET,
                entity,
                String.class
        );
        return exchange.getBody();
    }


}
