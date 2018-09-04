package br.com.oobj.controlefinanceiro.domain.lancamento.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import br.com.oobj.controlefinanceiro.domain.lancamento.model.StatusLancamento;

/**
 * Testes unitários para {@link StatusLancamento}
 * 
 * @author Danilo Guimarães
 *
 */
public class StatusLancamentoTest {
	
	@Test
	public void testFromDescricaoConsolidadoDeveRetornarEnumConsolidado() throws Exception {
		StatusLancamento statusConsolidado = StatusLancamento.fromDescricao("Consolidado");
		
		assertThat(statusConsolidado).isEqualTo(StatusLancamento.CONSOLIDADO);
	}
	
	@Test
	public void testFromDescricaoNaoConsolidadoDeveRetornarEnumNaoConsolidado() throws Exception {
		StatusLancamento statusNaoConsolidado = StatusLancamento.fromDescricao("Não consolidado");
		
		assertThat(statusNaoConsolidado).isEqualTo(StatusLancamento.NAO_CONSOLIDADO);
	}
	
	@Test
	public void testFromDescricaoNullDeveRetornarNull() throws Exception {
		assertThat(StatusLancamento.fromDescricao(null)).isNull();
	}
	
	@Test
	public void testFromDescricaoStringVaziaDeveRetornarNull() throws Exception {
		assertThat(StatusLancamento.fromDescricao("")).isNull();
	}

}
