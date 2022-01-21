package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	public Categoria() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	
	public Categoria(String nomeCategoria) {
		this.setNome_categoria(nomeCategoria);
	}


	public String getNome_categoria() {
		return nome;
	}


	public void setNome_categoria(String nome_categoria) {
		this.nome = nome_categoria;
	}
	
	
}
