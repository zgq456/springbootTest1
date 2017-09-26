package hello.config;

import org.audit4j.integration.spring.AuditAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 */
@Configuration
//@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableAspectJAutoProxy
public class AuditConfig {

    @Bean
    public AuditAspect auditAspect() {
        return new AuditAspect();
    }
}
