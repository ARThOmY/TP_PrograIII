import apis.GrafoFloyd;

import java.util.Arrays;

public class Floyd {

    public static void main(String[] args) {
        GrafoFloyd g = new impl.GrafoFloyd(); //Creamos Grafo de Matriz de Adyacencia
        g.inicializarGrafo();

        //Agregamos Vertices
        g.agregarVertice(2);
        g.agregarVertice(3);
        g.agregarVertice(7);
        g.agregarVertice(9);

        //Agregamos Aristas
        g.agregarArista(2, 9, 2);
        g.agregarArista(9, 7, 10);
        g.agregarArista(2, 3, 6);
        g.agregarArista(3, 9, 8);
        g.agregarArista(7, 2, 13);

        System.out.println("ACLARACIONES!!!");
        System.out.println("-El valor 99 significa que no existe camino que conecte esos vertices.");
        System.out.println("-El valor de la celda de la matriz es el costo total del camino entre los vertices.");
        System.out.println();
        System.out.println("Matriz de Costos quedaria siguiente Manera:");

        //Llamado funcion Floyd
        floyd(g.matriz(), g);

        //Imprimimos Matriz por cada fila saltamos de linea para mejor lectura
        for (int i = 0; i < g.verticesTot().size(); ++i) {
            System.out.println(Arrays.toString(g.matriz()[i]));
        }
    }

    static void floyd(int[][] camino, GrafoFloyd g) {

        int vertices = g.cantVertices();

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                for (int k = 0; k < vertices; k++) {
                    if (camino[j][i] + camino[i][k] < camino[j][k])
                        //sumamos los costos en la celda de costos del par de vertices
                        camino[j][k] = camino[j][i] + camino[i][k];
                }
            }
        }
    }
}


