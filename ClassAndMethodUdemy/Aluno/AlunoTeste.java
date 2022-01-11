public class AlunoTeste {
	
	public static void main(String[] args) {
		
		Aluno aluno1 = new Aluno("Luan");
		Aluno aluno2 = new Aluno("Nayara");
		Aluno aluno3 = new Aluno("Lizandra");
		
		Curso curso1 = new Curso("Fisioterapia");
		Curso curso2 = new Curso("Java");
		Curso curso3 = new Curso("JavaScript");
		
		curso1.adicionarAluno(aluno2);
		curso1.adicionarAluno(aluno3);
		
		curso2.adicionarAluno(aluno1);
		curso2.adicionarAluno(aluno2);
		
		aluno1.adicionarCurso(curso3);
		aluno3.adicionarCurso(curso3);
		
		
		for (Aluno aluno : curso1.alunos) {
			
			System.out.println("Estou matriculado no curso de "+ curso1.nome);
			System.out.println("Meu nome e "+ aluno.nome);
			System.out.println();
			
		}
		for (Aluno aluno : curso2.alunos) {
			
			System.out.println("Estou matriculado no curso de "+ curso2.nome);
			System.out.println("Meu nome e "+ aluno.nome);
			System.out.println();
		}
		
		System.out.println(aluno1.cursos.get(1).alunos);
		System.out.println(curso2.alunos.get(1).cursos);
		
	}

}
