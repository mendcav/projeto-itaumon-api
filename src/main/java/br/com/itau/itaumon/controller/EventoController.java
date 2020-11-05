package br.com.itau.itaumon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.itaumon.beans.Evento;
import br.com.itau.itaumon.dao.EventoDAO;

@RestController // Indica que a classe irá responder protocolos HTTP (GET/POST)
@CrossOrigin("*")
public class EventoController {

	@Autowired // indica que o gerenciamento do atributo sera feito pelo Spring
	private EventoDAO dao;

	@GetMapping("/eventosgeral")
	public ResponseEntity<List<Evento>> getAll(){
		List<Evento> lista = (List<Evento>) dao.findAll();
		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/evento/{cod}")
	public ResponseEntity<Evento> pesquisarEvento(@PathVariable int cod) {
		Evento objeto = dao.findById(cod).orElse(null);
		if (objeto == null) {
			return ResponseEntity.status(404).build();
			
		}
		return ResponseEntity.ok(objeto);
	}

	
}
