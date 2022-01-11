import java.util.LinkedList;
import java.util.Queue;

public class Fila {
	
	public static void main(String[] args) {
		
		Queue<String> fila = new LinkedList<String>();
		
		//Offer e Add,adiconam elementos a fila
		//difrença ocorre quando a fila está cheia
		fila.add("Luan");// fila cheia: error
		fila.offer("Nayara");// fila cheia: false
		fila.offer("Gui");
		fila.offer("Ana");
		
		//Peek e Element, obtem o proximo elemento da fila(sem remover)
		//difrença ocorre quando a fila está vazia

		System.out.println(fila.peek());// fila vazia: retorna false
		System.out.println(fila.element());// fila vazia: retorna error
		
		
		
		// Pool e Remove, retorna o proximo elemento da fila e remove o mesmo
		//diferença quando a fila está vazia
		System.out.println(fila.poll()); //fila vazia: retorna null
		System.out.println(fila.remove()); //fila vazia: retorna error
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		
		/* 
		 * fila.size();
		 * fila.clear();
		 * fila.isEmpty(); //Testa para ver se a fila está vazia
		 * fila.conatins(....);
		 * ...
		 */
		
	}

}
