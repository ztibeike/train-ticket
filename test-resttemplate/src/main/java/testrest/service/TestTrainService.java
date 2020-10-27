package testrest.service;

import org.springframework.http.HttpHeaders;

public interface TestTrainService {

    String testhello(HttpHeaders headers);

    String testhello2(HttpHeaders headers);

}
