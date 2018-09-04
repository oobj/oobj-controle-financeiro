package br.com.oobj.controlefinanceiro.domain.lancamento.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Testes unitários para {@link TipoLancamento}
 * 
 * @author Danilo Guimarães
 *
 */
public class TipoLancamentoTest {
	
	@Test
	public void testFromDescricaoReceitaDeveRetornarEnumReceita() throws Exception {
		TipoLancamento tipoLancamentoReceita = TipoLancamento.fromDescricao("Receita");
		
		assertThat(tipoLancamentoReceita).isEqualTo(TipoLancamento.RECEITA);
	}
	
	@Test
	public void testFromDescricaoDespesaDeveRetornarEnumDespesa() throws Exception {
		TipoLancamento tipoLancamentoDespesa = TipoLancamento.fromDescricao("Despesa");
		
		assertThat(tipoLancamentoDespesa).isEqualTo(TipoLancamento.DESPESA);
	}
	
	@Test
	public void testFromDescricaoNullDeveRetornarNull() throws Exception {
		assertThat(TipoLancamento.fromDescricao(null)).isNull();
	}
	
	@Test
	public void testFromDescricaoStringVaziaDeveRetornarNull() throws Exception {
		assertThat(TipoLancamento.fromDescricao("")).isNull();
	}

}
