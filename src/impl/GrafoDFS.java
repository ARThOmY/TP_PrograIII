package impl;

import apis.ConjuntoTDA;


import java.util.ArrayList;
import java.util.List;

public class GrafoDFS implements apis.GrafoDFS {
    static int n = 100;
    Arista[][] MAdy;
    int[] Etiqs;
    int cantNodos;

    public GrafoDFS() {
    }

    public void inicializarGrafo() {
        this.MAdy = new Arista[n][n];
        this.Etiqs = new int[n];
        this.cantNodos = 0;
    }

    public Arista[][] matriz(){
        return MAdy;
    }

    public void agregarVertice(int v) {
        this.Etiqs[this.cantNodos] = v;

        ++this.cantNodos;
    }

    public int cantVertices(){
        return this.cantNodos;
    }

    @Override
    public int cantAristas() {
        return aristas().size() / 2;
    }

    public void eliminarVertice(int v) {
        int ind = this.Vert2Indice(v);

        int k;
        for(k = 0; k < this.cantNodos; ++k) {
            this.MAdy[k][ind] = this.MAdy[k][this.cantNodos - 1];
        }

        for(k = 0; k < this.cantNodos; ++k) {
            this.MAdy[ind][k] = this.MAdy[this.cantNodos - 1][k];
        }

        this.Etiqs[ind] = this.Etiqs[this.cantNodos - 1];
        --this.cantNodos;
    }

    private int Vert2Indice(int v) {
        int i;
        for(i = this.cantNodos - 1; i >= 0 && this.Etiqs[i] != v; --i) {

        }

        return i;
    }

    public ConjuntoTDA vertices() {
        ConjuntoTDA Vert = new ConjuntoLD();
        Vert.inicializarConjunto();

        for(int i = 0; i < this.cantNodos; ++i) {
            Vert.agregar(this.Etiqs[i]);
        }

        return Vert;
    }

    public void agregarArista(int v1, int v2, int peso) {
        int o = this.Vert2Indice(v1);
        int d = this.Vert2Indice(v2);
        this.MAdy[o][d] = new Arista(v1,v2,peso);
        this.MAdy[d][o] = new Arista(v2,v1,peso);
    }

    public void eliminarArista(int v1, int v2) {
        int o = this.Vert2Indice(v1);
        int d = this.Vert2Indice(v2);
        this.MAdy[o][d] = null;
        this.MAdy[d][o] = null;
    }

    public boolean existeArista(int v1, int v2) {
        int o = this.Vert2Indice(v1);
        int d = this.Vert2Indice(v2);
        return this.MAdy[o][d] != null;
    }

    public int pesoArista(int v1, int v2) {
        int o = this.Vert2Indice(v1);
        int d = this.Vert2Indice(v2);
        return this.MAdy[o][d].peso;
    }

    public ArrayList<Arista> aristas() {

        ArrayList<Arista> l = new ArrayList<>();

        for (int i = 0; i < cantNodos; i++) {
            for (int j = 0; j < cantNodos; j++) {
                if (MAdy[i][j] != null) {
                    l.add(MAdy[i][j]);
                }
            }
        }
        return l;
    }

    public ArrayList<String> verticesAdyacentes(int v) {
        ArrayList<String> lista = new ArrayList<>();
        ConjuntoTDA c = new ConjuntoLD();
        c.inicializarConjunto();
        c = this.vertices();

        while(!c.conjuntoVacio()){
            int ver = c.elegir();
            if(existeArista(ver, v)){
                lista.add(String.valueOf(ver));
                c.sacar(ver);
            }
            else{
                c.sacar(ver);
            }
        }
        return lista;
    }

    public List<Integer> verticesTot(){
        List<Integer> l = new ArrayList<>();

        for(int i = 0; i< cantNodos; i++){
            l.add(this.Etiqs[i]);
        }

        return l;
    }
}