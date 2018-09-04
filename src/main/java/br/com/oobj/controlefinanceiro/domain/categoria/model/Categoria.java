package br.com.oobj.controlefinanceiro.domain.categoria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.oobj.controlefinanceiro.model.support.AbstractEntity;

@Entity
@Table(name = "categoria")
public class Categoria extends AbstractEntity {
	
	@Column
	private String descricao;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	
	public Categoria() {
		super();
	}
	
	public Categoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	

}
