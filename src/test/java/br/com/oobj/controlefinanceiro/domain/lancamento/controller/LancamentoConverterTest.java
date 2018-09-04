package br.com.oobj.controlefinanceiro.domain.lancamento.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.oobj.controlefinanceiro.ControleFinanceiroTestContext;
import br.com.oobj.controlefinanceiro.domain.categoria.model.Categoria;
import br.com.oobj.controlefinanceiro.domain.lancamento.model.Lancamento;
import br.com.oobj.controlefinanceiro.domain.lancamento.model.StatusLancamento;
import br.com.oobj.controlefinanceiro.domain.lancamento.model.TipoLancamento;

/**
 * Testes unitários da classe {@link LancamentoConverter}.
 * 
 * @author Danilo Guimarães
 *
 */
@SpringBootTest
@ContextConfiguration(classes = { ControleFinanceiroTestContext.class })
@RunWith(SpringRunner.class)
public class LancamentoConverterTest {
	
	private static final Long LANCAMENTO_ID = 1L;
	private static final Date LANCAMENTO_DATA = new Date();
	private static final String LANCAMENTO_DESCRICAO = "Restaurante da Dona Benta";
	private static final Categoria LANCAMENTO_CATEGORIA = new Categoria("Alimentação");
	private static final StatusLancamento LANCAMENTO_STATUS = StatusLancamento.CONSOLIDADO;
	private static final TipoLancamento LANCAMENTO_TIPO = TipoLancamento.DESPESA;
	private static final BigDecimal LANCAMENTO_VALOR = new BigDecimal("15.99");
	
	@Autowired
	private LancamentoConverter sut;
	
	@Test
	public void testLancamentoConverterNaoPodeSerNulo() {
		assertThat(sut).isNotNull();
	}
	
	@Test
	public void testConvertToEntity() {
		LancamentoDTO dto = buildDTO();
		Lancamento entity = sut.convertToEntity(dto);
		
		assertThat(entity.getId()).isEqualTo(LANCAMENTO_ID);
		assertThat(entity.getData()).isEqualTo(LANCAMENTO_DATA);
		assertThat(entity.getDescricao()).isEqualTo(LANCAMENTO_DESCRICAO);
		assertThat(entity.getCategoria().getDescricao()).isEqualTo(LANCAMENTO_CATEGORIA.getDescricao());
		assertThat(entity.getStatusLancamento()).isEqualTo(LANCAMENTO_STATUS);
		assertThat(entity.getTipoLancamento()).isEqualTo(LANCAMENTO_TIPO);
		assertThat(entity.getValor()).isEqualTo(LANCAMENTO_VALOR);
	}
	
	@Test
	public void testConvertToDTO() {
		Lancamento entity = buildEntity();
		LancamentoDTO dto = sut.convertToDTO(entity);
		
		assertThat(dto.getId()).isEqualTo(LANCAMENTO_ID);
		assertThat(dto.getDescricao()).isEqualTo(LANCAMENTO_DESCRICAO);
		assertThat(dto.getData()).isEqualTo(LANCAMENTO_DATA);
		assertThat(dto.getCategoria()).isEqualTo(LANCAMENTO_CATEGORIA.getDescricao());
		assertThat(dto.getTipoLancamento()).isEqualTo(LANCAMENTO_TIPO.getCodigo());
		assertThat(dto.getStatusLancamento()).isEqualTo(LANCAMENTO_STATUS.getDescricao());
		
	}
	
	@Rule
	public ExpectedException illegalArgumentEx = ExpectedException.none();
	
	@Test
	public void testConvertToEntityAoPassarDTONuloDeveLancarIllegalArgumentException() {
		illegalArgumentEx.expect(IllegalArgumentException.class);
		illegalArgumentEx.expectMessage("O DTO nao pode ser nulo");
		
		sut.convertToEntity(null);
	}
	
	@Test
	public void testConvertToDTOAoPassarEntidadeNulaDeveLancarIllegalArgumentException() {
		illegalArgumentEx.expect(IllegalArgumentException.class);
		illegalArgumentEx.expectMessage("A entidade nao pode ser nula");
		
		sut.convertToDTO(null);
	}
	
	private LancamentoDTO buildDTO() {
		LancamentoDTO lancamentoDTO = new LancamentoDTO();
		
		lancamentoDTO.setId(1L);
		lancamentoDTO.setData(LANCAMENTO_DATA);
		lancamentoDTO.setDescricao(LANCAMENTO_DESCRICAO);
		lancamentoDTO.setCategoria(LANCAMENTO_CATEGORIA.getDescricao());
		lancamentoDTO.setStatusLancamento(LANCAMENTO_STATUS.getDescricao());
		lancamentoDTO.setTipoLancamento(LANCAMENTO_TIPO.getCodigo());
		lancamentoDTO.setValor(LANCAMENTO_VALOR);
		
		return lancamentoDTO;
	}
	
	private Lancamento buildEntity() {
		Lancamento lancamento = new Lancamento();
		lancamento.setId(1L);
		lancamento.setData(LANCAMENTO_DATA);
		lancamento.setDescricao(LANCAMENTO_DESCRICAO);
		lancamento.setCategoria(LANCAMENTO_CATEGORIA);
		lancamento.setStatusLancamento(LANCAMENTO_STATUS);
		lancamento.setTipoLancamento(LANCAMENTO_TIPO);
		lancamento.setValor(LANCAMENTO_VALOR);
		
		return lancamento;
	}

}
