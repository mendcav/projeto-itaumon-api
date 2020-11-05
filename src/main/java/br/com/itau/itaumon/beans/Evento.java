package br.com.itau.itaumon.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn_evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numseq")
	private int numseq;
	
	@Column(name="data")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@JsonIgnoreProperties("eventos")
	@ManyToOne
	private Equipamento equipamento;
	
	@JsonIgnoreProperties("eventos")
	@ManyToOne
	private Alarme alarme;

	public int getNumseq() {
		return numseq;
	}

	public void setNumseq(int numseq) {
		this.numseq = numseq;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Alarme getAlarme() {
		return alarme;
	}

	public void setAlarme(Alarme alarme) {
		this.alarme = alarme;
	}

	public Evento(int numseq, Date data, Equipamento equipamento, Alarme alarme) {
		super();
		this.numseq = numseq;
		this.data = data;
		this.equipamento = equipamento;
		this.alarme = alarme;
	}

	public Evento() {
		super();
	}

	
	
	
	
}
