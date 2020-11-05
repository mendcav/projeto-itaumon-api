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
@Table(name="itmn_equipamento")
public class Equipamento {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id // para indicar que este atributo faz ligação com a PK (Primary key) da tabela usuario
	@Column(name="id")
	private int codigo;
	
	@Column(name="hostname",length=50)
	private String hostnome;
	
	@Column(name="ip",length=15)
	private String ip;

	@JsonIgnoreProperties("equipamento")
	@OneToMany(mappedBy="equipamento", cascade=CascadeType.ALL)
	private List<Evento> equipamentos;
		
	
	public List<Evento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Evento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public Equipamento() {
		super();
	}

	public Equipamento(int codigo, String hostnome, String ip) {
		super();
		this.codigo = codigo;
		this.hostnome = hostnome;
		this.ip = ip;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getHostnome() {
		return hostnome;
	}

	public void setHostnome(String hostnome) {
		this.hostnome = hostnome;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	

}
