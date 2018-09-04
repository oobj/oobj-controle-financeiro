package br.com.oobj.controlefinanceiro.converter;

/**
 * Conversor de entidade em DTO, e vice-versa.
 * 
 * @author Danilo
 *
 * @param <E> uma Entidade 
 * @param <D> um DTO
 */
public interface Converter<E, D> {
	
	/**
	 * Converte um DTO em uma entidade
	 * 
	 * @param dto o DTO
	 * @return uma instância da entidade
	 */
	E convertToEntity(D dto);
	
	/**
	 * Converte uma entidade em um DTO.
	 * 
	 * @param entity a entidade
	 * @return uma instância do DTO
	 */
	D convertToDTO(E entity);
	
	

}
