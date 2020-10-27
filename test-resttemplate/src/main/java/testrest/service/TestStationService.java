package testrest.service;

import org.springframework.http.HttpHeaders;

public interface TestStationService {

    String testhello(HttpHeaders headers);

    String testhello2(HttpHeaders headers);

}
