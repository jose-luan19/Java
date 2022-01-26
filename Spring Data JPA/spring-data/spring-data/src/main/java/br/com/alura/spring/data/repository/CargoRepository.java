package br.com.alura.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Cargo;

//Anotação do spring
@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer>{
	//Interface que serve para receber os metodos de CRUD. Ou seja os metodos principais de 
	//manipulação do banco(SELECT INSERT DELETE UPDATE)
	
	
}
