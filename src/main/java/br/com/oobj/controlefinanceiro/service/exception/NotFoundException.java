package br.com.oobj.controlefinanceiro.service.exception;

public class NotFoundException extends ServiceException {

	public NotFoundException(Throwable ex) {
		super(ex);
	}

	public NotFoundException() {
		super();
	}

}
