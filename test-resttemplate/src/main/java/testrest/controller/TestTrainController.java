package testrest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testrest.service.TestTrainService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/train")
public class TestTrainController {

    @Resource
    private TestTrainService testTrainService;

    @GetMapping("/testhello")
    public String testhello(@RequestHeader HttpHeaders headers) {
        return testTrainService.testhello(headers);
    }

    @GetMapping("/testhello2")
    public String testhello2(@RequestHeader HttpHeaders headers) {
        return testTrainService.testhello2(headers);
    }

}
