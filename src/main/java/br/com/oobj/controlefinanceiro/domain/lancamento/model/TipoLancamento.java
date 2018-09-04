package br.com.oobj.controlefinanceiro.domain.lancamento.model;

/**
 * Determina o tipo do lançamento: despesa ou receita.
 * 
 * @author Danilo Guimarães
 *
 */
public enum TipoLancamento {

	RECEITA(1, "Receita"),
	DESPESA(-1, "Despesa");
	
	private int codigo;
	private String descricao;
	
	TipoLancamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Procura uma instância de {@link TipoLancamento} que coincida com a descrição.
	 * 
	 * @param descricao a descrição que será utilizada para procurar o tipo do lançamento
	 * @return uma instância de {@link TipoLancamento} ou {@code null}
	 */
	public static TipoLancamento fromDescricao(String descricao) {
		for (TipoLancamento tipoLancamento : values()) {
			if (tipoLancamento.getDescricao().equals(descricao)) {
				return tipoLancamento;
			}
		}
		
		return null;
	}
}
