package br.com.alura.jdbc.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	
	public void setProdutos(Produto produto) {
		produtos.add(produto);
	}
	
	public List<Produto> adicionar() {
		return produtos;
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	
	public Categoria() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return this.nome;
	}
	
}
