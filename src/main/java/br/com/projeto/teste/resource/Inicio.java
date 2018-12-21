package br.com.projeto.teste.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ola-mundo")
public class Inicio{
	
	@GET
	public String getHello() {
		return "Hello World";	
	}

}
