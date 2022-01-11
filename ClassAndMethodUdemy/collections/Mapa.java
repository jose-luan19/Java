import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Mapa {
	
	public static void main(String[] args) {
		
		Map<Integer, String> usuarios = new HashMap<Integer, String>();
		usuarios.put(1, "Lucas");
		usuarios.put(1, "Luan");
		usuarios.put(2, "Lizandra");
		usuarios.put(3, "Nayara");
		
		System.out.println(usuarios.size());
		System.out.println(usuarios.isEmpty());
		
		System.out.println(usuarios.keySet());
		System.out.println(usuarios.values());
		System.out.println(usuarios.entrySet());
		
		System.out.println(usuarios.containsKey(2));
		System.out.println(usuarios.containsValue("Nayara"));
		
		System.out.println(usuarios.get(2));
		
		for (Integer chave : usuarios.keySet()) {
			System.out.println(chave);
		}
		for (String valor : usuarios.values()) {
			System.out.println(valor);
			
		}
		
		System.out.println(usuarios.remove(3, "Nayara"));
		System.out.println(usuarios.remove(3, "Lizandra"));
		for(Entry<Integer, String> registro: usuarios.entrySet()) {
			System.out.print(registro.getKey()+"-->");
			System.out.println(registro.getValue());
		}
		
	}

}
