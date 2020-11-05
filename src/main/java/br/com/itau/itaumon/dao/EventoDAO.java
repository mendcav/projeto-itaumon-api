package br.com.itau.itaumon.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.itaumon.beans.Evento;

public interface EventoDAO extends CrudRepository <Evento, Integer>{
	
	List<Evento> findByEvento(int evento);
	
	//Pesquisar intervalo
	List<Evento> findBycadastroBetween(Date inicio, Date fim);
	
	

}
