package test;
import modelo.DFSGrafo;
import java.util.*;

public class TestDFSGrafo {

	public static void main(String[] args) {
		int V = 5;
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		// Initialize adjacency list
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		// Add edges
		int[][] edges = { { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 } };
		
		for (int[] e : edges) {
			DFSGrafo.addEdge(adj, e[0], e[1]);
		}

		// Perform DFS starting from vertex 0
		ArrayList<Integer> res = DFSGrafo.DFS(adj);

		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

}
