package br.com.itau.itaumon.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.itaumon.beans.Alarme;

public interface AlarmeDAO extends CrudRepository<Alarme, Integer>{

}
