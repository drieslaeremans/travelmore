package be.thomasmore.travelmore.rest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.dto.LocatieDto;
import be.thomasmore.travelmore.service.LandService;
import be.thomasmore.travelmore.service.LocatieService;
import be.thomasmore.travelmore.domain.Land;

import java.util.List;

@Path("/locaties")
public class LocatieRestService {
    @Inject
    private LocatieService locatieService;

    @GET
    @Path("/getlocatie")
    @Produces({MediaType.APPLICATION_JSON})
    public LocatieDto getLocatieById(@QueryParam("id") int id) {
        return locatieService.findLocatieDtoById(id);
    }

    @POST
    @Path("/addlocatie")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addLocatie(Locatie locatie){
        if(null != locatieService.findLocatieById(locatie.getId())){
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .entity("locatie id should not be set.")
                    .build();
        }
        locatieService.insertLocatie(locatie);
        return Response.status(Response.Status.CREATED).entity(locatie).build();
    }

    @GET
    @Path("/getlocaties")
    @Produces({MediaType.APPLICATION_JSON})
    public List<LocatieDto> getLocaties() {
        return locatieService.findAllLocatiesDto();
    }

    @DELETE
    @Path("/deletelocatie")
    public void removeLocatieById(@QueryParam("id")int id)
    {
        locatieService.removeLocatie(id);
    }
}
