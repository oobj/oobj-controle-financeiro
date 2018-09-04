package br.com.oobj.controlefinanceiro.domain.usuario.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.oobj.controlefinanceiro.model.support.AbstractEntity;

@Entity
@Table(name = "usuario")
public class Usuario extends AbstractEntity {

	@Column
	private String login;
	
	@Column
	private String hashSenha;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataUltimoLogin;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHashSenha() {
		return hashSenha;
	}

	public void setHashSenha(String hashSenha) {
		this.hashSenha = hashSenha;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataUltimoLogin() {
		return dataUltimoLogin;
	}

	public void setDataUltimoLogin(Date dataUltimoLogin) {
		this.dataUltimoLogin = dataUltimoLogin;
	}

}
