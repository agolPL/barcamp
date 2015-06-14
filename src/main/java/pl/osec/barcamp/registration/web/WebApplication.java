package pl.osec.barcamp.registration.web;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest/service")
public class WebApplication extends Application {

    public static final String API_VERSION_1 = "application/pl.osec.barcamp.registration.v1+json";
}
