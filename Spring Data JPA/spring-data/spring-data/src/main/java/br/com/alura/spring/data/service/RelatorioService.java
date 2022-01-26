package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatorioService {

	private Boolean system = true;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatorioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {

			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario nome");
			System.out.println("2 - Busca funcionario nome, data contratação e salario maior");
			System.out.println("3 - Busca funcionario data contratação");
			System.out.println("4 - Pesquisa de funcionarios com salario");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				buscaFuncionarioNome(scanner);
				break;
			case 2:
				buscaFuncionarioNomeSalarioMaiorData(scanner);
				break;
			case 3:
				buscaFuncionarioDataContratacao(scanner);
				break;
			case 4:
				buscarFuncionariosSalario();
				break;
			default:
				system = false;
				break;
			}
		}
	}
	
	private void buscaFuncionarioNome(Scanner scanner) {
		System.out.println("Qual nome que pesquisar");
		String nome = scanner.next();
		List<Funcionario> lista = funcionarioRepository.findByNome(nome);
		lista.forEach(System.out::println);
	}
	
	private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Qual nome que pesquisar");
		String nome = scanner.next();
		System.out.println("Qual a data de contratação");
		String data = scanner.next();
		LocalDate localData = LocalDate.parse(data,formatter);
		System.out.println("Qual o minimo do salario");
		Double salario = scanner.nextDouble();
		
		List<Funcionario> lista = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localData);
		lista.forEach(System.out::println);
	}
	
	private void buscaFuncionarioDataContratacao(Scanner scanner) {
		System.out.println("Qual a data de contratação");
		String data = scanner.next();
		LocalDate localData = LocalDate.parse(data,formatter);
		
		List<Funcionario> lista = funcionarioRepository.findDataContratacaoMaior(localData);
		lista.forEach(System.out::println);
	}
	
	private void buscarFuncionariosSalario() {
		List<FuncionarioProjecao> lista = funcionarioRepository.findFuncionarioSalario();
		
		lista.forEach(f-> System.out.println("Funcionario de id: "+ f.getId() +
				" | nome: "+f.getNome() + " | Salario: " +f.getSalario()));
	}
}
