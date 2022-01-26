package br.com.alura.spring.data.orm;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	
	private String bairro;
	private Integer cep;
	

	public Endereco(String bairro, Integer cep) {
		this.bairro = bairro;
		this.cep = cep;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public Integer getCep() {
		return cep;
	}


	public void setCep(Integer cep) {
		this.cep = cep;
	}


	@Override
	public String toString() {
		return "bairro=" + bairro + ", cep=" + cep + "";
	}

	
	
}
