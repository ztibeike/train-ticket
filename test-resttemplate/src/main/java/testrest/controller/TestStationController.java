package testrest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testrest.service.TestStationService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/station")
public class TestStationController {

    @Resource
    private TestStationService testStationService;

    @GetMapping("/testhello")
    public String testhello(@RequestHeader HttpHeaders headers) {
        return testStationService.testhello(headers);
    }

    @GetMapping("/testhello2")
    public String testhello2(@RequestHeader HttpHeaders headers) {
        return testStationService.testhello2(headers);
    }

}
