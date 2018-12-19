package br.com.projeto.teste.repository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ola-mundo")
public class InicioRepository{
	
	@GET
	public String getHello() {
		return "Hello World";	
	}

}
