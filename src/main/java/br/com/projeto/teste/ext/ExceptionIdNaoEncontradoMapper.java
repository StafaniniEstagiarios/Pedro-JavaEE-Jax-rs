package br.com.projeto.teste.ext;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class ExceptionIdNaoEncontradoMapper implements ExceptionMapper<ExceptionIdNaoEncontrado> {

	public Response toResponse(ExceptionIdNaoEncontrado exception) {
		return Response.status(Response.Status.NOT_FOUND).header("Motivo: ", exception.getMessage()).build();
	}

}
