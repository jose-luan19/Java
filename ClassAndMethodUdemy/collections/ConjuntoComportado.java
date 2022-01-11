import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConjuntoComportado {
	public static void main(String[] args) {
		
		//Set<String> listaAprovados = new HashSet<>(); //Lista com ordem aleatória
		SortedSet<String> listaAprovados = new TreeSet<>(); // Lista com ordem alfabética
		listaAprovados.add("Lizandra");
		listaAprovados.add("Luan");
		listaAprovados.add("Ana");
		listaAprovados.add("José");
		
		for (String candidato : listaAprovados) {
			System.out.println(candidato);
			
		}
		System.out.println();
		Set <Integer> nums = new HashSet<>();
		nums.add(60);
		nums.add(2);
		nums.add(9);
		nums.add(8);
		
		for (Integer n : nums) {
			System.out.println(n);
			
		}
	} 

}
