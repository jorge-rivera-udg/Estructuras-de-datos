/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.estructura;

import back.modelo.Nodo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jra
 */
public class CaminosNodo {
    private Map<Nodo, List<Arista>> grafo;

    public CaminosNodo() {
        grafo = new HashMap<>();
    }
    
    public CaminosNodo(Map<Nodo,List<Arista>> g) {
        grafo = g;
    }

    public void agregarArista(Nodo origen, Nodo destino, int precio) {
        grafo.computeIfAbsent(origen, k -> new ArrayList<>()).add(new Arista(destino, precio));
    }

    public Map<List<Nodo>,Integer> encontrarTodosLosCaminos(Nodo inicio, Nodo fin) {
        Map<List<Nodo>,Integer> resultados = new HashMap<>();
        List<Nodo> caminoActual = new ArrayList<>();
        Set<Nodo> visitados = new HashSet<>();
        int costoCamino = 0;
        
        dfs(inicio, fin, visitados, caminoActual, resultados, costoCamino);
        return resultados;
    }

    private void dfs(Nodo actual, Nodo fin, Set<Nodo> visitados, 
                     List<Nodo> caminoActual, Map<List<Nodo>,Integer> resultados, int costoCamino) {
        
        visitados.add(actual);
        caminoActual.add(actual);

        if (actual.equals(fin)) {
            resultados.put(new ArrayList<>(caminoActual),costoCamino);
        } else {
            if (grafo.containsKey(actual)) {
                for (Arista vecino : grafo.get(actual)) {
                    if (!visitados.contains(vecino.getDestino())) {
                        dfs(vecino.getDestino(), fin, visitados, caminoActual, resultados, costoCamino += vecino.getPeso());
                    }
                }
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
        visitados.remove(actual);
    }

//    public static void main(String[] args) {
//        CaminosNodo g = new CaminosNodo();
//        g.agregarArista(new Nodo(new Ciudad("0")), new Nodo(new Ciudad("1")), 10);
//        g.agregarArista(new Nodo(new Ciudad("0")), new Nodo(new Ciudad("2")), 15);
//        g.agregarArista(new Nodo(new Ciudad("1")), new Nodo(new Ciudad("3")), 12);
//        g.agregarArista(new Nodo(new Ciudad("2")), new Nodo(new Ciudad("1")), 10);
//        g.agregarArista(new Nodo(new Ciudad("2")), new Nodo(new Ciudad("3")), 5);
//
//        Map<List<Nodo>,Integer> paths = g.encontrarTodosLosCaminos(new Nodo(new Ciudad("0")),new Nodo(new Ciudad("3")));
//        System.out.println("Caminos encontrados: " + paths);
//        // Salida: [[0, 1, 3], [0, 2, 1, 3], [0, 2, 3]]
//    }
}