package modelo;

import java.util.*;

public class MiVersion {

	// Función recursiva para el recorrido DFS (búsqueda en profundidad)
	private static void dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, ArrayList<Integer> res) {
		visited[s] = true;
		res.add(s);

		// Visita recursivamente todos los vértices adyacentes que no han sido visitados
		for (int i : adj.get(s)) {
			if (!visited[i]) {
				dfsRec(adj, visited, i, res);
			}
		}
	}

	// Función principal de DFS que inicializa el arreglo de visitados y llama a dfsRec
	public static ArrayList<Integer> DFS(ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()];
		ArrayList<Integer> res = new ArrayList<>();
		dfsRec(adj, visited, 0, res);
		return res;
	}

	// Agrega una arista en un grafo no dirigido
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int t) {
		adj.get(s).add(t);
		adj.get(t).add(s);
	}

	// Recorrido DFS de forma iterativa a partir de un nodo inicial
	public static ArrayList<Integer> DFSIterativo(ArrayList<ArrayList<Integer>> adj, int start) {
	    boolean[] visited = new boolean[adj.size()];
	    ArrayList<Integer> res = new ArrayList<>();
	    Stack<Integer> stack = new Stack<>();

	    // Apila el nodo inicial
	    stack.push(start);

	    while (!stack.isEmpty()) {
	        int node = stack.pop();

	        if (!visited[node]) {
	            visited[node] = true;
	            res.add(node);

	            // Agrega los vecinos no visitados al stack
	            for (int vecino : adj.get(node)) {
	                if (!visited[vecino]) {
	                    stack.push(vecino);
	                }
	            }
	        }
	    }

	    return res;
	}
}
