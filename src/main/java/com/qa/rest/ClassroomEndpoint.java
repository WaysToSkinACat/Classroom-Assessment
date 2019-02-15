package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomService;



@Path("/classroom")
public class ClassroomEndpoint 
{
	@Inject
	private ClassroomService service;
	
	@Path("/getAllClassrooms")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return service.getAllClassroom();
	}

	@Path("/createClassroom")
	@POST
	@Produces({ "application/json" })
	public String createClassroom(String account) {
		return service.createClassroom(account);
	}

	@Path("/deleteClassroom/{roomNum}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("roomNum") Long roomNum) {
		return service.deleteClassroom(roomNum);
	}

	@Path("/updateClassroom/{roomNum}")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(@PathParam("roomNum") Long roomNum, String account) {
		return service.updateClassroom(roomNum, account);
	}

	@Path("/getAroomNum/{roomNum}")
	@GET
	@Produces({ "application/json" })
	public String getAnClassroom(@PathParam("roomNum") Long roomNum) {
		return service.getAClassroom(roomNum);
	}

	
}
