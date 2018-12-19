package br.com.projeto.teste.interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;

import br.com.projeto.teste.annotation.Transaction;

@Interceptor @Transaction
public class InterceptorTransational implements Serializable{

	private static final long serialVersionUID = -5423205193921458152L;
	
	@AroundInvoke

}
