package br.com.oobj.controlefinanceiro.domain.lancamento.controller;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import br.com.oobj.controlefinanceiro.converter.Converter;
import br.com.oobj.controlefinanceiro.domain.categoria.model.Categoria;
import br.com.oobj.controlefinanceiro.domain.lancamento.model.Lancamento;

@Component
public class LancamentoConverter implements Converter<Lancamento, LancamentoDTO> {

	@Override
	public Lancamento convertToEntity(LancamentoDTO dto) {
		Assert.notNull(dto, "O DTO nao pode ser nulo");
		
		Lancamento lancamento = new Lancamento();
		
		lancamento.setId(dto.getId());
		lancamento.setDescricao(dto.getDescricao());
		lancamento.setData(dto.getData());
		lancamento.setCategoria(new Categoria(dto.getCategoria()));
		
		return lancamento;
	}

	@Override
	public LancamentoDTO convertToDTO(Lancamento entity) {
		Assert.notNull(entity, "A entidade nao pode ser nula");
		
		LancamentoDTO lancamentoDTO = new LancamentoDTO();
		
		lancamentoDTO.setId(entity.getId());
		lancamentoDTO.setData(entity.getData());
		lancamentoDTO.setDescricao(entity.getDescricao());
		lancamentoDTO.setCategoria(entity.getCategoria().getDescricao());
		lancamentoDTO.setStatusLancamento(entity.getStatusLancamento().getDescricao());
		lancamentoDTO.setTipoLancamento(entity.getTipoLancamento().getCodigo());
		lancamentoDTO.setValor(entity.getValor());
		
		return lancamentoDTO;
	}

}
