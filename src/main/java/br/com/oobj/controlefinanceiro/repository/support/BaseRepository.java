package br.com.oobj.controlefinanceiro.repository.support;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repositório base.
 * 
 * @author Danilo Guimarães
 *
 * @param <E>
 */
@NoRepositoryBean
public interface BaseRepository<E> extends CrudRepository<E, Long> {

}
