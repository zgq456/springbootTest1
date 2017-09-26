package hello.audit;

import org.audit4j.core.MetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 *
 */

public class AuditMetaData implements MetaData {
    private static final long serialVersionUID = 7243065407615627372L;
    private static final Logger logger = LoggerFactory.getLogger(AuditMetaData.class);

    @Override
    public String getOrigin() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
        }catch(Exception e){
            logger.error(e.getMessage(),e);
        }
        return "unidentified";
    }

    @Override
    public String getActor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            return ((UserDetails) authentication.getPrincipal()).getUsername();
        }
        return "anonymous";
    }
}
