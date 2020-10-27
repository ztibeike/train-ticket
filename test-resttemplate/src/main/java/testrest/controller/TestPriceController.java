package testrest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testrest.service.TestPriceService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/price")
public class TestPriceController {

    @Resource
    private TestPriceService testPriceService;

    @GetMapping("/testhello")
    public String testhello(@RequestHeader HttpHeaders headers) {
        return testPriceService.testhello(headers);
    }

    @GetMapping("/testhello2")
    public String testhello2(@RequestHeader HttpHeaders headers) {
        return testPriceService.testhello2(headers);
    }

}
