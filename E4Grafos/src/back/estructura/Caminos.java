/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.estructura;

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
public class Caminos {
    private Map<String, List<String>> grafo;

    public Caminos() {
        grafo = new HashMap<>();
    }
    
    public Caminos(Map<String,List<String>> g) {
        grafo = g;
    }

    public void agregarArista(String origen, String destino) {
        grafo.computeIfAbsent(origen, k -> new ArrayList<>()).add(destino);
    }

    public List<List<String>> encontrarTodosLosCaminos(String inicio, String fin) {
        List<List<String>> resultados = new ArrayList<>();
        List<String> caminoActual = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        
        dfs(inicio, fin, visitados, caminoActual, resultados);
        return resultados;
    }

    private void dfs(String actual, String fin, Set<String> visitados, 
                     List<String> caminoActual, List<List<String>> resultados) {
        
        visitados.add(actual);
        caminoActual.add(actual);

        if (actual.equals(fin)) {
            resultados.add(new ArrayList<>(caminoActual));
        } else {
            if (grafo.containsKey(actual)) {
                for (String vecino : grafo.get(actual)) {
                    if (!visitados.contains(vecino)) {
                        dfs(vecino, fin, visitados, caminoActual, resultados);
                    }
                }
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
        visitados.remove(actual);
    }

//    public static void main(String[] args) {
//        Caminos g = new Caminos();
//        g.agregarArista("0", "1");
//        g.agregarArista("0", "2");
//        g.agregarArista("1", "3");
//        g.agregarArista("2", "1");
//        g.agregarArista("2", "3");
//
//        List<List<String>> paths = g.encontrarTodosLosCaminos("0", "3");
//        System.out.println("Caminos encontrados: " + paths);
//        // Salida: [[0, 1, 3], [0, 2, 1, 3], [0, 2, 3]]
//    }
}