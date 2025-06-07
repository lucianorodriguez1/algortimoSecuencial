package test;

import modelo.DFSGrafo;
import java.util.*;

public class TestDFSGrafo {

    public static void main(String[] args) {
        int V = 100000;  // Número de vértices (nodos)
        int E = 200000;  // Número de aristas (conexiones)

        // Crea la lista de adyacencia vacía
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        Random rand = new Random();
        Set<String> conexiones = new HashSet<>(); // Conjunto para evitar aristas duplicadas

        // Genera E conexiones aleatorias entre los nodos, sin repetir aristas
        while (conexiones.size() < E) {
            int u = rand.nextInt(V);
            int v = rand.nextInt(V);
            if (u != v && !conexiones.contains(u + "," + v) && !conexiones.contains(v + "," + u)) {
                conexiones.add(u + "," + v);        // Marca como creada
                DFSGrafo.addEdge(adj, u, v);        // Agrega la arista en la lista de adyacencia
            }
        }

        // Comienza a medir tiempo
        long inicio = System.currentTimeMillis();
        ArrayList<Integer> resultado = DFSGrafo.DFS(adj); // Ejecuta el recorrido DFS
        long fin = System.currentTimeMillis();            // Termina de medir tiempo

        // Muestra estadísticas del recorrido
        System.out.println("Nodos totales: " + V);
        System.out.println("Aristas totales: " + E);
        System.out.println("Nodos visitados: " + resultado.size());
        System.out.println("Tiempo de ejecución: " + (fin - inicio) + " ms");
    }
}
