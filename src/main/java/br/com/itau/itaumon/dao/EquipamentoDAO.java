package br.com.itau.itaumon.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.itaumon.beans.Equipamento;

public interface EquipamentoDAO extends CrudRepository<Equipamento, Integer> {

}
