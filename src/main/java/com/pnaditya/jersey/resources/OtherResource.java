package com.pnaditya.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.pnaditya.jersey.requests.UserResponse;

@Path("/")
public class OtherResource {

	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById() {
		return Response.ok("test").build();
	}

}