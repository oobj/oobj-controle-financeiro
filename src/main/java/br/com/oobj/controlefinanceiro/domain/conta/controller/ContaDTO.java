package br.com.oobj.controlefinanceiro.domain.conta.controller;

import java.math.BigDecimal;

/**
 * DTO para Conta.
 * 
 * @author Danilo Guimarães
 *
 */
public class ContaDTO {

	private Long id;
	private String nome;
	private String usuario;
	private BigDecimal saldoInicial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	
}
