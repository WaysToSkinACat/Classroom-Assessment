package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.TraineeService;

@Path("/trainee")
public class TraineeEndpoint {
	@Inject
	private TraineeService service;

	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainee();
	}

	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String account) {
		return service.createTrainee(account);
	}

	@Path("/deleteTrainee/{studentNum}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("studentNum") Long studentNum) {
		return service.deleteTrainee(studentNum);
	}

	@Path("/updateTrainee/{studentNum}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("studentNum") Long studentNum, String account) {
		return service.updateTrainee(studentNum, account);
	}

	@Path("/getAstudentNum/{studentNum}")
	@GET
	@Produces({ "application/json" })
	public String getAnTrainee(@PathParam("studentNum") Long studentNum) {
		return service.getATrainee(studentNum);
	}
}
