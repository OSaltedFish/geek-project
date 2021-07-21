package org.geektimes.rest.service;

import javax.annotation.PostConstruct;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Map;

/**
 *  shutdown Items Service
 *
 * @author <a href="mailto:fuchaozh@gmail.com">Charles</a>
 * @since
 */
public interface ShutdowService {

    @POST
    @Path("/actuator/shutdown")
    public Map<String,String> shutdown();

}
