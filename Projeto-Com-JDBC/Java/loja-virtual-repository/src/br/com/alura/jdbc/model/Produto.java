package br.com.alura.jdbc.model;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;
	private Integer categoriaId;

	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto() {
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("O produto é: %d, %s, %s", this.id, this.nome, this.descricao);
	}

}
