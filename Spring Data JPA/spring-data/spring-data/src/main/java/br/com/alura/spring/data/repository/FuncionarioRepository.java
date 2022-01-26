package br.com.alura.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;

@Repository
public interface FuncionarioRepository extends 
	PagingAndSortingRepository<Funcionario, Integer>,
	JpaSpecificationExecutor<Funcionario>{
	
	//Derived Query: Criando uma query sem precisar de SQL, a framework já faz tudo
	List<Funcionario> findByNome(String nome);
	
	//Derived Query: Filtragem por Nome, por Data de contratação e um Salário Maior do que o informado
	//List<Funcionario> findByNameAndSalarioGreaterThanAndDataContratacao(String nome, Double salario, LocalDate data);
	
	//filtragem por Nome, por Data de contratação e um Salário Maior do que o informado
	@Query("SELECT f FROM Funcionario f WHERE "
			+ "f.nome = :nome "
			+ "AND f.salario >= :salario "
			+ "AND f.dataContratacao = :data")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);
	
	@Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data",
			nativeQuery = true)
	
	List<Funcionario> findDataContratacaoMaior(LocalDate data);
	
	//Foi preciso criar uma interface para servir de projeção da minha entidade
	//Isso acontece pois eu só preciso de 2 atributos da minha entidade
	//Para fazer isso, basta criar os get's em uma interface
	@Query(value = "SELECT f.id,f.nome,f.salario FROM funcionarios f",
			nativeQuery = true)
	List<FuncionarioProjecao> findFuncionarioSalario();
	
	
	
}
