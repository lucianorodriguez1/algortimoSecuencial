package test;

import modelo.MiVersion;
import java.util.*;

public class TestMiVersion {

    public static void main(String[] args) {
      
        int V = 800000; // Número de vértices (nodos del grafo)
        int E = 10000000;  // Número de aristas

        // Inicializa la lista de adyacencias (grafo representado como lista de listas)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Generador de números aleatorios
        Random rand = new Random();

        // Conjunto para guardar conexiones únicas y evitar duplicados o lazos
        Set<String> conexiones = new HashSet<>();

        // Generar aristas aleatorias sin duplicados ni lazos (u != v)
        while (conexiones.size() < E) {
            int u = rand.nextInt(V); // Nodo origen
            int v = rand.nextInt(V); // Nodo destino

            // Verifica que no sea un lazo ni una conexión repetida en ambas direcciones
            if (u != v && !conexiones.contains(u + "," + v) && !conexiones.contains(v + "," + u)) {
                conexiones.add(u + "," + v);
                MiVersion.addEdge(adj, u, v); // Agrega la arista al grafo
            }
        }

        // Ejecutar el DFS iterativo y medir tiempo de ejecución
        long inicio = System.currentTimeMillis(); // Tiempo inicial
        ArrayList<Integer> resultado = MiVersion.DFSIterativo(adj, 0); // DFS desde nodo 0
        long fin = System.currentTimeMillis(); // Tiempo final

        // Mostrar resultados
        System.out.println("Número total de vértices: " + V);
        System.out.println("Número total de aristas: " + E);
        System.out.println("Nodos visitados por DFS iterativo: " + resultado.size());
        System.out.println("Tiempo de ejecución: " + (fin - inicio) + " ms");
        System.out.println("Tiempo de ejecución: " + ((fin - inicio) / 1000.0) + " segundos");

    }
}
