package br.com.oobj.controlefinanceiro.domain.conta.repository;

import org.springframework.stereotype.Repository;

import br.com.oobj.controlefinanceiro.domain.conta.model.Conta;
import br.com.oobj.controlefinanceiro.repository.support.BaseRepository;

/**
 * Repository para {@link Conta}
 * 
 * @author Danilo Guimarães
 *
 */
@Repository
public interface ContaRepository extends BaseRepository<Conta> {

}
