package testzuul.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import testzuul.entity.Student;

@RestController
@Slf4j
@RequestMapping("/api/v1/priceservice")
public class TestPriceController {


    @GetMapping("/prices/hello")
    public String hello() {
        return "This is price service!";
    }

    @PostMapping("/testPost")
    public String testPost(@RequestBody Student student) {
        log.info("student: " + student);
        return JSON.toJSONString(student);
    }


}
