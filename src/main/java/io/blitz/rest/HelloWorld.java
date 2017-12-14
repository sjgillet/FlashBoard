package com.blitz.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.blitz.beans.User;
import com.blitz.userdao.UserDAO;

@Path("/hello")
public class HelloWorld {
/*	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	} */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayJSONHello() {
		//return "{\"message\":\"Hello\"}";
		return toJSON();
	} 
	
	private String toJSON() {
		UserDAO udao = new UserDAO();
		User u = new User("Han");
		
		System.out.println("User inserted at: " + udao.insertUser(u));
		//User is a keyword (?) so it can't be a table name
		u = udao.getuserById(50);
		String uName = u.getUsername();
		
		StringBuilder sb = new StringBuilder();
		sb.append("{\"message\":\"");
		sb.append(uName);
		sb.append("\"}");
		
		
		return sb.toString();
	}
}
