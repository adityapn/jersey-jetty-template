package com.pnaditya.jersey.JerseyTemplate;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.pnaditya.jersey.resources.OtherResource;
import com.pnaditya.jersey.resources.UserResource;

public class App {
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");

		Server jettyServer = new Server(8888);
		jettyServer.setHandler(context);

		// Adding resources as servlet to jetty
		ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class,
				"/user/*");
		jerseyServlet.setInitOrder(0);
		jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
				UserResource.class.getCanonicalName());

		ServletHolder otherServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class,
				"/other/*");
		otherServlet.setInitOrder(0);
		otherServlet.setInitParameter("jersey.config.server.provider.classnames",
				OtherResource.class.getCanonicalName());

		try {
			jettyServer.start();
			jettyServer.join();
		} finally {
			jettyServer.destroy();
		}
	}
}