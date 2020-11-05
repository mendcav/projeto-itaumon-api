package br.com.itau.itaumon.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.itaumon.beans.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario,Integer>{

	public Usuario findByEmailAndSenha(String email,String senha);
	public Usuario findByRacfAndSenha(String racf,String senha); 
	public List<Usuario> findByNome(String nome);
		
}
