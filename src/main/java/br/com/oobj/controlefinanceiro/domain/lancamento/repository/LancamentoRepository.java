package br.com.oobj.controlefinanceiro.domain.lancamento.repository;

import org.springframework.stereotype.Repository;

import br.com.oobj.controlefinanceiro.domain.lancamento.model.Lancamento;
import br.com.oobj.controlefinanceiro.repository.support.BaseRepository;

@Repository
public interface LancamentoRepository extends BaseRepository<Lancamento> {
	
}
