import impl.GrafoDFS;
import impl.GrafoMA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DFS {
    public static void main(String[] args) {

        GrafoDFS g = new GrafoDFS(); //Creamos Grafo Matriz Adyacencia
        g.inicializarGrafo();

        //Agregamos Vertices;
        g.agregarVertice(1);
        g.agregarVertice(3);
        g.agregarVertice(5);
        g.agregarVertice(7);
        //Agregamos Aristas
        g.agregarArista(1,3,5);
        g.agregarArista(1,5,2);
        g.agregarArista(1,7,1);

        //Creamos una lista de visitados y una matriz copia de la matriz del grafo

        boolean [] visitados = new boolean[g.cantVertices()]; //Arreglo de si un nodo esta visitado o no
        int [][] matriz = copiarMatriz(g);
        List<Integer> l = new ArrayList<>(); //Lista donde vamos agregando los nodos visitados

        System.out.println("El orden impreso representa el indice del vertice no su etiqueta");
        System.out.println("Imprimiendo Orden Recorrido");
        System.out.println();

        //Nota : Ingresar el indice del vertice no su etiqueta.
        DFS(1,visitados,matriz,l);
    }

    static void DFS(int origen, boolean[]visitados, int[][] matriz, List<Integer> l){

        l.add(origen);
        System.out.println("Orden: " + l);
        visitados[origen] = true; //marcamos como visitado el nodo

        for (int i = 0; i < matriz[origen].length; i++) {
            if (matriz[origen][i] != 0 && visitados[i] == false) { //si el nodo no esta visitado llamamos a DFS recursivamente
                DFS(i, visitados,matriz,l);
            }
        }
    }

    //Funcion que copia la matriz de aristas del grafo a una matriz de enteros.
    static int[][] copiarMatriz(GrafoDFS g) {

        int[][] adj = new int[g.cantVertices()][g.cantVertices()];

        for (int i = 0; i < g.cantVertices(); i++) {
            for (int j = 0; j < g.cantVertices(); j++) {
                if (g.matriz()[i][j] != null) {
                    adj[i][j] = g.matriz()[i][j].getPeso();
                }
            }
        }
        return adj;
    }

}
