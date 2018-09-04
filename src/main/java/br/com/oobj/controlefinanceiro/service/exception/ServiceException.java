package br.com.oobj.controlefinanceiro.service.exception;

public class ServiceException extends RuntimeException {

	public ServiceException() {
		super();
	}
	public ServiceException(Throwable ex) {
		super(ex);
	}

}
