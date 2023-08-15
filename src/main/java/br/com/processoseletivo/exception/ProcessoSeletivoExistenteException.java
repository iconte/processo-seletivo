package br.com.processoseletivo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProcessoSeletivoExistenteException extends Exception {
	
	public ProcessoSeletivoExistenteException(String mensagem) {
		super(mensagem);
		
	}

}
