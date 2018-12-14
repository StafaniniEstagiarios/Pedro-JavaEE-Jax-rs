package br.com.ProjetoTeste.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ola-mundo")
public class RestService{
	
	@GET
	public String getHello() {
		return "Hello World";	
	}

}
