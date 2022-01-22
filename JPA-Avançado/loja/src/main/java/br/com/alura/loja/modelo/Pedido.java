package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private LocalDate data = LocalDate.now();

	@ManyToOne(fetch = FetchType.LAZY)//Boa pratica 
	private Cliente cliente;

	// Caso que quisse criar uam tabela apenas com os id's
	// das duas tabelas do relacionamento, seria assim:
//	@ManyToMany
//	@JoinTable()
//	private List<Produto> produtos;

	// O ideal a se fazer para construir uma relação n:n onde eu preciso 
	//ter mais do que só os id's é criar uma nova entidade.
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) 
	// mappedBy: Mostrar a JPA que esse mapeamento é bidirecional, 
	//passando o nome do atributo do outro lado
	
	//cascade: Realizar o efeito cascata na tabela de relação, no caso a ItemPedido
	//CascadeType.ALL: Reproduzir tudo na tabela de relação, nesse caso a ItemPedido
	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido() {
	}

	public void adicionarItem(ItemPedido item) {
		//Metodo para adicionar os itens as duas entidades Pedido e ItemPedido
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValorTotal());
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
