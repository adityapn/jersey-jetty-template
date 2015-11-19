package com.pnaditya.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pnaditya.jersey.domain.User;
import com.pnaditya.jersey.requests.UserResponse;

@Path("/")
public class UserResource {

	private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

	@POST
	public Response createUser(UserResponse userRq) {
		User user = new User();
		user.setUsername(userRq.getUsername());
		user.setPassword(userRq.getPlace());

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return Response.noContent().build();
	}

	@GET
	@Path("/{user_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("user_id") Integer userId) {
		UserResponse user = new UserResponse();
		user.setPlace("Anantapur");
		user.setUsername("pnaditya");
		user.setId(userId);
		user.setUserLocation("Dwaraka Nagar");
		return Response.ok(user).build();
	}

}