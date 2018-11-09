package be.thomasmore.travelmore.rest;


import be.thomasmore.travelmore.domain.Land;

import be.thomasmore.travelmore.dto.LandDto;
import be.thomasmore.travelmore.service.LandService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/landen")
public class LandRestService {

    @Inject
    private LandService landservice;

    @GET
    @Path("/getland")
    @Produces({MediaType.APPLICATION_JSON})
    public LandDto getLandById(@QueryParam("id") int id) {
      return landservice.findLandDtoById(id);
    }

    @POST
    @Path("/addland")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addLand(Land land){
        if(null != landservice.findLandById(land.getId())){
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .entity("land id should not be set.")
                    .build();
        }
        landservice.insertLand(land);
        return Response.status(Response.Status.CREATED).entity(land).build();
    }
}
