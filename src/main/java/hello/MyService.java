package hello;

import org.audit4j.core.annotation.Audit;
import org.springframework.stereotype.Component;

@Component
@Audit
public class MyService {

    public void test() {
        System.out.println("###test       ###");
    }
}
