package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServletMap {
    @Autowired
    private Environment env;

    @GetMapping("/")
    public String index(){
        return "Hello Docker from port "+ env.getProperty("server.port");
    }
}
