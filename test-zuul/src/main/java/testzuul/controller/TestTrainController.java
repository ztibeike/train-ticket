package testzuul.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import testzuul.entity.Student;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@Slf4j
@RequestMapping("/api/v1/trainservice")
public class TestTrainController {


    @GetMapping("/train/hello")
    public String hello() {
        return "This is train service!";
    }

    @PostMapping("/testPost")
    public String testPost(@RequestBody Student student) {
        log.info("student: " + student);
        return JSON.toJSONString(student);
    }


}
