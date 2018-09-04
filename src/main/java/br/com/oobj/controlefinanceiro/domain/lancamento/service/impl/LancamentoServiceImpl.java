package br.com.oobj.controlefinanceiro.domain.lancamento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oobj.controlefinanceiro.domain.lancamento.model.Lancamento;
import br.com.oobj.controlefinanceiro.domain.lancamento.repository.LancamentoRepository;
import br.com.oobj.controlefinanceiro.domain.lancamento.service.LancamentoService;
import br.com.oobj.controlefinanceiro.service.AbstractService;

@Service
public class LancamentoServiceImpl extends AbstractService<Lancamento, LancamentoRepository> implements LancamentoService {
	
	private final LancamentoRepository lancamentoRepository;
	
	@Autowired
	public LancamentoServiceImpl(LancamentoRepository lancamentoRepository) {
		this.lancamentoRepository = lancamentoRepository;
	}
	
}
