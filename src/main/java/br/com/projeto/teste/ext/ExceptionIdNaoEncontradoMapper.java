package br.com.projeto.teste.ext;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ExceptionIdNaoEncontradoMapper implements ExceptionMapper<ExceptionIdNaoEncontrado> {

	public Response toResponse(ExceptionIdNaoEncontrado exception) {
		return Response.status(404).header("Id não encontrado", exception.getMessage()).build();
	}

}
