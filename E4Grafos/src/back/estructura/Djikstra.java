/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.estructura;

/**
 *
 * @author jra
 */
public class Djikstra {
    
    public static int dijkstra(int[][] grafo, int origen, int destino) {
        int v = grafo.length;
        int[] distancias = new int[v];
        boolean[] visitado = new boolean[v];

        for (int i = 0; i < v; i++) {
            distancias[i] = Integer.MAX_VALUE;
            visitado[i] = false;
        }

        distancias[origen] = 0;

        for (int i = 0; i < v - 1; i++) {
            int u = distanciaMinima(distancias, visitado);
            visitado[u] = true;

            for (int j = 0; j < v; j++) {
                if (!visitado[j] && grafo[u][j] != 0 && distancias[u] != Integer.MAX_VALUE 
                    && distancias[u] + grafo[u][j] < distancias[j]) {
                    distancias[j] = distancias[u] + grafo[u][j];
                }
            }
        }
        return distancias[destino];
    }

    private static int distanciaMinima(int[] distancias, boolean[] visitado) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < distancias.length; i++) {
            if (!visitado[i] && distancias[i] <= min) {
                min = distancias[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}
