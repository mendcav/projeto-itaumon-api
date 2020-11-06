package br.com.itau.itaumon.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.itau.itaumon.beans.Evento;

public interface EventoDAO extends CrudRepository <Evento, Integer>{
	
	List<Evento> findByDataBetween(Date inicio, Date fim);
	
	//Pesquisar intervalo
	@Query(value="SELECT count(numseq) as total FROM itmn_evento WHERE"
			+ " data >= :inicio AND data <= :fim AND alarme_id = :num", nativeQuery = true)
		long getByTotal(@Param("inicio") Date inicio, @Param("fim") Date fim, @Param("num") int num);	

	
	
	
	
	
}
