package modelo;

import java.util.*;

public class DFSGrafo {

	// Función recursiva para recorrer el grafo con DFS
	private static void dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s, ArrayList<Integer> res) {
		visited[s] = true;     // Marca el nodo actual como visitado
		res.add(s);            // Agrega el nodo actual al resultado

		// Recorre recursivamente todos los nodos adyacentes no visitados
		for (int i : adj.get(s)) {
			if (!visited[i]) {
				dfsRec(adj, visited, i, res);
			}
		}
	}

	// Método principal para ejecutar DFS
	public static ArrayList<Integer> DFS(ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()]; // Arreglo para marcar nodos visitados
		ArrayList<Integer> res = new ArrayList<>();  // Lista para guardar los nodos en orden de visita
		dfsRec(adj, visited, 0, res); // Comienza desde el nodo 0
		return res;
	}

	// Agrega una arista en un grafo no dirigido entre los nodos s y t
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int t) {
		adj.get(s).add(t); // Conecta s → t
		adj.get(t).add(s); // Conecta t → s (no dirigido)
	}
}
