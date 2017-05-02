package br.usjt.app.servicedesck.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
	@NamedQuery(name="SLA.listarTodas",query="SELECT  s FROM SLA s")
})
public class SLA {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	@NotNull
	private String descricao;
	
	@NotNull
	private Integer tempoDeAtendimento;
	
	@Min(0)
	@Max(5)
	private int nivel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTempoDeAtendimento() {
		return tempoDeAtendimento;
	}

	public void setTempoDeAtendimento(Integer tempoDeAtendimento) {
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
