package br.com.projeto.teste.ext;

public class ExceptionIdNaoEncontrado extends RuntimeException{

	private static final long serialVersionUID = 8716276372447160577L;
	
	public ExceptionIdNaoEncontrado(String message) {
		super(message);
	}
}
