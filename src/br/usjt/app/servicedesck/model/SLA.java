package br.usjt.app.servicedesck.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class SLA {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	@NotNull
	private String descricao;
	
	@NotNull
	@Temporal(TemporalType.TIME)
	private Date tempoDeAtendimento;
	
	@Min(0)
	@Max(5)
	private int nivel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTempoDeAtendimento() {
		return tempoDeAtendimento;
	}

	public void setTempoDeAtendimento(Date tempoDeAtendimento) {
		this.tempoDeAtendimento = tempoDeAtendimento;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
