package br.com.oobj.controlefinanceiro.domain.lancamento.controller;

import java.math.BigDecimal;
import java.util.Date;

public class LancamentoDTO {

	private Long id;
	private String conta;
	private Date data;
	private String descricao;
	private String categoria;
	private String statusLancamento;
	private Integer tipoLancamento;
	private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getConta() {
		return conta;
	}
	
	public void setConta(String conta) {
		this.conta = conta;
	}

	public Date getData() {
		if (data != null) {
			return (Date) data.clone();
		}
		
		return null;
	}

	public void setData(Date data) {
		if (data != null) {
			this.data = (Date) data.clone();
		}
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getStatusLancamento() {
		return statusLancamento;
	}

	public void setStatusLancamento(String statusLancamento) {
		this.statusLancamento = statusLancamento;
	}

	public Integer getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(Integer tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
