package br.com.itau.itaumon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.itaumon.beans.Equipamento;
import br.com.itau.itaumon.beans.Usuario;
import br.com.itau.itaumon.dao.EquipamentoDAO;


@RestController // Indica que a classe irá responder protocolos HTTP (GET/POST)
@CrossOrigin("*")
public class EquipamentoController {

	@Autowired // indica que o gerenciamento do atributo sera feito pelo Spring
	private EquipamentoDAO dao;
	
	@GetMapping("/equipamentos")
	public ResponseEntity<List<Equipamento>> getAll(){
		List<Equipamento> lista = (List<Equipamento>) dao.findAll();
		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/equipamentos/{cod}")
	public ResponseEntity<Equipamento> pesquisarEquipamento(@PathVariable int cod) {
		Equipamento objeto = dao.findById(cod).orElse(null);
		if (objeto == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(objeto);
	}
	
}
