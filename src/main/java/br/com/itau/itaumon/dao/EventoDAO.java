package br.com.itau.itaumon.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.itaumon.beans.Evento;

public interface EventoDAO extends CrudRepository <Evento, Integer>{

}
