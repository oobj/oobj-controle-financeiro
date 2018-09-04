package br.com.oobj.controlefinanceiro.domain.lancamento.model;

public enum StatusLancamento {
	
	CONSOLIDADO(1, "Consolidado"),
	NAO_CONSOLIDADO(0, "Não consolidado");
	
	private int codigo;
	private String descricao;
	
	StatusLancamento(int codigo, String descricao) {
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
	 * Procura uma instância de {@link StatusLancamento} que coincida com a descrição.
	 * 
	 * @param descricao a descrição que será utilizada para procurar o status do lançamento
	 * @return uma instância de {@link StatusLancamento} ou {@code null}
	 */
	public static StatusLancamento fromDescricao(String descricao) {
		for (StatusLancamento statusLancamento : values()) {
			if (statusLancamento.getDescricao().equals(descricao)) {
				return statusLancamento;
			}
		}
		
		return null;
	}

}
