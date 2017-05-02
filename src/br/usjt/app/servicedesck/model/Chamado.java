package br.usjt.app.servicedesck.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries(value={
	@NamedQuery(name="Chamado.porPrioridade",query="SELECT DISTINCT(cmd) FROM Chamado cmd LEFT JOIN FETCH cmd.fila ORDER BY cmd.fila.sla.nivel , cmd.dataDeAbertura ASC"),
	@NamedQuery(name="Chamado.porPrioridadePorSolicitante",query="SELECT cmd FROM Chamado cmd LEFT JOIN FETCH cmd.fila  WHERE cmd.solicitante.id = :idSolicitante ORDER BY cmd.fila.sla.nivel , cmd.dataDeAbertura ASC")
})
public class Chamado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String breveDescricao;

	@NotNull
	private String descricao;

	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusChamado status;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDeAbertura;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDeFechamento;
	
	@ManyToOne
	private Fila fila;
	
	
	@ManyToOne
	private Usuario solicitante;
	
	@ManyToOne
	private Usuario solucionador;
	
	public Usuario getSolucionador() {
		return solucionador;
	}

	public void setSolucionador(Usuario solucionador) {
		this.solucionador = solucionador;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public StatusChamado getStatus() {
		return status;
	}

	public Calendar getDataDeAbertura() {
		return dataDeAbertura;
	}

	public Calendar getDataDeFechamento() {
		return dataDeFechamento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setStatus(StatusChamado status) {
		this.status = status;
	}

	public void setDataDeAbertura(Calendar dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}

	public void setDataDeFechamento(Calendar dataDeFechamento) {
		this.dataDeFechamento = dataDeFechamento;
	}

	public String getBreveDescricao() {
		return breveDescricao;
	}

	public void setBreveDescricao(String breveDescricao) {
		this.breveDescricao = breveDescricao;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}
	
	public Usuario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}

}
