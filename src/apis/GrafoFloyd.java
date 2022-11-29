package apis;

import java.util.ArrayList;
import java.util.List;

public interface GrafoFloyd {
    void inicializarGrafo();

    void agregarVertice(int var1);

    void eliminarVertice(int var1);

    ConjuntoTDA vertices();

    void agregarArista(int var1, int var2, int var3);

    int cantVertices();

    int cantAristas();

    void eliminarArista(int var1, int var2);

    boolean existeArista(int var1, int var2);

    int pesoArista(int var1, int var2);

    ArrayList<String> verticesAdyacentes(int var1);

    //ArrayList<Arista> aristas();

    List<Integer> verticesTot();

    int[][] matriz();

}