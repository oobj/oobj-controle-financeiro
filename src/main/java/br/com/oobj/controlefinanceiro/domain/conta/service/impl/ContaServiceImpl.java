package br.com.oobj.controlefinanceiro.domain.conta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oobj.controlefinanceiro.domain.conta.model.Conta;
import br.com.oobj.controlefinanceiro.domain.conta.repository.ContaRepository;
import br.com.oobj.controlefinanceiro.domain.conta.service.ContaService;
import br.com.oobj.controlefinanceiro.service.AbstractService;

/**
 * Implementação padrão de {@link ContaService}.
 * 
 * @author Danilo Guimarães
 *
 */
@Service
public class ContaServiceImpl extends AbstractService<Conta, ContaRepository> implements ContaService {

	private final ContaRepository contaRepository;
	
	@Autowired
	public ContaServiceImpl(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}
}
