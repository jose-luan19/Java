package br.com.alura.spring.data.orm;
/**
 * @author jose luan
 * Interface based Projection.
 *
 */
public interface FuncionarioProjecao {

	Integer getId();
	
	String getNome();
	
	Double getSalario();
}

/**
 * Como alternativa, podemos também usar uma classe com o mesmo propósito:
 * Uma classe dá muito mais trabalho de escrever e manter, mas pode ter uma vantagem, 
 * pois podemos adicionar métodos mais específicos que podem fazer sentido para 
 * a view (por exemplo, os de formatação).
 */
