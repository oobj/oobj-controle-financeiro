package br.com.oobj.controlefinanceiro.domain.conta.controller;


import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import br.com.oobj.controlefinanceiro.converter.Converter;
import br.com.oobj.controlefinanceiro.domain.conta.model.Conta;
import br.com.oobj.controlefinanceiro.domain.usuario.model.Usuario;

/**
 * Converter para entidade e DTO relacioandos a Conta.
 * 
 * @author Danilo Guimarães
 *
 */
@Component
public class ContaConverter implements Converter<Conta, ContaDTO> {

	@Override
	public Conta convertToEntity(ContaDTO dto) {
		Assert.notNull(dto, "O DTO nao pode ser nulo");
		
		Conta conta = new Conta();
		conta.setId(dto.getId());
		conta.setNome(dto.getNome());
		
		String loginUsuario = dto.getUsuario();
		
		if (StringUtils.hasText(loginUsuario)) {
			Usuario u = new Usuario();
			u.setLogin(loginUsuario);
			conta.setUsuario(u);
		}

		conta.setSaldoInicial(dto.getSaldoInicial());
		
		return conta;
	}

	@Override
	public ContaDTO convertToDTO(Conta entity) {
		Assert.notNull(entity, "A entidade nao pode ser nula");
		
		ContaDTO contaDTO = new ContaDTO();
		contaDTO.setId(entity.getId());
		contaDTO.setNome(entity.getNome());
		contaDTO.setUsuario(entity.getUsuario().getLogin());
		contaDTO.setSaldoInicial(entity.getSaldoInicial());
		
		return contaDTO;
	}

}
