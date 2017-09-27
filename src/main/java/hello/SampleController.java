package hello;

import org.audit4j.core.annotation.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@Controller
@EnableAutoConfiguration

@Audit
public class SampleController extends SpringBootServletInitializer {

    @Autowired
    MyService myService;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SampleController.class);
    }

    @Audit
    @RequestMapping("/test")
    @ResponseBody
    String home(String name) {
        myService.test();
        return "Hello World! name:" + name;
    }

    @RequestMapping("/test2")
    @ResponseBody
    String test2(String name) {
        myService.test();
        return "Hello World2! name:" + name;
    }

    @Audit
    @RequestMapping("/test3")
    @ResponseBody
    String test3(String name) {
        myService.test();
        return "Hello World3! name:" + name;
    }

    public static void main(String[] args) throws Exception {

        SpringApplication.run(SampleController.class, args);
    }
}