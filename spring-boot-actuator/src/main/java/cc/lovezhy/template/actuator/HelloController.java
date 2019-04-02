package cc.lovezhy.template.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public Map<String, String> index() {
        return Collections.singletonMap("Hello", "world");
    }
}
