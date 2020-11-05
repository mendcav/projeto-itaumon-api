package br.com.itau.itaumon.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity //Para informar o SpringBoot que esta classe tem uma tabela no BD
@Table(name="itmn_alarme")
public class Alarme {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id // para indicar que este atributo faz ligação com a PK (Primary key) da tabela usuario
	@Column(name="id")
	private int codigo;
	
	@Column(name="nome",length=100)
	private String nome;
	
	@Column(name="descricao",length=200)
	private String descricao;
	
	@JsonIgnoreProperties("alarme")
	@OneToMany(mappedBy="alarme", cascade=CascadeType.ALL)
	private List<Evento> eventos;
	
	
	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Alarme(int codigo, String nome, String descricao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Alarme() {
		super();
	}

	
	
	
	
	

}
