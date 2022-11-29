import impl.GrafoFloyd;

public class Prim {

    public static void main(String[] args) {

        //Usamos el mismo tipo de grafo que para floyd para no crear otra clase grafo

        GrafoFloyd g = new GrafoFloyd(); //Creamos Grafo de Matriz de Adyacencia
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

        System.out.println();
        System.out.println("El ARMC queda conformado por estas Aristas");
        System.out.println();

        int [][] armc = Prim(g.matriz(), g.cantVertices(), 0);
        int costo = 0; // Variable que va a sumar el costo del arbol

        //Imprimimos el Arbol dandole un formato
        for (int[] i: armc) {
            for (int j: i) {
                if (j!=0){
                    System.out.println("Peso Arista: " + j);
                    costo += j;
                }
            }
        }
        System.out.println("Costo Total Arbol: " +  costo);
    }

    //Funcion Prim
    static int[][] Prim(int matriz[][], int vertices, int arco) {

        int[][] armc = new int[vertices][vertices]; //Creamos una matriz donde vamos guardando las aristas del arbol
        int infinito = 99; //variable infinito
        boolean[] marcado = new boolean[vertices];

        marcado[0] = true; //Al primer elemento lo marcamos

        while (arco < vertices - 1) { //Nos aseguramos de tener menos arcos que vertices
            int min = infinito;
            int x = 0;
            int y = 0;

            for (int i = 0; i < vertices; i++) { //recorremos la matriz
                if (marcado[i] == true) { //si en el arreglo de marcados ese vertice es true recorremos el arreglo[i] de la matriz
                    for (int j = 0; j < vertices; j++) {
                        if (!marcado[j] && matriz[i][j] != 0) { //si en el arreglo de marcados el vertice es true y existe arista
                            if (min > matriz[i][j]) { //si 99 es mayor al peso cambiamos el min al peso de la arista
                                min = matriz[i][j];
                                x = i; //guardamos i en x
                                y = j; //guardamos y en j
                            }
                        }
                    }
                }
            }

            armc[x][y] = matriz[x][y]; //agregamos el peso del arco al arbol
            marcado[y] = true; //marcamos el vertice
            arco++;
        }
        return armc;
    }
}
