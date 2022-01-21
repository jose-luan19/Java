package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;

public class CategoriaDAO {
	
	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	//metodo para retornar a instancia para o estado  MANAGED, para que eu posso fazer mais tratamentos
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remover(Categoria categoria) {
		//O metodo merge retorna uma nova referência  CUIDADO!!!
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}
}
