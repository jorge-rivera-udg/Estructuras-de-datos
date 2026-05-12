/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.estructura;

import back.modelo.Ciudad;
import back.modelo.Nodo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jra
 */
public class Grafo {
    private List<Nodo> nodos;
    private Map<Integer,String> ciudades;
    private List<List<String>> rutas = null;
    private Map<List<Nodo>,Integer> caminos = null;
    private int [][] matriz;

    public Grafo() {
        nodos = new ArrayList<>();
    }
    
    public Nodo nuevoNodo(int x, int y, Ciudad ciudad){
        Nodo tmp = new Nodo();
        tmp.setCiudad(ciudad);
        tmp.setAristas(new ArrayList<>());
        tmp.x = x;
        tmp.y = y;
        return tmp;
    }
    
    public List<Nodo> getNodos(){
        return nodos;
    }
    
    public int tieneNodo(Ciudad ciudad){
        return nodos.indexOf(new Nodo(ciudad));
    }
    
    public int tieneNodo(Nodo nodo){
        return nodos.indexOf(nodo);
    }
    
    public boolean agregarConexion(Nodo o, Nodo d, int peso){
        int i = tieneNodo(o);
        if(i>-1){
            return nodos.get(i).agregarArista(d, peso);
        }
        return false;
    }
    
    public boolean eliminarConexion(Nodo o, Nodo d){
        int i = tieneNodo(o);
        if(i>-1){
            return nodos.get(i).removerArista(d);
        }
        return false;
    }
    
    public boolean agregarCiudad(Ciudad ciudad){
        nodos.add(nuevoNodo(0,0,ciudad));
        return true;
    }
    
    public boolean eliminarCiudad(Ciudad ciudad){
        Nodo tmp = new Nodo(ciudad);
        nodos.forEach(nodo -> {
            eliminarConexion(nodo,tmp);
        });
        return nodos.remove(new Nodo(ciudad));
    }
    
    private void creaMatriz(){
        int n = nodos.size();
        ciudades = listaCiudades();
        matriz = new int[n][n];
        List<Arista> tmp = null;
        for(int i=0; i<n; i++){
            tmp = nodos.get(i).getAristas();
            for(int j=0; j<n; j++){
                if(i==j){
                    matriz[i][j]=0;
                } else {
                    for(int k=0; k<tmp.size(); k++){
                        if(ciudades.get(j).equals(tmp.get(k).getDestino().getCiudad().getNombre())){
                            matriz[i][j]=tmp.get(k).getPeso();
                        } else {
                            matriz[i][j]=0;
                        }
                    }
                }
            }
        }
    }
    
    private Map<Integer,String> listaCiudades(){
        Map<Integer,String> lista = new HashMap<>();
        for(int cont = 0; cont<nodos.size(); cont++){
            lista.put(cont, nodos.get(cont).getCiudad().getNombre());
        }
        return lista;
    }
    
    private int obtenerIndice(Nodo n) {
        for(int i=0; i<nodos.size(); i++){
            if(n.getCiudad().getNombre().equals(ciudades.get(i))) {
                return i;
            }
        }
        return -1;
    }
    
    public List<List<String>> determinarRutas(Nodo o, Nodo d){
        Map<String,List<String>> g = new HashMap<>();
        
        nodos.forEach(nodo -> {
            List<String> tmp = new ArrayList<>();
            nodo.getAristas().forEach(arista -> {
                tmp.add(arista.getDestino().getCiudad().getNombre());
            });
            g.put(nodo.getCiudad().getNombre(), tmp);
        });
        
        Caminos c = new Caminos(g);
        
        rutas = c.encontrarTodosLosCaminos(o.getCiudad().getNombre(), d.getCiudad().getNombre());
        return rutas;
    }
    
    public Map<List<Nodo>,Integer> determinarRutasConCosto(Nodo o, Nodo d) {
        Map<Nodo,List<Arista>> g = new HashMap<>();
        nodos.forEach(nodo -> {
            g.put(nodo, nodo.getAristas());
        });
        
        CaminosNodo cn = new CaminosNodo(g);
        caminos = cn.encontrarTodosLosCaminos(o, d); 
        return caminos;
    }
    
    public List<String> caminoMasCorto(Nodo o, Nodo d){
        List<String> respuesta = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        List<Nodo> camino = Collections.EMPTY_LIST;
        
        if(caminos == null) caminos = determinarRutasConCosto(o, d);
        
        for(List<Nodo> key : caminos.keySet()) {
            int tmp = caminos.get(key);
            if(tmp<min) {
                min = tmp;
                camino = key;
            }
        }
        
        for(Nodo n: camino) {
            respuesta.add(n.getCiudad().getNombre());
        }
        
        respuesta.add("Costo de camino: "+min);

        return respuesta;
    }
        
    private int valorCaminoMinimo(Nodo o, Nodo d){
        creaMatriz();
        int origen = obtenerIndice(o);
        int destino = obtenerIndice(d);
        
        if(origen>-1 && destino>-1)
            return Djikstra.dijkstra(matriz,origen,destino);
        
        return -1;
    }
}
