package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Maperando uma entidade

//Tornar essa classe em uma entidade, como se fosse a tabela do DB
@Entity
//Se no DB a tabela tem um nome diferente da classe, é preciso usar essa anotação @Table
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// Se no DB a coluna tem um nome diferente do atributo, é preciso usar essa
	// anotação @Column
	//@Column(name = "nome")
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();
	//É preciso mapear os atributos enums para identificação e possiveis modificações na ordem dos enums
	//Nesse caso eu estou associando o valor da String presente no enum Categoria
//	@Enumerated(EnumType.STRING)
	
	//Cardinalidade dos relacionamentos
	@ManyToOne
	private Categoria categoria;
	
	public Produto() {
	}

	public Produto(String nomeProduto, String descricao, BigDecimal preco, Categoria categoria) {

		this.nome = nomeProduto;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nome;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nome = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categoria getIdCategoria() {
		return categoria;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.categoria = idCategoria;
	}
	

}
