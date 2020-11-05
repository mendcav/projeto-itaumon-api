package br.com.itau.itaumon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.itaumon.beans.Usuario;
import br.com.itau.itaumon.dao.UsuarioDAO;

@RestController // Indica que a classe irá responder protocolos HTTP (GET/POST)
@CrossOrigin("*")
public class UsuarioController {

	@Autowired // indica que o gerenciamento do atributo sera feito pelo Spring
	private UsuarioDAO dao;

	@GetMapping("/todosusuarios")
	public ResponseEntity<List<Usuario>> getAll(){
		List<Usuario> lista = (List<Usuario>) dao.findAll();
		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/novousuario/{cod}")
	public ResponseEntity<Usuario> pesquisarUsuario(@PathVariable int cod) {
		Usuario objeto = dao.findById(cod).orElse(null);
		if (objeto == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(objeto);
	}
	
	@DeleteMapping("/deletausuario/{cod}")
	public ResponseEntity<Usuario> apagarUsuario(@PathVariable int cod) {
		Usuario objeto = dao.findById(cod).orElse(null);
		if (objeto == null) {
			return ResponseEntity.status(404).build();
		}
		dao.delete(objeto);
		return ResponseEntity.ok(objeto);
	}

	@PostMapping("/login")
	public ResponseEntity<Usuario> logar(@RequestBody Usuario objeto){
		Usuario users = null;
		users = dao.findByEmailAndSenha(objeto.getEmail(),objeto.getSenha() );

		if (users == null ) {
			users=dao.findByRacfAndSenha(objeto.getEmail(),objeto.getSenha());
			if (users == null ) {
				return ResponseEntity.status(403).build();
			}

		}
		return ResponseEntity.ok(users);

	}

	
	@PutMapping("/usuario/{cod}")
	public ResponseEntity<Usuario> update(@PathVariable int cod, @RequestBody Usuario objeto){
		try {
			objeto.setCodigo(cod);
			Usuario resposta = dao.save(objeto);
			return ResponseEntity.ok(resposta);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
		
	}
	
	

	@PostMapping("/novousuario")
	public ResponseEntity<Usuario> add(@RequestBody Usuario objeto){
		try {
			Usuario resposta = dao.save(objeto);
			return ResponseEntity.ok(resposta);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
		
	}

	@GetMapping("/getnome/{var}")
	public ResponseEntity<List<Usuario>> getNome(@PathVariable String var){
		List<Usuario> lista = dao.findByNome(var);
		if (lista==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}


	@GetMapping("/usuariositau")
	public ResponseEntity<List<Usuario>> getUsersItau(){
		List<Usuario> todos = (List<Usuario>)dao.findAll();
		List<Usuario> resposta = new ArrayList<Usuario>();

		for (Usuario objeto : todos) {
			if (objeto.getEmail().indexOf("ITAU-UNIBANCO.COM.BR")>-1 ) {
				resposta.add(objeto);
			}

		}

		if (resposta.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resposta);
	}




}
