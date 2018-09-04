package br.com.oobj.controlefinanceiro.domain.lancamento.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.oobj.controlefinanceiro.domain.categoria.model.Categoria;
import br.com.oobj.controlefinanceiro.domain.conta.model.Conta;
import br.com.oobj.controlefinanceiro.model.support.AbstractEntity;

/**
 * Um lançamento representa uma movimentação financeira.
 * 
 * @author Danilo Guimarães
 *
 */
@Entity
@Table(name = "lancamento")
public class Lancamento extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;
	
	@Column(name = "data_lancamento")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@Column(name = "status_lancamento")
	@Enumerated(EnumType.STRING)
	private StatusLancamento statusLancamento;
	
	@Column(name = "tipo_lancamento")
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipoLancamento;
	
	@Column
	private Integer quantidadeParcelas;
	
	@Column
	private BigDecimal valor;

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public StatusLancamento getStatusLancamento() {
		return statusLancamento;
	}

	public void setStatusLancamento(StatusLancamento statusLancamento) {
		this.statusLancamento = statusLancamento;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
