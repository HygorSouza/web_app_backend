package br.usjt.app.servicedesck.model;

import java.util.Date;

public class SLA {
	private Long id;

	private Date tempoDeAtendimento;

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
}
