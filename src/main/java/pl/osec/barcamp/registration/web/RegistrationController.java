package pl.osec.barcamp.registration.web;

import pl.osec.barcamp.registration.model.Registration;
import pl.osec.barcamp.registration.model.RegistrationRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

import static java.lang.String.valueOf;
import static pl.osec.barcamp.registration.web.WebApplication.API_VERSION_1;

@Path("/registrations")
public class RegistrationController {

    @Inject
    private RegistrationRepository registrationRepository;

    @GET
    @Produces(API_VERSION_1)
    public List<Registration> getRegistrations() {
        return registrationRepository.getAllRegistrations();
    }

    @GET()
    @Path("/{id}")
    @Produces(API_VERSION_1)
    public Registration getRegistration(@PathParam("id") long id) {
        return registrationRepository.findRegistrationBy(id);
    }

    @POST
    @Produces(API_VERSION_1)
    public Response register(
            @Context UriInfo uriInfo,
            @FormParam("email") String email,
            @FormParam("name") String name,
            @FormParam("lastName") String lastName) {

        Registration registration =
                registrationRepository.save(buildRegistration(email, name, lastName));
        return Response.created(buildLocationUriFor(registration, uriInfo)).build();
    }

    private Registration buildRegistration(String email, String name, String lastName) {
        return new Registration()
                .setEmail(email)
                .setName(name)
                .setLastName(lastName);
    }

    private URI buildLocationUriFor(Registration registration, UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder()
                .path("/registrations/")
                .path(valueOf(registration.getId()))
                .build();
    }

    public void setRegistrationRepository(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }
}
