package cc.lovezhy.template.springboot.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/")
@Slf4j
public class HelloController {

    @GetMapping
    public Map<String, String> hello() {
        log.info("Hello");
        return Collections.singletonMap("Hello", "World");
    }
}
